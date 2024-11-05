package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomFoodEatListener implements Listener {
    @EventHandler
    private void cakeBatterEatingDetector(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        
        if (event.getItem().getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter"))){
            player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 14 * 20,1));

            player.setFoodLevel(player.getFoodLevel() + 4);
            player.setSaturation(player.getSaturation() + 6);
        }

        else if (event.getItem().getItemMeta().getDisplayName().equals(CC.translate("&fButter"))){
            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200, 255));
            player.setFoodLevel(player.getFoodLevel() + 20);
            player.setSaturation(player.getSaturation() + 30);

        }
        else if(event.getItem().getItemMeta().getDisplayName().equals(CC.translate("&fCookie Dough"))){
            player.setFoodLevel(player.getFoodLevel() + 3);
            player.setSaturation(player.getSaturation() + 5);
            // discord user KuleUlrik's idea
        }
    }
}

