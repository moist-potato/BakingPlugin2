package me.helena.bakingPlugin.listeners;

import me.helena.bakingPlugin.utils.EntityTagUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class FishTrapBreakListener implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event){

        if (EntityTagUtil.entityHasTag(event.getEntity(), "exists") && event.getDamager() instanceof Player){

            Player player = (Player) event.getDamager();


            List<Entity> nearbyEntities = player.getNearbyEntities(0.5, 0.5, 0.5);

            for(Entity entity: nearbyEntities){

                if (EntityTagUtil.entityHasTag(entity, "exists") && entity instanceof ItemDisplay && EntityTagUtil.getIntFromTag(entity, "exists") == EntityTagUtil.getIntFromTag(event.getEntity(), "exists")){
                    event.getEntity().remove();
                    entity.remove();
                }

            }




        }
    }
}
