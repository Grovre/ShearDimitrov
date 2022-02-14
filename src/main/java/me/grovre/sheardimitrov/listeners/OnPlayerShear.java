package me.grovre.sheardimitrov.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class OnPlayerShear implements Listener {

    @EventHandler
    public void OnShearDimi(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            Player d = (Player) event.getDamager();
            if(d.getInventory().getItemInMainHand().getType() != Material.SHEARS) {
                return;
            }
        }

        Player player = (Player) event.getEntity();
        if(player.getName().equals("_Dimitrov")) {
            // Kills dimi and broadcasts his sheared death
            player.setHealth(0);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "_Dimitrov was sheared!");

            // Sets skull data
            ItemStack dimiSkull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta dimiSkullMeta = (SkullMeta) dimiSkull.getItemMeta();
            assert dimiSkullMeta != null;
            dimiSkullMeta.setOwnerProfile(Bukkit.getPlayer("_Dimitrov").getPlayerProfile());
            dimiSkull.setItemMeta(dimiSkullMeta);

            // Drops dimi's skull
            player.getWorld().dropItemNaturally(player.getLocation(), dimiSkull);
        }
    }
}
