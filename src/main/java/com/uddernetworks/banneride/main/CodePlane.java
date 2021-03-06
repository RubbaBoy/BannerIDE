package com.uddernetworks.banneride.main;

import com.uddernetworks.banneride.highlighter.BannerFormatter;
import com.uddernetworks.banneride.highlighter.CustomJavaRenderer;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Banner;
import org.bukkit.block.Block;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.craftbukkit.v1_12_R1.block.CraftBlockState;
import org.bukkit.inventory.meta.BannerMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodePlane {

    private Main main;
    private World world;
    private Location topLeft;
    private Location bottomRight;

    public CodePlane(Main main, World world, Location playerLocation) {
        this.main = main;
        this.world = world;
        topLeft = playerLocation.clone().add(25, 25, 25);
        bottomRight = playerLocation.clone().add(-25, -25, 25);
    }

    public void generate() {
        for (int y = topLeft.getBlockY(); y > bottomRight.getBlockY(); y--) {
            for (int x = topLeft.getBlockX(); x > bottomRight.getBlockX(); x--) {
                Block block = world.getBlockAt(x, y, topLeft.getBlockZ() + 1);

                block.setType(Material.WOOL);
                block.setData((byte) 0);
            }
        }
    }

    public BannerGrid readWall() throws IOException {
        BannerGrid bannerGrid = new BannerGrid();

        for (int y = topLeft.getBlockY(); y > bottomRight.getBlockY(); y--) {
            List<BannerLetter> row = new ArrayList<>();

            for (int x = topLeft.getBlockX(); x > bottomRight.getBlockX(); x--) {
                Block block =  world.getBlockAt(x, y, topLeft.getBlockZ());

                if (block.getType() == Material.WALL_BANNER) {
                    Banner banner = (Banner) block.getState();

                    Pattern end = banner.getPattern(banner.getPatterns().size() - 1);

                    List<Pattern> patterns = new ArrayList<>();
                    for (int i = 0; i < banner.getPatterns().size() - 1; i++) {
                        patterns.add(banner.getPattern(i));
                    }

                    if (end.getPattern() == PatternType.TRIANGLES_BOTTOM) {
                        banner.setPatterns(patterns);
                        banner.update();
                    }

                    row.add(new BannerLetter(main.getLetterManager().getLetterFromPattern(banner), block.getLocation()));
                } else {
                    row.add(new BannerLetter(" ", block.getLocation()));
                }
            }

            bannerGrid.addRow(row);
        }

        CustomJavaRenderer customJavaRenderer = new CustomJavaRenderer();
        String colors = customJavaRenderer.highlight(bannerGrid.toString());

        BannerFormatter formatter = new BannerFormatter();
        formatter.formatBanners(bannerGrid, colors);

        return bannerGrid;
    }

}
