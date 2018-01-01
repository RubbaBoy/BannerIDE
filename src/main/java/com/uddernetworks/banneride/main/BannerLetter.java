package com.uddernetworks.banneride.main;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.Block;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BannerLetter {

    private final String letter;
    private final Location location;
    private List<Pattern> patterns;
    private Banner banner;
    private DyeColor letterColor;
    private List<Pattern> o = Arrays.asList(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE), new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT), new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT), new Pattern(DyeColor.WHITE, PatternType.BORDER));
//    private List<PatternType>

    public BannerLetter(String letter, Location location) {
        this.letter = letter;
        this.location = location;

        Block block = location.getBlock();

        if (block.getType() != Material.WALL_BANNER) {
            this.patterns = new ArrayList<>();
            return;
        }

        this.banner = (Banner) block.getState();

        this.patterns = new ArrayList<>(this.banner.getPatterns());
    }

    public String getLetter() {
        return letter;
    }

    public Location getLocation() {
        return location;
    }

    public void setColor(int color) {
        switch (color) {
            case 0:
                letterColor = DyeColor.BLACK;
                break;
            case 1:
                letterColor = DyeColor.BLUE;
                break;
            case 2:
                letterColor = DyeColor.GREEN;
                break;
            case 4:
                letterColor = DyeColor.RED;
                break;
            case 7:
                letterColor = DyeColor.GRAY;
                break;
        }

        if (banner == null) return;

        List<Pattern> patterns = banner.getPatterns();
        List<Pattern> newPatterns = new ArrayList<>();

        if (banner.getBaseColor() == DyeColor.BLACK) {
            banner.setBaseColor(letterColor);
        }

        for (Pattern pattern : patterns) {
            if (pattern.getColor() == DyeColor.WHITE || pattern.getColor() == DyeColor.YELLOW) {
                newPatterns.add(pattern);
            } else {
                newPatterns.add(new Pattern(letterColor, pattern.getPattern()));
            }
        }

        banner.setPatterns(newPatterns);

        banner.update();
    }

    @Override
    public String toString() {
        return letter;
    }
}
