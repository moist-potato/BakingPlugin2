package me.helena.bakingPlugin;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CakeBatterEat implements Listener {
    @EventHandler
    private void cakeBatterEatingDetector(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter"))){
            player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 14 * 20,1));

            player.setFoodLevel(player.getFoodLevel() + 4);
            player.setSaturation(player.getSaturation() + 6);
        }

        else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fButter"))){
            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200, 255));
            player.setFoodLevel(player.getFoodLevel() + 20);
            player.setSaturation(player.getSaturation() + 30);

        }
        else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fCookie Dough"))){
            player.setFoodLevel(player.getFoodLevel() + 3);
            player.setSaturation(player.getSaturation() + 5);
            // discord user KuleUlrik's idea
        }
    }
}

