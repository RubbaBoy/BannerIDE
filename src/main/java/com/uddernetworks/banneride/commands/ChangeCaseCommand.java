package com.uddernetworks.banneride.commands;

import com.uddernetworks.command.Argument;
import com.uddernetworks.command.ArgumentError;
import com.uddernetworks.command.ArgumentList;
import com.uddernetworks.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

@Command(name = "changecase", aliases={"cc"}, consoleAllow = false, minArgs = 1, maxArgs = 1)
public class ChangeCaseCommand {

    @Argument(format = "*")
    public void toggle(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;
        ItemStack[] items = player.getInventory().getContents();

        boolean toUppercase = args.nextArg().getBoolean();

        for (int i = 0; i < items.length; i++) {
            ItemStack item = player.getInventory().getContents()[i];
            if (item == null) continue;
            if (item.getType() == Material.BANNER || item.getType() == Material.WALL_BANNER || item.getType() == Material.STANDING_BANNER) {

                BannerMeta meta = (BannerMeta) item.getItemMeta();

                if (toUppercase) {
                    meta.setBaseColor(DyeColor.YELLOW);

                    List<Pattern> patterns = meta.getPatterns();
                    List<Pattern> newPatterns = new ArrayList<>();

                    for (Pattern pattern : patterns) {
                        if (pattern.getColor() == DyeColor.WHITE) {
                            newPatterns.add(new Pattern(DyeColor.YELLOW, pattern.getPattern()));
                        } else {
                            newPatterns.add(new Pattern(pattern.getColor(), pattern.getPattern()));
                        }
                    }

                    meta.setPatterns(newPatterns);

                } else {
                    meta.setBaseColor(DyeColor.WHITE);

                    List<Pattern> patterns = meta.getPatterns();
                    List<Pattern> newPatterns = new ArrayList<>();

                    for (Pattern pattern : patterns) {
                        if (pattern.getColor() == DyeColor.YELLOW) {
                            newPatterns.add(new Pattern(DyeColor.WHITE, pattern.getPattern()));
                        } else {
                            newPatterns.add(new Pattern(pattern.getColor(), pattern.getPattern()));
                        }
                    }

                    meta.setPatterns(newPatterns);
                }

                item.setItemMeta(meta);

            }
        }

        player.updateInventory();

    }

    @ArgumentError
    public void argumentError(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + "Error while executing command: " + message);
    }

}
