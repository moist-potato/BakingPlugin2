package me.helena.bakingPlugin.models;

import lombok.Getter;
import me.helena.bakingPlugin.utils.CC;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public enum Food {

    BUTTER(CC.translate("&fButter"), new FoodData(1,Material.APPLE, CC.translate("&fButter"), 1, List.of(new PotionEffect(PotionEffectType.HUNGER, 200, 255), new PotionEffect(PotionEffectType.NAUSEA, 100, 1)), 30, 20, false), false),
    CAKE_BATTER(CC.translate("&fCake Batter"), new FoodData(1,Material.APPLE, CC.translate("&fCake Batter"), 2, List.of(new PotionEffect(PotionEffectType.NAUSEA, 100, 1)), 4, 6, true), true),
    COOKIE_DOUGH(CC.translate("&fCookie Dough"), new FoodData(1,Material.APPLE, CC.translate("&fCookie Dough"), 3, null, 3, 5, true), true);


    @Getter
    private final String nameID;
    @Getter
    private final FoodData foodData;
    @Getter
    private final boolean isCookable;



    Food(String nameID, FoodData foodData, boolean isCookable) {
        this.nameID = nameID;
        this.foodData = foodData;
        this.isCookable = isCookable;

    }

    public static FoodData fromName(String nameID) {
        for (Food e : values()) {
            if (e.nameID.equals(CC.translate(nameID))) {
                return e.foodData;
            }
        }


        return null;
    }
}
