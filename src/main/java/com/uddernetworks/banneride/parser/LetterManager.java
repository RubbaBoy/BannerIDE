package com.uddernetworks.banneride.parser;

import com.uddernetworks.banneride.main.Main;
import com.uddernetworks.config.Config;
import org.bukkit.DyeColor;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bukkit.DyeColor.WHITE;

public class LetterManager {

    private Map<List<Pattern>, String> patterns = new HashMap<>();

    private List<Pattern> convertToPatterns(String input) {
        List<Pattern> ret = new ArrayList<>();
        String[] parts = input.split(", ");


        DyeColor color = null;
        for (int i = 0; i < parts.length; i++) {
            if (i % 2 == 0) {
                color = DyeColor.valueOf(parts[i]);
            } else {
                PatternType type = PatternType.valueOf(parts[i]);
                ret.add(new Pattern(color, type));
            }
        }

        return ret;
    }

    public LetterManager(Main main) {
        Config config = new Config("letters.yml", main.getDataFolder());
        config.getOptions().setDefaults("letters.yml");
        config.initialize(this);

        Map<String, Object> values = config.getValues(true);

        for(Map.Entry<String, Object> entry : values.entrySet()) {
            String banners = String.valueOf(entry.getValue());
            String key = String.valueOf(entry.getKey());

            if (key.equals("period")) {
                patterns.put(convertToPatterns(banners), ".");
            } else {
                patterns.put(convertToPatterns(banners), String.valueOf(entry.getKey()));
            }

        }
    }

    public List<List<Pattern>> getBanners() {
        return new ArrayList<>(patterns.keySet());
    }

    public String getLetterFromPattern(Banner banner) {
        List<PatternType> types = new ArrayList<>();
        banner.getPatterns().stream().forEachOrdered(pattern -> types.add(pattern.getPattern()));

        boolean uppercase = banner.getBaseColor() != WHITE;

        for (List<Pattern> patterns : patterns.keySet()) {
            List<PatternType> newTypes = new ArrayList<>();
            patterns.stream().forEachOrdered(pattern -> newTypes.add(pattern.getPattern()));

            String ret = this.patterns.get(patterns);

            if (types.equals(newTypes)) {
                if (ret.equalsIgnoreCase("o")) {
                    return !uppercase ? ret.toUpperCase() : ret;
                } else {
                    return uppercase ? ret.toUpperCase() : ret;
                }
            }
        }

        return " ";
    }

}
