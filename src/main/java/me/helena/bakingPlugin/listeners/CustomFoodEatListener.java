package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.models.Food;
import me.helena.bakingPlugin.models.FoodData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;

public class CustomFoodEatListener implements Listener {
    @EventHandler
    private void cakeBatterEatingDetector(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();

        if (event.getItem().getItemMeta() != null && Food.fromName(event.getItem().getItemMeta().getDisplayName()) != null) {

            FoodData foodData = Food.fromName(event.getItem().getItemMeta().getDisplayName());

            if(foodData.getPotionEffects() != null) {
                for (PotionEffect potionEffect : foodData.getPotionEffects()) {
                    player.addPotionEffect(potionEffect);
                }
            }

            player.setFoodLevel(foodData.getFoodAmount());
            player.setSaturation(foodData.getSaturationAmount());


        }
        

    }
}

