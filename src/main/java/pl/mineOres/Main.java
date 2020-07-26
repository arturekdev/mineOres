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
        Logger.log("           _             _____               \n");
        Logger.log("          (_)           |  _  |              \n");
        Logger.log(" _ __ ___  _ _ __   ___ | | | |_ __ ___  ___ \n");
        Logger.log("| '_ ` _ \\| | '_ \\ / _ \\| | | | '__/ _ \\/ __|\n");
        Logger.log("| | | | | | | | | |  __/\\ \\_/ / | |  __/\\__ \\\n");
        Logger.log("|_| |_| |_|_|_| |_|\\___| \\___/|_|  \\___||___/\n");
        Logger.log("");
        Logger.log("Author: _arturek");
        Logger.log("Version: ");
        Logger.log("Web: https://minecodes.pl/");
        Logger.log("----------------------------------");
        Bukkit.getPluginManager().registerEvents(new PlayerBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    public boolean newVersionAvailiable(String oldv, String newv) {
        if (oldv != null && newv != null) {
            oldv = oldv.replace('.', '_');
            newv = newv.replace('.', '_');
            if ((oldv.split("_")).length != 0 && (oldv.split("_")).length != 1 && (newv.split("_")).length != 0 && (newv.split("_")).length != 1) {
                int vnum = Integer.valueOf(oldv.split("_")[0]).intValue();
                int vsec = Integer.valueOf(oldv.split("_")[1]).intValue();
                int newvnum = Integer.valueOf(newv.split("_")[0]).intValue();
                int newvsec = Integer.valueOf(newv.split("_")[1]).intValue();
                if (newvnum > vnum)
                    return true;
                return newvnum == vnum &&
                        newvsec > vsec;
            }
        }
        return false;
    }

}
