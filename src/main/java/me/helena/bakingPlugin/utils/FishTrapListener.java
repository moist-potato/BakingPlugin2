package me.helena.bakingPlugin.utils;

import me.helena.bakingPlugin.BakingPlugin;
import me.helena.bakingPlugin.CC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class FishTrapListener implements Listener {


    // 1 - The fishtrap needs to be loaded with bait (apples)
    // 2 - Fishtrap must be facing water on the sides
    // 3 - After being loaded, wait about ~ 10 seconds for the fish to be loaded
    // 4 - When interacting with a fishtrap (bait inside & time waited) 1-3 fish come out
    // 5 - The trap can be baited again

        @EventHandler
        public void onButtonInteract(PlayerInteractEvent event){

            if (event.getAction() == Action.RIGHT_CLICK_AIR){
                Player player = event.getPlayer();

                if (!LineOfSightUtil.get(player, Material.WATER, 5)) return;

                if (player.getInventory().getItemInMainHand() != null
                && player.getInventory().getItemInMainHand().getItemMeta() != null
                && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fFishtrap"))){

                    ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(event.getClickedBlock().getLocation(), EntityType.ARMOR_STAND);

                    armorStand.setHelmet(new ItemStack(Material.IRON_BARS));
                    armorStand.setInvisible(true);

                    System.out.println("update");

                    Bukkit.getScheduler().runTaskLater(BakingPlugin.getInstance(), () -> {
                        armorStand.setGravity(false);
                    }, 300L);

                    event.setCancelled(true);

                    player.getInventory().getItemInMainHand().setAmount(0);

                }

            }

        }

}

