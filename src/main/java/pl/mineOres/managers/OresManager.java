package pl.mineOres.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import pl.mineOres.utils.RandomUtil;

public class OresManager {

	public static int many_coal = 0;
	public static int many_diamond = 0;
	public static int many_emerald = 0;
	public static int many_gold = 0;
	public static int many_iron = 0;
	public static int many_lapis = 0;

	public static Location main_loc_coal;
	public static Location main_loc_diamond;
	public static Location main_loc_emerald;
	public static Location main_loc_gold;
	public static Location main_loc_iron;
	public static Location main_loc_lapis;

	public static Location nextLocation(Material m, Location l) {
		int xbmin = l.getBlockX() - 1;
		int xbmax = l.getBlockX() + 1;

		int zbmin = l.getBlockZ() - 1;
		int zbmax = l.getBlockZ() + 1;

		int x = RandomUtil.getRandomInt(xbmin, xbmax);
		int z = RandomUtil.getRandomInt(zbmin, zbmax);
		int y = RandomUtil.getRandomInt(l.getBlockY() - 1, l.getBlockY() + 1);

		Location loc = new Location(l.getWorld(), (double) x, (double) y, (double) z);

		return loc;
	}

	public static Location newLocation(Player p, int ymin, int ymax) {

		int xpmin = p.getLocation().getBlockX() - 50;
		int xpmax = p.getLocation().getBlockX() + 50;

		int zpmin = p.getLocation().getBlockZ() - 50;
		int zpmax = p.getLocation().getBlockZ() + 50;

		int x = RandomUtil.getRandomInt(xpmin, xpmax);
		int z = RandomUtil.getRandomInt(zpmin, zpmax);
		int y = RandomUtil.getRandomInt(ymin, ymax);

		Location loc = new Location(p.getWorld(), (double) x, (double) y, (double) z);

		return loc;
	}

