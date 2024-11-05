package me.helena.bakingPlugin.utils;

import me.helena.bakingPlugin.BakingPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public class EntityTagUtil {

    public static void addTagToEntity(Entity entity, int value, String tag){
        NamespacedKey namedspacedKey = new NamespacedKey(BakingPlugin.getInstance(), tag);

        entity.getPersistentDataContainer().set(namedspacedKey, PersistentDataType.INTEGER, value);

    }

    public static boolean entityHasTag(Entity entity, String tag){
        NamespacedKey namedspacedKey = new NamespacedKey(BakingPlugin.getInstance(), tag);

        return entity.getPersistentDataContainer().has(namedspacedKey, PersistentDataType.INTEGER);

    }

    public static int getIntFromTag(Entity entity, String tag) {
        NamespacedKey namedspacedKey = new NamespacedKey(BakingPlugin.getInstance(), tag);
        return entity.getPersistentDataContainer().get(namedspacedKey, PersistentDataType.INTEGER);
    }


}
