package com.uddernetworks.banneride.highlighter;

import com.uddernetworks.banneride.main.BannerGrid;
import com.uddernetworks.banneride.main.BannerLetter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AngrySquiggleHighlighter {

    private Map<BannerGrid, List<Diagnostic<? extends JavaFileObject>>> errors;
    private Player player;

    public AngrySquiggleHighlighter(Map<BannerGrid, List<Diagnostic<? extends JavaFileObject>>> errors, Player player) {
        this.errors = errors;
        this.player = player;
    }

    public void highlightAll() {
        for (BannerGrid bookClass : errors.keySet()) {
            List<Diagnostic<? extends JavaFileObject>> bookErrors = errors.get(bookClass);
            highlight(bookClass, bookErrors);
        }
    }

    private void highlight(BannerGrid bookClass, List<Diagnostic<? extends JavaFileObject>> bookErrors) {
        for (Diagnostic<? extends JavaFileObject> diagnostic : bookErrors) {
            String err = "Error in class " + (diagnostic.getSource().getName().substring(1).replace("/", ".")) + " [" + diagnostic.getLineNumber() + ":" + (diagnostic.getColumnNumber() == -1 ? "?" : diagnostic.getColumnNumber()) + "] " + diagnostic.getMessage(Locale.ENGLISH);
            System.out.println(err);
            player.sendMessage(ChatColor.RED + err);

            highlightLocation(bookClass, (int) diagnostic.getLineNumber(), (int) diagnostic.getColumnNumber(), (int) (diagnostic.getEndPosition() - diagnostic.getStartPosition()));
        }
    }

    private void highlightLocation(BannerGrid bookClass, int lineNumber, int columnNumber, int length) {
        lineNumber--;
        columnNumber -= 2;
        length++;

        for (int i = columnNumber; i < columnNumber + length; i++) {
            if (!bookClass.rowInBounds(i)) continue;

            List<BannerLetter> list = bookClass.getRow(lineNumber);

            if (i < list.size()) {
                bookClass.getRow(lineNumber).get(i).setHighlighted(true);
            }
        }
    }
}