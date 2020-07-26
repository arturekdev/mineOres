package pl.mineOres.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.mineOres.Main;
import pl.mineOres.updater.Updater;
import pl.mineOres.utils.Util;

public class PlayerJoinListener implements Listener {

    @EventHandler
    private void event(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Updater spu = new Updater(Main.getInst(), "https://arturekdev.github.io/mineOres/mineOres.html");
        if (p.hasPermission("mineOres.admin") && spu.needsUpdate()) {
            p.sendMessage(Util.fix(" &6&lmineOres &8>> &7Plugin has new version! Download now!"));
        }
    }
}
