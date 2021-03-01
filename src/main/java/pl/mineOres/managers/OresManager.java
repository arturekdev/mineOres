package pl.mineOres.managers;

import org.bukkit.*;
import org.bukkit.entity.Player;
import pl.mineOres.utils.RandomUtil;

public class OresManager {

    public static World world;

    public static int many_coal = 0;
    public static int many_diamond = 0;
    public static int many_emerald = 0;
    public static int many_gold = 0;
    public static int many_iron = 0;
    public static int many_lapis = 0;
    public static int many_nethergold = 0;
    public static int many_quartz = 0;
    public static int many_ancientdebris = 0;

    public static Location main_loc_coal;
    public static Location main_loc_diamond;
    public static Location main_loc_emerald;
    public static Location main_loc_gold;
    public static Location main_loc_iron;
    public static Location main_loc_lapis;
    public static Location main_loc_nethergold;
    public static Location main_loc_quartz;
    public static Location main_loc_ancientdebris;


    public static Location nextLocation(Material m, Location l) {
        int xbmin = l.getBlockX() - 1;
        int xbmax = l.getBlockX() + 1;

        int zbmin = l.getBlockZ() - 1;
        int zbmax = l.getBlockZ() + 1;

        int x = RandomUtil.getRandomInt(xbmin, xbmax);
        int z = RandomUtil.getRandomInt(zbmin, zbmax);
        int y = RandomUtil.getRandomInt(l.getBlockY() - 1, l.getBlockY() + 1);

        Location loc = new Location(l.getWorld(), x, y, z);

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

        Location loc = new Location(p.getWorld(), x, y, z);

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

            if (m.equals(Material.NETHER_GOLD_ORE)) {

                if(main_loc_nethergold == null) {
                    main_loc_nethergold = newLocation(p, ymin, ymax);
                }

                if(!main_loc_nethergold.getBlock().getType().equals(Material.NETHERRACK)) {
                    main_loc_nethergold = newLocation(p, ymin, ymax);
                    runSearch(m, p, ymin, ymax, amount);
                    return;
                }

                if(many_nethergold == 0) {
                    main_loc_nethergold = newLocation(p, ymin, ymax);
                    many_nethergold = amount;
                }

                Location nextOreLoc = nextLocation(m, main_loc_nethergold);

                if(!nextOreLoc.getBlock().getType().equals(Material.NETHERRACK)) {
                    runSearch(m, p, ymin, ymax, amount);
                    return;
                }

                nextOreLoc.getChunk().load();
                nextOreLoc.getBlock().setType(m);
                many_nethergold = -1;


            }

            if(m.equals(Material.NETHER_QUARTZ_ORE)) {

                if(main_loc_quartz == null) {
                    main_loc_quartz = newLocation(p, ymin, ymax);
                }

                if(!main_loc_quartz.getBlock().getType().equals(Material.NETHERRACK)) {
                    main_loc_quartz = newLocation(p, ymin, ymax);
                    runSearch(m, p, ymin, ymax, amount);
                    return;
                }
                if(many_quartz == 0) {
                    main_loc_quartz = newLocation(p, ymin, ymax);
                    many_quartz = amount;
                }

                Location nextOreLoc = nextLocation(m, main_loc_quartz);

                if(!nextOreLoc.getBlock().getType().equals(Material.NETHERRACK)) {
                    runSearch(m, p, ymin, ymax, amount);
                    return;
                }

                nextOreLoc.getChunk().load();
                nextOreLoc.getBlock().setType(m);
                many_quartz = -1;
            }

            if(m.equals(Material.ANCIENT_DEBRIS)) {

                Location nextOreLoc = newLocation(p, ymin, ymax);

                if(!nextOreLoc.getBlock().getType().equals(Material.NETHERRACK)) {
                    runSearch(m, p, ymin, ymax, amount);
                    return;
                }
                nextOreLoc.getChunk().load();
                nextOreLoc.getBlock().setType(m);
                many_ancientdebris = -1;
            }
        }
    }

