package com.uddernetworks.banneride.main;

import com.uddernetworks.banneride.highlighter.AngrySquiggleHighlighter;
import com.uddernetworks.config.Config;
import com.uddernetworks.config.ConfigSync;
import org.bukkit.entity.Player;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BannerCompiler {

    private Main main;
    private Config config;

    @ConfigSync(path = "compile.jarname")
    private String jarName = "CompiledJar.jar";

    @ConfigSync(path = "compile.otherfiles")
    private String otherFiles = "OtherFiles";

    @ConfigSync(path = "compile.classoutput")
    private String classOutputFolder = "ClassOutput";

    @ConfigSync(path = "compile.libs")
    private String libsFolder = "libs";

    public BannerCompiler(Main main) {
        this.main = main;
        this.config = new Config("config.yml", main.getDataFolder());
        this.config.getOptions().setDefaults("config.yml");
        this.config.initialize(this);
    }

    public boolean compileBooks(BannerGrid grid, Player player, boolean execute) throws IOException {
        this.config.updateAllFields();

        File jarFile = new File(main.getDataFolder(), jarName);
        File otherFile = new File(main.getDataFolder(), otherFiles);
        File classOutputFile = new File(main.getDataFolder(), classOutputFolder);
        File libsFile = new File(main.getDataFolder(), libsFolder);

        CodeCompiler codeCompiler = new CodeCompiler();
        Map<BannerGrid, List<Diagnostic<? extends JavaFileObject>>> errors = codeCompiler.compileAndExecute(player, grid, jarFile, otherFile, classOutputFile, libsFile, execute);

        AngrySquiggleHighlighter angrySquiggleHighlighter = new AngrySquiggleHighlighter(errors, player);
        angrySquiggleHighlighter.highlightAll();

        return !errors.isEmpty();
    }

}