	public static void runSearch(Material m, Player p, int ymin, int ymax, int amount) {

		if (m.equals(Material.COAL_ORE)) {

			if (main_loc_coal == null) {
				main_loc_coal = newLocation(p, ymin, ymax);
			}

			if (!main_loc_coal.getBlock().getType().equals(Material.STONE)) {
				main_loc_coal = newLocation(p, ymin, ymax);
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			if (many_coal == 0) {
				main_loc_coal = newLocation(p, ymin, ymax);
				many_coal = amount;
			}

			Location nextOreLoc = nextLocation(m, main_loc_coal);

			if (!nextOreLoc.getBlock().getType().equals(Material.STONE)) {
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			nextOreLoc.getChunk().load();
			nextOreLoc.getBlock().setType(m);
			many_coal = -1;

		}

		if (m.equals(Material.DIAMOND_ORE)) {

			if (main_loc_diamond == null) {
				main_loc_diamond = newLocation(p, ymin, ymax);
			}

			if (!main_loc_diamond.getBlock().getType().equals(Material.STONE)) {
				main_loc_diamond = newLocation(p, ymin, ymax);
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			if (many_diamond == 0) {
				main_loc_diamond = newLocation(p, ymin, ymax);
				many_diamond = amount;
			}

			Location nextOreLoc = nextLocation(m, main_loc_diamond);

			if (!nextOreLoc.getBlock().getType().equals(Material.STONE)) {
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			nextOreLoc.getChunk().load();
			nextOreLoc.getBlock().setType(m);
			many_diamond = -1;

		}

		if (m.equals(Material.EMERALD_ORE)) {

			if (main_loc_emerald == null) {
				main_loc_emerald = newLocation(p, ymin, ymax);
			}

			if (!main_loc_emerald.getBlock().getType().equals(Material.STONE)) {
				main_loc_emerald = newLocation(p, ymin, ymax);
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			if (many_emerald == 0) {
				main_loc_emerald = newLocation(p, ymin, ymax);
				many_emerald = amount;
			}

			Location nextOreLoc = nextLocation(m, main_loc_emerald);

			if (!nextOreLoc.getBlock().getType().equals(Material.STONE)) {
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			nextOreLoc.getChunk().load();
			nextOreLoc.getBlock().setType(m);
			many_emerald = -1;

		}

		if (m.equals(Material.GOLD_ORE)) {

			if (main_loc_gold == null) {
				main_loc_gold = newLocation(p, ymin, ymax);
			}

			if (!main_loc_gold.getBlock().getType().equals(Material.STONE)) {
				main_loc_gold = newLocation(p, ymin, ymax);
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			if (many_gold == 0) {
				main_loc_gold = newLocation(p, ymin, ymax);
				many_gold = amount;
			}

			Location nextOreLoc = nextLocation(m, main_loc_gold);

			if (!nextOreLoc.getBlock().getType().equals(Material.STONE)) {
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			nextOreLoc.getChunk().load();
			nextOreLoc.getBlock().setType(m);
			many_gold = -1;

		}

		if (m.equals(Material.IRON_ORE)) {

			if (main_loc_iron == null) {
				main_loc_iron = newLocation(p, ymin, ymax);
			}

			if (!main_loc_iron.getBlock().getType().equals(Material.STONE)) {
				main_loc_iron = newLocation(p, ymin, ymax);
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			if (many_iron == 0) {
				main_loc_iron = newLocation(p, ymin, ymax);
				many_iron = amount;
			}

			Location nextOreLoc = nextLocation(m, main_loc_iron);

			if (!nextOreLoc.getBlock().getType().equals(Material.STONE)) {
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			nextOreLoc.getChunk().load();
			nextOreLoc.getBlock().setType(m);
			many_iron = -1;

		}

		if (m.equals(Material.LAPIS_ORE)) {

			if (main_loc_lapis == null) {
				main_loc_lapis = newLocation(p, ymin, ymax);
			}

			if (!main_loc_lapis.getBlock().getType().equals(Material.STONE)) {
				main_loc_lapis = newLocation(p, ymin, ymax);
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			if (many_lapis == 0) {
				main_loc_lapis = newLocation(p, ymin, ymax);
				many_lapis = amount;
			}

			Location nextOreLoc = nextLocation(m, main_loc_lapis);

			if (!nextOreLoc.getBlock().getType().equals(Material.STONE)) {
				runSearch(m, p, ymin, ymax, amount);
				return;
			}

			nextOreLoc.getChunk().load();
			nextOreLoc.getBlock().setType(m);
			many_lapis = -1;

		}
	}

//		if (m.equals(Material.BEDROCK)) {
//
//			if (main_loc_coal == null) {
//				main_loc_coal = newLocation(p, ymin, ymax);
//				// Bukkit.broadcastMessage(Util.fix("&6Lokalizacja nie była ustawiona!"));
//			}
//
//			if (!main_loc_coal.getBlock().getType().equals(Material.AIR)) {
//				main_loc_coal = newLocation(p, ymin, ymax);
//				// Bukkit.broadcastMessage(Util.fix("&bGówna lokalizacja nie posiadała pustego
//				// miejsca!"));
//				// Bukkit.broadcastMessage(Util.fix("&bTen blok: " +
//				// main_loc_coal.getBlock().getType() + " (" + main_loc_coal.getX() + ", " +
//				// main_loc_coal.getY() + ", " + main_loc_coal.getZ() + ")"));
//				runSearch(m, p, ymin, ymax);
//				return;
//			}
//
//			if (many_coal == 0) {
//				main_loc_coal = newLocation(p, ymin, ymax);
//				many_coal = 26;
//				// Bukkit.broadcastMessage(Util.fix("&4Skończyło się miejsce!"));
//			}
//
//			Location nextOreLoc = nextLocation(m, main_loc_coal);
//
//			if (!nextOreLoc.getBlock().getType().equals(Material.AIR)) {
//				// Bukkit.broadcastMessage(Util.fix("&aBlok obok głównego nie był
//				// potwietrzem."));
//				// Bukkit.broadcastMessage(Util.fix("&aTen blok: " +
//				// nextOreLoc.getBlock().getType() + " (" + nextOreLoc.getX() + ", " +
//				// nextOreLoc.getY() + ", " + nextOreLoc.getZ() + ")"));
//				runSearch(m, p, ymin, ymax);
//				return;
//			}
//
//			nextOreLoc.getChunk().load();
//			nextOreLoc.getBlock().setType(m);
//			many_coal = -1;
//
//			// Bukkit.broadcastMessage(Util.fix("&cPostawiłem blok"));
//			// Bukkit.broadcastMessage(Util.fix("&cTen blok: " +
//			// nextOreLoc.getBlock().getType() + " (" + nextOreLoc.getX() + ", " +
//			// nextOreLoc.getY() + ", " + nextOreLoc.getZ() + ")"));
//
//		}

//	public static void randomBlock(Material m, Player p, int ymin, int ymax) {
//
//		int xpmin = p.getLocation().getBlockX() - 50;
//		int xpmax = p.getLocation().getBlockX() + 50;
//
//		int zpmin = p.getLocation().getBlockZ() - 50;
//		int zpmax = p.getLocation().getBlockZ() + 50;
//
//		int x = RandomUtil.getRandomInt(xpmin, xpmax);
//		int z = RandomUtil.getRandomInt(zpmin, zpmax);
//		int y = RandomUtil.getRandomInt(ymin, ymax);
//
//		Location loc = new Location(p.getWorld(), (double) x, (double) y, (double) z);
//
//		if (m.equals(Material.COAL_ORE)) {
//
//			if (main_coal == null) {
//				main_coal = loc;
//			}
//
//			if (many_coal == 0) {
//				randomBlock(m, p, ymin, ymin);
//			}
//
//			depositOres(m, loc);
//
//		}
//
//		if (!(loc.getBlock().getType() == Material.STONE)) {
//			randomBlock(m, p, ymin, ymax);
//			return;
//		}
//
//		loc.getChunk().load();
//		loc.getBlock().setType(m);
//	}

}
