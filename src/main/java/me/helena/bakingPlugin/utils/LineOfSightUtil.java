package me.helena.bakingPlugin.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

public class LineOfSightUtil {

    public static Block get(Player p, Material target, Integer radius){
        List<Block> lineOfSight = p.getLineOfSight(null, radius);
        for (Block b : lineOfSight) {
            if (b.getType() == target) {
                return b;
            }
        }
        return null;
    }
}
