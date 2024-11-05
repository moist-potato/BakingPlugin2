package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.utils.CC;
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

        if (source.getType() == Material.APPLE) {
            Block furnaceBlock = event.getBlock();
            Furnace furnace = (Furnace) furnaceBlock.getState();
            FurnaceInventory inventory = furnace.getInventory();
            if (source.getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter"))) {

                inventory.setSmelting(new ItemStack(Material.BOWL));

            } else if (source.getItemMeta().getDisplayName().equals(CC.translate("&fCookie Dough"))) {
               event.setResult(new ItemStack(Material.COOKIE));
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
        if (inventory.isEmpty() || inventory.getSmelting() == null || source.getType() != Material.APPLE) return;

        if (source.getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter")) || source.getItemMeta().getDisplayName().equals(CC.translate("&fCookie Dough")) ) return;

        event.setCancelled(true);


    }



}
