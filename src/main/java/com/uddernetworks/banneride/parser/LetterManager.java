package com.uddernetworks.banneride.parser;

import org.bukkit.DyeColor;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;

import static org.bukkit.DyeColor.BLACK;
import static org.bukkit.DyeColor.WHITE;
import static org.bukkit.block.banner.PatternType.*;

import java.util.*;

public class LetterManager {

    private Map<List<Pattern>, String> patterns = new HashMap<>();

    public LetterManager() {
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, BORDER)), "a");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, CURLY_BORDER), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, PatternType.SQUARE_BOTTOM_LEFT), new Pattern(BLACK, SQUARE_TOP_LEFT), new Pattern(WHITE, BORDER)), "b");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "c");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_RIGHT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, CURLY_BORDER), new Pattern(BLACK, STRIPE_LEFT), new Pattern(WHITE, BORDER)), "d");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, STRIPE_TOP), new Pattern(WHITE, BORDER)), "e");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, BORDER)), "f");
        patterns.put(Arrays.asList(new Pattern(BLACK, DIAGONAL_RIGHT_MIRROR), new Pattern(WHITE, HALF_HORIZONTAL), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(WHITE, BORDER)), "g");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, BORDER)), "h");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_CENTER), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "i");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(WHITE, HALF_HORIZONTAL), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "j");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(WHITE, HALF_HORIZONTAL), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, BORDER)), "k");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "l");
        patterns.put(Arrays.asList(new Pattern(BLACK, TRIANGLE_TOP), new Pattern(WHITE, PatternType.TRIANGLES_TOP), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "m");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "n");
        patterns.put(Arrays.asList(new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "o");
        patterns.put(Arrays.asList(new Pattern(BLACK, HALF_HORIZONTAL), new Pattern(WHITE, STRIPE_CENTER), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, STRIPE_LEFT), new Pattern(WHITE, BORDER)), "p");
        patterns.put(Arrays.asList(new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, SQUARE_BOTTOM_RIGHT), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "q");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, DIAGONAL_RIGHT_MIRROR), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, HALF_HORIZONTAL), new Pattern(WHITE, STRIPE_CENTER), new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(BLACK, CIRCLE_MIDDLE), new Pattern(WHITE, TRIANGLE_TOP), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, BORDER)), "r");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, DIAGONAL_RIGHT_MIRROR), new Pattern(BLACK, STRIPE_TOP), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(WHITE, BORDER)), "s");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_CENTER), new Pattern(WHITE, BORDER)), "t");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "u");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(WHITE, PatternType.SQUARE_BOTTOM_LEFT), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, BORDER)), "v");
        patterns.put(Arrays.asList(new Pattern(BLACK, TRIANGLE_BOTTOM), new Pattern(WHITE, TRIANGLES_BOTTOM), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "w");
        patterns.put(Arrays.asList(new Pattern(BLACK, CROSS), new Pattern(WHITE, BORDER), new Pattern(WHITE, CURLY_BORDER)), "x");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(WHITE, SQUARE_BOTTOM_RIGHT), new Pattern(WHITE, STRIPE_RIGHT), new Pattern(WHITE, HALF_VERTICAL_MIRROR), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, CURLY_BORDER)), "y");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "z");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_CENTER), new Pattern(BLACK, SQUARE_TOP_LEFT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "1");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_TOP), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "2");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "3");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_LEFT), new Pattern(WHITE, HALF_HORIZONTAL_MIRROR), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "4");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(BLACK, STRIPE_TOP), new Pattern(WHITE, BORDER)), "5");
        patterns.put(Arrays.asList(new Pattern(BLACK, HALF_HORIZONTAL_MIRROR), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(WHITE, BORDER)), "6");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, BORDER)), "7");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, BORDER)), "8");
        patterns.put(Arrays.asList(new Pattern(BLACK, HALF_HORIZONTAL), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, BORDER)), "9");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_RIGHT), new Pattern(BLACK, STRIPE_BOTTOM), new Pattern(BLACK, STRIPE_LEFT), new Pattern(BLACK, STRIPE_TOP), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, BORDER)), "0");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_CENTER), new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, STRIPE_TOP), new Pattern(WHITE, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "+");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_MIDDLE), new Pattern(WHITE, BORDER)), "-");
        patterns.put(Arrays.asList(new Pattern(BLACK, FLOWER), new Pattern(BLACK, CIRCLE_MIDDLE)), "*");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, BORDER)), "/");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(WHITE, CURLY_BORDER), new Pattern(WHITE, BORDER)), "%");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_CENTER), new Pattern(BLACK, SQUARE_BOTTOM_RIGHT), new Pattern(BLACK, SQUARE_TOP_RIGHT), new Pattern(WHITE, BORDER)), "[");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_CENTER), new Pattern(BLACK, SQUARE_TOP_LEFT), new Pattern(BLACK, PatternType.SQUARE_BOTTOM_LEFT), new Pattern(WHITE, BORDER)), "]");
        patterns.put(Arrays.asList(new Pattern(BLACK, CREEPER), new Pattern(WHITE, HALF_VERTICAL), new Pattern(WHITE, HALF_HORIZONTAL), new Pattern(WHITE, STRIPE_MIDDLE)), ",");
        patterns.put(Arrays.asList(new Pattern(WHITE, STRIPE_MIDDLE), new Pattern(WHITE, STRIPE_TOP), new Pattern(WHITE, STRIPE_BOTTOM), new Pattern(WHITE, BORDER)), "=");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_CENTER), new Pattern(WHITE, STRIPE_BOTTOM), new Pattern(BLACK, TRIANGLES_BOTTOM), new Pattern(WHITE, STRIPE_RIGHT), new Pattern(WHITE, STRIPE_LEFT), new Pattern(WHITE, BORDER)), "!");
        patterns.put(Arrays.asList(new Pattern(BLACK, CROSS), new Pattern(WHITE, DIAGONAL_RIGHT), new Pattern(WHITE, DIAGONAL_RIGHT_MIRROR), new Pattern(WHITE, CURLY_BORDER)), ">");
        patterns.put(Arrays.asList(new Pattern(BLACK, CROSS), new Pattern(WHITE, DIAGONAL_LEFT_MIRROR), new Pattern(WHITE, DIAGONAL_LEFT), new Pattern(WHITE, CURLY_BORDER)), "<");
        patterns.put(Arrays.asList(new Pattern(BLACK, TRIANGLES_BOTTOM), new Pattern(WHITE, STRIPE_LEFT), new Pattern(WHITE, STRIPE_RIGHT), new Pattern(WHITE, CURLY_BORDER)), ".");
        patterns.put(Arrays.asList(new Pattern(WHITE, STRIPE_RIGHT), new Pattern(WHITE, STRIPE_LEFT), new Pattern(WHITE, HALF_HORIZONTAL_MIRROR), new Pattern(WHITE, BORDER)), "\'");
        patterns.put(Arrays.asList(new Pattern(WHITE, HALF_HORIZONTAL_MIRROR), new Pattern(WHITE, STRIPE_CENTER), new Pattern(WHITE, BORDER)), "\"");
        patterns.put(Arrays.asList(new Pattern(BLACK, DIAGONAL_LEFT), new Pattern(BLACK, DIAGONAL_LEFT_MIRROR), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_LEFT), new Pattern(WHITE, CURLY_BORDER), new Pattern(WHITE, BORDER), new Pattern(WHITE, HALF_VERTICAL_MIRROR)), "{");
        patterns.put(Arrays.asList(new Pattern(BLACK, DIAGONAL_RIGHT), new Pattern(BLACK, DIAGONAL_RIGHT_MIRROR), new Pattern(WHITE, RHOMBUS_MIDDLE), new Pattern(BLACK, STRIPE_RIGHT), new Pattern(WHITE, CURLY_BORDER), new Pattern(WHITE, BORDER), new Pattern(WHITE, HALF_VERTICAL)), "}");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(WHITE, HALF_VERTICAL)), "(");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_DOWNLEFT), new Pattern(BLACK, STRIPE_DOWNRIGHT), new Pattern(WHITE, HALF_VERTICAL_MIRROR)), ")");
        patterns.put(Arrays.asList(new Pattern(BLACK, STRIPE_CENTER), new Pattern(WHITE, BORDER), new Pattern(WHITE, STRIPE_MIDDLE), new Pattern(WHITE, STRIPE_TOP)), ";");
    }

    public List<List<Pattern>> getBanners() {
        return new ArrayList<>(patterns.keySet());
    }

    public List<Pattern> getPatternForLetter(String letter) {
        for (List<Pattern> pattern : patterns.keySet()) {
            if (patterns.get(pattern).equalsIgnoreCase(letter)) return pattern;
        }

        return new ArrayList<>();
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
