package pl.mineOres.utils;

import java.util.Random;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class RandomUtil {

	public static int getRandomInt(int min, int max) throws IllegalArgumentException {
		Random rand = new Random();
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return rand.nextInt(max - min + 1) + min;
	}

	public static double getRandomDouble(double min, double max) {
		Random rand = new Random();
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return rand.nextDouble() * (max - min) + min;
	}

	public static boolean chanceOf(double chance) {
		return (chance >= 100.0D) || (chance >= getRandomDouble(0.0D, 100.0D));
	}

	static World world = Bukkit.getWorld("world");

}
