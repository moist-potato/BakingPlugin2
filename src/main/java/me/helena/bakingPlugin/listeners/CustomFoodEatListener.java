package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.models.Food;
import me.helena.bakingPlugin.models.FoodData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
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

            event.setCancelled(true);

            if (event.getHand() == EquipmentSlot.HAND) {
                if (event.getItem().getAmount() > 1) {
                    player.getInventory().setItemInMainHand(new ItemStack(event.getItem().getType(), event.getItem().getAmount() - 1));
                } else {
                    player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));

                }
            } else if (event.getHand() == EquipmentSlot.OFF_HAND) {
                if (event.getItem().getAmount() > 1) {
                    player.getInventory().setItemInOffHand(new ItemStack(event.getItem().getType(), event.getItem().getAmount() - 1));
                } else {
                    player.getInventory().setItemInOffHand(new ItemStack(Material.AIR));

                }
            }

            player.setFoodLevel(player.getFoodLevel() + foodData.getFoodAmount());
            player.setSaturation(player.getSaturation() + foodData.getSaturationAmount());


        }
        

    }
}

