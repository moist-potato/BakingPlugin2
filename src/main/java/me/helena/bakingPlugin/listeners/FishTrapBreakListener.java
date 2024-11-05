package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.utils.EntityTagUtil;
import me.helena.bakingPlugin.utils.ItemUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FishTrapBreakListener implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event){

        if (EntityTagUtil.entityHasTag(event.getEntity(), "exists") && event.getDamager() instanceof Player
            && ((Player) event.getDamager()).getInventory().getItemInMainHand().getType() == Material.AIR){

            Player player = (Player) event.getDamager();


            List<Entity> nearbyEntities = player.getNearbyEntities(3.5, 3.5, 3.5);

            for(Entity entity: nearbyEntities){

                if (EntityTagUtil.entityHasTag(entity, "exists") && entity instanceof ItemDisplay
                        && EntityTagUtil.getIntFromTag(entity, "exists") == EntityTagUtil.getIntFromTag(event.getEntity(), "exists")){

                    Location location = event.getEntity().getLocation();
                    event.getEntity().remove();
                    entity.remove();
                    player.getWorld().dropItem(location, ItemUtils.CreateCustomItem(new ItemStack(Material.IRON_BARS), "&fFishtrap", "", false));
                }

            }




        }
    }
}
