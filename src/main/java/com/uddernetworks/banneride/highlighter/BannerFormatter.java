package com.uddernetworks.banneride.highlighter;

import com.uddernetworks.banneride.main.BannerGrid;
import com.uddernetworks.banneride.main.BannerLetter;
import org.bukkit.DyeColor;

import java.util.List;


public class BannerFormatter {

    public void formatBanners(BannerGrid grid, String coloredText) {
        String[] lines = coloredText.split("\n");

        for (int i = 0; i < lines.length; i++) {
            List<BannerLetter> row = grid.getRow(i);
            String[] chars = lines[i].split(" ");

            for (int i2 = 0; i2 < chars.length; i2++) {
                String color = chars[i2];
                if (!color.trim().equals("")) {
                    row.get(i2).setColor(DyeColor.valueOf(color));
                }
            }
        }
    }
}
