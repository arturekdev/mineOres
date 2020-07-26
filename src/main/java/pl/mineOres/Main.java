package pl.mineOres;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.mineOres.configs.Config;
import pl.mineOres.listeners.PlayerBreakListener;
import pl.mineOres.utils.GameUtil;

public class Main extends JavaPlugin {

	private static Main plugin;
	

	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		Config.load();
		
		if (!new GameUtil(Config.name, this).register()) {
			return;
		}

		int pluginId = 8316; // <-- Replace with the id of your plugin!
		Metrics metrics = new Metrics(this, pluginId);

		// Optional: Add custom charts
		metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value a"));
		
		Logger.log("----------------------------------");
		Logger.log("         mineOres");
		Logger.log("");
		Logger.log("Authors: _arturek");
		Logger.log("Version: 2.0");
		Logger.log("Web: https://minecodes.pl/");
		Logger.log("----------------------------------");
		Bukkit.getPluginManager().registerEvents(new PlayerBreakListener(), this);
	}

	public static Main getInst() {
		return plugin;
	}
}
