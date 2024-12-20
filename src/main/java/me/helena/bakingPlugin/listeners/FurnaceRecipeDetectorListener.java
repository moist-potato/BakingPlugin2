package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.models.Food;
import me.helena.bakingPlugin.models.FoodData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

public class FurnaceRecipeDetectorListener implements Listener {



    @EventHandler
    private void furnaceDetector(FurnaceSmeltEvent event) {

        // getSource() == furnace input
        if (event.getSource().isEmpty()) return;

        ItemStack source = event.getSource();

        if (source.getType() == Material.APPLE || source.getType() == Material.MUSHROOM_STEW) {
            Block furnaceBlock = event.getBlock();
            Furnace furnace = (Furnace) furnaceBlock.getState();
            FurnaceInventory inventory = furnace.getInventory();


            if (source.getItemMeta() != null && Food.fromName(source.getItemMeta().getDisplayName()) != null) {

                FoodData foodData = Food.fromName(source.getItemMeta().getDisplayName());
                Bukkit.broadcastMessage("Is updating");
                if (source.getType() == Material.APPLE){
                    event.setResult(foodData.getFurnaceOutput());
                    if (inventory.getResult() == foodData.getFurnaceOutput()){
                        inventory.setResult(inventory.setResult(foodData.getFurnaceOutput()););
                    }
                }
                else {
                    event.setResult(foodData.getFurnaceOutput());
                    inventory.setSmelting(new ItemStack(Material.BOWL));
                }

            } else {
                event.setCancelled(true);
            }
        }

    }


    @EventHandler
    private void furnaceDetector(FurnaceBurnEvent event) {
        Furnace furnace = ((Furnace) event.getBlock().getState());
        FurnaceInventory inventory = furnace.getInventory();
        ItemStack source = inventory.getSmelting();
        if (inventory.isEmpty() || inventory.getSmelting() == null) return;
        if (source.getType() != Material.APPLE && source.getType() != Material.MUSHROOM_STEW) return;

        if (source.getItemMeta() != null && Food.fromName(source.getItemMeta().getDisplayName()) != null || Food.fromName(source.getItemMeta().getDisplayName()).getIfIsCookable()) return;

        event.setCancelled(true);


    }



}
