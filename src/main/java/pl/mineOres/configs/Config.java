package pl.mineOres.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import pl.mineOres.Main;

public class Config {
	
	public static String name;
	
	public static boolean emerald_t;
	public static boolean diamond_t;
	public static boolean gold_t;
	public static boolean iron_t;
	public static boolean coal_t;
	public static boolean lapis_t;
	
	public static int emerald_max;
	public static int diamond_max;
	public static int gold_max;
	public static int iron_max;
	public static int coal_max;
	public static int lapis_max;
	
	public static int emerald_min;
	public static int diamond_min;
	public static int gold_min;
	public static int iron_min;
	public static int coal_min;
	public static int lapis_min;
	
	public static int emerald_amount;
	public static int diamond_amount;
	public static int gold_amount;
	public static int iron_amount;
	public static int coal_amount;
	public static int lapis_amount;


	public static void load() {
		
		name = getConfig().getString("license");
		
		emerald_t = getConfig().getBoolean("ores.emerald.toggle");
		diamond_t = getConfig().getBoolean("ores.diamond.toggle");
		gold_t = getConfig().getBoolean("ores.gold.toggle");
		iron_t = getConfig().getBoolean("ores.iron.toggle");
		coal_t = getConfig().getBoolean("ores.coal.toggle");
		lapis_t = getConfig().getBoolean("ores.lapis.toggle");
		
		emerald_max = getConfig().getInt("ores.emerald.max");
		diamond_max = getConfig().getInt("ores.diamond.max");
		gold_max = getConfig().getInt("ores.gold.max");
		iron_max = getConfig().getInt("ores.iron.max");
		coal_max = getConfig().getInt("ores.coal.max");
		lapis_max = getConfig().getInt("ores.lapis.max");
		
		emerald_min = getConfig().getInt("ores.emerald.min");
		diamond_min = getConfig().getInt("ores.diamond.min");
		gold_min = getConfig().getInt("ores.gold.min");
		iron_min = getConfig().getInt("ores.iron.min");
		coal_min = getConfig().getInt("ores.coal.min");
		lapis_min = getConfig().getInt("ores.lapis.min");
		
		emerald_amount = getConfig().getInt("ores.emerald.amount");
		diamond_amount = getConfig().getInt("ores.diamond.amount");
		gold_amount = getConfig().getInt("ores.gold.amount");
		iron_amount = getConfig().getInt("ores.iron.amount");
		coal_amount = getConfig().getInt("ores.coal.amount");
		lapis_amount = getConfig().getInt("ores.lapis.amount");
	}

	public static FileConfiguration getConfig() {
		return Main.getInst().getConfig();
	}

	public static void save() {
		final FileConfiguration cfg = Main.getInst().getConfig();
		final File f = new File(Main.getInst().getDataFolder(), "config.yml");
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reload() {
		final FileConfiguration cfg = Main.getInst().getConfig();
		final File f = new File(Main.getInst().getDataFolder(), "config.yml");
		try {
			try {
				cfg.load(f);
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
