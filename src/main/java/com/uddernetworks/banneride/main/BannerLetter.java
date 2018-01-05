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

    private boolean highlighted = false;
    private final String letter;
    private final Location location;
    private Banner banner;
    private DyeColor letterColor;

    public BannerLetter(String letter, Location location) {
        this.letter = letter;
        this.location = location;

        Block block = location.getBlock();

        if (block.getType() != Material.WALL_BANNER) return;

        this.banner = (Banner) block.getState();
    }

    public String getLetter() {
        return letter;
    }

    public Location getLocation() {
        return location;
    }

    public void setColor(DyeColor color) {
        this.letterColor = color;

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

    public void setHighlighted(boolean highlighted) {
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

        if (this.highlighted && !highlighted) {
            newPatterns.remove(newPatterns.size());
        } else if (!this.highlighted && highlighted) {
            newPatterns.add(new Pattern(DyeColor.RED, PatternType.TRIANGLES_BOTTOM));
        }

        banner.setPatterns(newPatterns);

        banner.update();

        this.highlighted = highlighted;
    }

    @Override
    public String toString() {
        return letter;
    }
}
