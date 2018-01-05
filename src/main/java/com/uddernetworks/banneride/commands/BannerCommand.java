package com.uddernetworks.banneride.commands;

import com.uddernetworks.banneride.main.BannerGrid;
import com.uddernetworks.banneride.main.CodePlane;
import com.uddernetworks.banneride.main.Main;
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

import java.io.IOException;
import java.util.List;

@Command(name = "setup", aliases={"su"}, consoleAllow = false, minArgs = 1, maxArgs = 2)
public class BannerCommand {

    private Main main;
    private CodePlane codePlane;

    public BannerCommand(Main main) {
        this.main = main;
    }

    @Argument(format = "start")
    public void start(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;

        codePlane = new CodePlane(main, player.getWorld(), player.getLocation());
        codePlane.generate();

        player.sendMessage(ChatColor.GOLD + "Created code plane.");
    }

    @Argument(format = "stop")
    public void stop(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;

        codePlane = null;

        player.sendMessage(ChatColor.GREEN + "Stopped the current code plane.");
    }

    @Argument(format = "compile")
    public void compile(CommandSender sender, ArgumentList args) throws IOException {
        Player player = (Player) sender;

        if (codePlane == null) {
            player.sendMessage(ChatColor.RED + "Please start the system by doing " + ChatColor.RED + "/setup start <true|false>");
            return;
        }

        BannerGrid grid = codePlane.readWall();

        main.getBannerCompiler().compileBooks(grid, player, false);
    }

    @Argument(format = "execute")
    public void execute(CommandSender sender, ArgumentList args) throws IOException {
        Player player = (Player) sender;

        if (codePlane == null) {
            player.sendMessage(ChatColor.RED + "Please start the system by doing " + ChatColor.RED + "/setup start <true|false>");
            return;
        }

        BannerGrid grid = codePlane.readWall();

        main.getBannerCompiler().compileBooks(grid, player, true);
    }

    @Argument(format = "give")
    public void give(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;

        List<List<Pattern>> patterns = main.getLetterManager().getBanners();
        for (List<Pattern> patternTypes : patterns) {
            ItemStack item = new ItemStack(Material.BANNER);
            BannerMeta meta = (BannerMeta) item.getItemMeta();

            meta.setBaseColor(DyeColor.WHITE);

            for (Pattern patternType : patternTypes) {
                meta.addPattern(patternType);
            }

            item.setItemMeta(meta);

            player.getWorld().dropItemNaturally(player.getLocation(), item);
        }
    }

    @ArgumentError
    public void argumentError(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + "Error while executing command: " + message);
    }
}
