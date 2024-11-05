package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.BakingPlugin;
import me.helena.bakingPlugin.utils.CC;
import me.helena.bakingPlugin.utils.EntityTagUtil;
import me.helena.bakingPlugin.utils.LineOfSightUtil;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class FishTrapListener implements Listener {

    private static HashMap<ArmorStand, Boolean> hasBait = new HashMap<>();

    // 1 - The fishtrap needs to be loaded with bait (apples)
    // 2 - Fishtrap must be facing water on the sides
    // 3 - After being loaded, wait about ~ 10 seconds for the fish to be loaded
    // 4 - When interacting with a fishtrap (bait inside & time waited) 1-3 fish come out
    // 5 - The trap can be baited again

    @EventHandler
    public void placeFishTrap(PlayerInteractEvent event){

        if (event.getAction() == Action.RIGHT_CLICK_AIR){
            Player player = event.getPlayer();

            Block clickedBlock = LineOfSightUtil.get(player, Material.WATER, 5);
            if (clickedBlock == null) return;

            if (player.getInventory().getItemInMainHand() != null
                    && player.getInventory().getItemInMainHand().getItemMeta() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fFishtrap"))){

                placeFishTrap(clickedBlock.getLocation(), player);


            }

        }

    }

    @EventHandler
    public void fishTrapCancelEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();


        if (player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(CC.translate("&fFishtrap")) )
        {
            placeFishTrap(event.getBlock().getLocation().clone().add(0, 2.5, 0), player);
            event.setCancelled(true);
        }
    }

    private void placeFishTrap(Location location, Player player){
        int customID = new Random().nextInt(100000);

        Location newLocation = location.clone().add(0,-2, 0);
        ItemDisplay fishTrap = (ItemDisplay) player.getWorld().spawnEntity(newLocation, EntityType.ITEM_DISPLAY);
        EntityTagUtil.addTagToEntity(fishTrap, customID, "exists");

        fishTrap.setItemStack(new ItemStack(Material.IRON_BARS));


        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(newLocation.clone().add(0, -0.5, 0), EntityType.ARMOR_STAND);
        EntityTagUtil.addTagToEntity(armorStand, customID, "exists");
        armorStand.setInvisible(true);
        armorStand.setGravity(false);
        armorStand.setSmall(true);

        hasBait.put(armorStand, false);

        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
    }






    @EventHandler
    public void baitFishTrapEvent(PlayerInteractAtEntityEvent event) {
        Entity armorStand = event.getRightClicked();
        Player player = event.getPlayer();
        if (armorStand instanceof ArmorStand
                && EntityTagUtil.entityHasTag(armorStand, "exists")
                && player.getInventory().getItemInMainHand().getType() == Material.APPLE){

            if (hasBait.get(armorStand) == null){
                hasBait.put((ArmorStand) armorStand, false);
            }
            if(!hasBait.get(armorStand)) {

                hasBait.put((ArmorStand) armorStand, true);

                player.playSound(armorStand.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

                Bukkit.getScheduler().runTaskLater(BakingPlugin.getInstance(), () -> {
                    hasBait.put((ArmorStand) armorStand, false);

                    List<EntityType> fish = Arrays.asList(EntityType.SALMON, EntityType.COD, EntityType.PUFFERFISH, EntityType.TROPICAL_FISH);
                    List<EntityType> rareEntities = Arrays.asList(EntityType.DOLPHIN, EntityType.TURTLE, EntityType.SQUID, EntityType.DROWNED);

                    EntityType chosenAquaticEntity;

                    if (new Random().nextInt(100) <= 20) {
                        chosenAquaticEntity = rareEntities.get(new Random().nextInt(rareEntities.size()));
                    } else {
                        chosenAquaticEntity = fish.get(new Random().nextInt(fish.size()));
                    }

                    Location locationToSpawn = event.getRightClicked().getLocation().clone().add(0, 0.5, 0);


                    LivingEntity caught = (LivingEntity) player.getWorld().spawnEntity(locationToSpawn, chosenAquaticEntity);
                    caught.setAI(false);

                    if (caught instanceof Drowned) {
                        ((Drowned) caught).setBaby();

                    }
                    player.playSound(armorStand.getLocation(), Sound.ENTITY_FISHING_BOBBER_RETRIEVE, 1, 1);


                }, (new Random().nextInt(11) + 10) * 20);


            } else {

                player.sendMessage(CC.translate("&cThis fishtrap is full"));

            }

        }
    }
}

