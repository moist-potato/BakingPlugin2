package me.helena.bakingPlugin;

import io.github.bananapuncher714.nbteditor.NBTEditor;
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
        if (NBTEditor.getInt(event.getItem(), "custom_model_data") == 2){
            player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 14 * 20,1));

            player.setFoodLevel(player.getFoodLevel() + 4);
            player.setSaturation(player.getSaturation() + 6);
        }

        else if (NBTEditor.getInt(event.getItem(), "custom_model_data") == 1){
            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200, 255));
            player.setFoodLevel(player.getFoodLevel() + 20);
            player.setSaturation(player.getSaturation() + 30);

        }
        else if(NBTEditor.getInt(event.getItem(), "custom_model_data") == 3){
            player.setFoodLevel(player.getFoodLevel() + 3);
            player.setSaturation(player.getSaturation() + 5);
            // discord user KuleUlrik's idea
        }
    }
}

