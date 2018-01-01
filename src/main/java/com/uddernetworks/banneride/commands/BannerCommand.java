package com.uddernetworks.banneride.commands;

import com.uddernetworks.banneride.main.CodePlane;
import com.uddernetworks.banneride.main.Main;
import com.uddernetworks.banneride.parser.LetterManager;
import com.uddernetworks.command.Argument;
import com.uddernetworks.command.ArgumentError;
import com.uddernetworks.command.ArgumentList;
import com.uddernetworks.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Command(name = "setup", aliases={"su"}, consoleAllow = false, minArgs = 1, maxArgs = 2)
public class BannerCommand {

    private Main main;
    private CodePlane codePlane;

    public BannerCommand(Main main) {
        this.main = main;
    }

    @Argument(format = "start *")
    public void start(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;
        boolean manualMode = args.nextArg().getBoolean();

        codePlane = new CodePlane(main, player.getWorld(), player.getLocation());
        codePlane.generate();
    }

    @Argument(format = "stop")
    public void stop(CommandSender sender, ArgumentList args) {

    }

    @Argument(format = "compile *")
    public void compile(CommandSender sender, ArgumentList args) throws IOException {
        Player player = (Player) sender;

        codePlane.readWall();

//        File fout = new File("E:\\AMP\\Instances\\UddernetworksMC\\Minecraft\\plugins\\stuff\\outputt.txt");
//       BufferedWriter output = new BufferedWriter(new FileWriter(fout, true));
//
////        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//
//        ItemStack hand = player.getInventory().getItemInMainHand();
//        BannerMeta bannerMeta = (BannerMeta) hand.getItemMeta();
//
//        StringBuilder print = new StringBuilder("patterns.put(Arrays.asList(");
//
//        for (Pattern pattern : bannerMeta.getPatterns()) {
//            print.append("new Pattern(DyeColor.").append(pattern.getColor()).append(", PatternType.").append(pattern.getPattern().name()).append("), ");
//        }
//
//        print = new StringBuilder(print.substring(0, print.length() - 2));
//
//        print.append("), \"").append(args.nextArg().getString()).append("\");");
//
//        output.write(print.toString());
//
//        output.write("\n");
//
//        output.close();
//
//        System.out.println(print);
    }

    @Argument(format = "execute")
    public void execute(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;
        ItemStack item = new ItemStack(Material.BANNER);

        BannerMeta meta = (BannerMeta) item.getItemMeta();

        meta.setBaseColor(DyeColor.WHITE);

        meta.addPattern(new Pattern(DyeColor.BLACK, PatternType.DIAGONAL_RIGHT));
        meta.addPattern(new Pattern(DyeColor.BLACK, PatternType.DIAGONAL_RIGHT_MIRROR));
        meta.addPattern(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE));
        meta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
        meta.addPattern(new Pattern(DyeColor.WHITE, PatternType.CURLY_BORDER));
        meta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
        meta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL));

        item.setItemMeta(meta);

        player.setItemInHand(item);
    }

    @Argument(format = "give")
    public void give(CommandSender sender, ArgumentList args) {
        Player player = (Player) sender;

//        List<List<PatternType>> patterns = main.getLetterManager().getBanners();
        List<List<PatternType>> patterns = new ArrayList<>();
        for (int i = 0; i < patterns.size(); i++) {
            List<PatternType> patternTypes = patterns.get(i);

            ItemStack item = new ItemStack(Material.BANNER);
            BannerMeta meta = (BannerMeta) item.getItemMeta();

            meta.setBaseColor(DyeColor.WHITE);

            for (PatternType patternType : patternTypes) {
                meta.addPattern(new Pattern(DyeColor.BLACK, patternType));
            }

            item.setItemMeta(meta);

            player.getInventory().setItem(i, item);
        }

    }

    @ArgumentError
    public void argumentError(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + "Error while executing command: " + message);
    }


}
