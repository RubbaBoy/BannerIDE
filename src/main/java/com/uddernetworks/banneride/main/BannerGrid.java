package com.uddernetworks.banneride.main;

import java.util.ArrayList;
import java.util.List;

public class BannerGrid {

    private List<List<BannerLetter>> grid = new ArrayList<>();
    private String code;

    public BannerGrid() {

    }

    public List<BannerLetter> getRow(int row) {
        return grid.get(row);
    }

    public void setRow(List<BannerLetter> row, int index) {
        grid.set(index, row);
    }

    public void addRow(List<BannerLetter> row) {
        grid.add(row);
    }

    public String getCode() {
        if (this.code == null) {
            StringBuilder builder = new StringBuilder();

            for (List<BannerLetter> row : grid) {
                for (BannerLetter bannerLetter : row) {
                    builder.append(bannerLetter.getLetter());
                }

                builder.append("\n");
            }

            this.code = builder.toString();
        }

        return this.code;
    }

    public boolean rowInBounds(int index) {
        return grid.size() > index && index >= 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (List<BannerLetter> row : grid) {
            for (BannerLetter letter : row) {
                builder.append(letter);
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}
