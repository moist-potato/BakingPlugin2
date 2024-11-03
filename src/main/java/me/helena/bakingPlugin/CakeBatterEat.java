package me.helena.bakingPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CakeBatterEat implements Listener {
    @EventHandler
    private void cakeBatterEatingDetector(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter"))){
            player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 14 * 20,1));
        }

    }
}

