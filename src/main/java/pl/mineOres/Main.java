package pl.mineOres;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.mineOres.configs.Config;
import pl.mineOres.listeners.PlayerBreakListener;
import pl.mineOres.listeners.PlayerJoinListener;

public class Main extends JavaPlugin {

    private static Main plugin;

    public static Main getInst() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        Config.load();


        int pluginId = 8316;
        Metrics metrics = new Metrics(this, pluginId);

        Logger.log("");
        Logger.log("           _             _____               ");
        Logger.log("          (_)           |  _  |              ");
        Logger.log(" _ __ ___  _ _ __   ___ | | | |_ __ ___  ___ ");
        Logger.log("| '_ ` _ \\| | '_ \\ / _ \\| | | | '__/ _ \\/ __|");
        Logger.log("| | | | | | | | | |  __/\\ \\_/ / | |  __/\\__ \\");
        Logger.log("|_| |_| |_|_|_| |_|\\___| \\___/|_|  \\___||___/");
        Logger.log("");
        Logger.log("Author: _arturek");
        Logger.log("Version: " + this.getDescription().getVersion());
        Logger.log("Web: https://minecodes.pl/");
        Logger.log("");
        Bukkit.getPluginManager().registerEvents(new PlayerBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

}
