package me.helena.bakingPlugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

public class FurnaceRecipeDetector implements Listener {



    @EventHandler
    private void furnaceDetector(FurnaceSmeltEvent event) {

        // getSource() == furnace input
        if (event.getSource().isEmpty()) return;

        ItemStack source = event.getSource();

        if (source.getType() == Material.MUSHROOM_STEW && source.getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter"))) {
            Block furnaceBlock = event.getBlock();
            Furnace furnace = (Furnace) furnaceBlock.getState();
            FurnaceInventory inventory = furnace.getInventory();
            inventory.setSmelting(new ItemStack(Material.BOWL));
        } else {
            event.setCancelled(true);
        }

    }

    @EventHandler
    private void furnaceDetector(FurnaceBurnEvent event) {
        Furnace furnace = ((Furnace) event.getBlock().getState());
        FurnaceInventory inventory = furnace.getInventory();
        if (inventory.isEmpty() || inventory.getSmelting() == null) return;

        ItemStack source = inventory.getSmelting();

        if (source.getItemMeta().getDisplayName().equals(CC.translate("&fCake Batter"))) return;

        event.setCancelled(true);


    }



}
