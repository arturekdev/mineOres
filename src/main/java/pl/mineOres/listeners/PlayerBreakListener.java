package pl.mineOres.listeners;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.mineOres.configs.Config;
import pl.mineOres.managers.OresManager;

public class PlayerBreakListener implements Listener {

	@EventHandler
	public void onMine(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		Block b = e.getBlock();

		if (b.getType().equals(Material.COAL_ORE)) {
			if (Config.coal_t) {
				OresManager.runSearch(Material.COAL_ORE, p, Config.coal_min, Config.coal_max, Config.coal_amount);
			}
		}

		if (b.getType().equals(Material.DIAMOND_ORE)) {
			if (Config.diamond_t) {
				OresManager.runSearch(Material.DIAMOND_ORE, p, Config.diamond_min, Config.diamond_max,
						Config.diamond_amount);
			}
		}

		if (b.getType().equals(Material.EMERALD_ORE)) {
			if (Config.emerald_t) {
				OresManager.runSearch(Material.EMERALD_ORE, p, Config.emerald_min, Config.emerald_max,
						Config.emerald_amount);
			}
		}

		if (b.getType().equals(Material.GOLD_ORE)) {
			if (Config.gold_t) {
				OresManager.runSearch(Material.GOLD_ORE, p, Config.gold_min, Config.gold_max, Config.gold_amount);
			}
		}

		if (b.getType().equals(Material.IRON_ORE)) {
			if (Config.iron_t) {
				OresManager.runSearch(Material.IRON_ORE, p, Config.iron_min, Config.iron_max, Config.iron_amount);
			}
		}

		if (b.getType().equals(Material.LAPIS_ORE)) {
			if (Config.lapis_t) {
				OresManager.runSearch(Material.LAPIS_ORE, p, Config.lapis_min, Config.lapis_max, Config.lapis_amount);
			}
		}

		if(p.getWorld().getEnvironment().equals(World.Environment.NETHER)) {

			if(b.getType().equals(Material.NETHER_GOLD_ORE)) {
				OresManager.runSearch(Material.NETHER_GOLD_ORE, p, Config.nethergold_min, Config.nethergold_max, Config.nethergold_amount);
			}

			if(b.getType().equals(Material.NETHER_QUARTZ_ORE)) {
				OresManager.runSearch(Material.NETHER_QUARTZ_ORE, p, Config.quartz__min, Config.quartz_max, Config.nethergold_amount);
			}

			if(b.getType().equals(Material.ANCIENT_DEBRIS)) {
				OresManager.runSearch(Material.ANCIENT_DEBRIS, p, Config.ancientdebris_min, Config.ancientdebris_max, Config.ancientdebris_amount);
			}
		}

	}

}
