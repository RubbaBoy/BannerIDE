package com.uddernetworks.banneride.main;

import java.util.ArrayList;
import java.util.List;

public class BannerGrid {

    private List<List<BannerLetter>> grid = new ArrayList<>();

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
