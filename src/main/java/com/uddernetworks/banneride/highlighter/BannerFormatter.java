package com.uddernetworks.banneride.highlighter;

import com.uddernetworks.banneride.main.BannerGrid;
import com.uddernetworks.banneride.main.BannerLetter;

import java.util.List;


public class BannerFormatter {

    public void formatBanners(BannerGrid grid, String coloredText) {
        String[] lines = coloredText.split("\n");

        for (int i = 0; i < lines.length; i++) {
            List<BannerLetter> row = grid.getRow(i);
            System.out.println("line = " + lines[i]);
            String[] chars = lines[i].split("");

            for (int i2 = 0; i2 < chars.length; i2++) {
//                System.out.println("chars[i2] = " + chars[i2]);
                int curr = Integer.valueOf(chars[i2]);
                row.get(i2).setColor(curr);
            }
        }

    }

}
