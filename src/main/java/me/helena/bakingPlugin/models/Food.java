package me.helena.bakingPlugin.models;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import lombok.Getter;
import me.helena.bakingPlugin.utils.CC;
import me.helena.bakingPlugin.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public enum Food {

    BUTTER(CC.translate("&fButter"), new FoodData(Material.APPLE, CC.translate("&fButter"), 1, List.of(new PotionEffect(PotionEffectType.HUNGER, 200, 255), new PotionEffect(PotionEffectType.NAUSEA, 100, 1)), 30, 20, false, null)),
    CAKE_BATTER(CC.translate("&fCake Batter"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fCake Batter"), 1, List.of(new PotionEffect(PotionEffectType.NAUSEA, 100, 1)), 4, 6, true, new ItemStack(Material.CAKE))),
    COOKIE_DOUGH(CC.translate("&fCookie Dough"), new FoodData(Material.APPLE, CC.translate("&fCookie Dough"), 2, null, 3, 5, true, new ItemStack(Material.COOKIE))),
    APPLE_PIE(CC.translate("&fApple Pie"), new FoodData(Material.APPLE, CC.translate("&fApple Pie"), 3, null, 6, 10, false, null)),
    BUTTERED_BREAD(CC.translate("&fButtered Bread"), new FoodData(Material.APPLE, CC.translate("&fButtered Bread"), 4, null, 9, 7, false, null)),
    CARROT_CAKE(CC.translate("&fCarrot Cake"), new FoodData(Material.APPLE, CC.translate("&fCarrot Cake"), 5, null, 6, 10, false, null)),
    CHICKEN_PIE(CC.translate("&fChicken Pie"), new FoodData(Material.APPLE, CC.translate("&fChicken Pie"), 6, null, 6, 10, false, null)),
    GOLDEN_CARROT_CAKE(CC.translate("&fGolden Carrot Cake"), new FoodData(Material.APPLE, CC.translate("&fGolden Carrot Cake"), 7, null, 10, 15, false, null)),
    RAW_APPLE_PIE(CC.translate("&fRaw Apple Pie"), new FoodData(Material.APPLE, CC.translate("&fRaw Apple Pie"), 8, null, 2, 4, true, NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fApple Pie","", false), 3, "custom_model_data"))),
    RAW_PUMPKIN_PIE(CC.translate("&fRaw Pumpkin Pie"), new FoodData(Material.APPLE, CC.translate("&fRaw Pumpkin Pie"), 9, null, 2, 4, true, new ItemStack(Material.PUMPKIN_PIE))),
    CARROT_CAKE_BATTER(CC.translate("&fCarrot Cake Batter"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fCarrot Cake Batter"), 2, List.of(new PotionEffect(PotionEffectType.NAUSEA, 100, 1)), 4, 6, true, NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fCarrot Cake", "", false), 5, "custom_model_data"))),
    GOLDEN_CARROT_CAKE_BATTER(CC.translate("&fGolden Carrot Cake Batter"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fGolden Carrot Cake Batter"), 3, List.of(new PotionEffect(PotionEffectType.NAUSEA, 100, 1)), 4, 6, true, NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fGolden Carrot Cake", "", false), 7, "custom_model_data"))),
    RAW_BEETROOT_SOUP(CC.translate("&fRaw Beetroot Soup"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fRaw Beetroot Soup"), 4, null, 4, 6, true, new ItemStack(Material.BEETROOT_SOUP))),
    RAW_MUSHROOM_STEW(CC.translate("&fRaw Mushroom Stew"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fRaw Mushroom Stew"), 5, null, 4, 6, true, new ItemStack(Material.MUSHROOM_STEW))),
    RAW_RABBIT_STEW(CC.translate("&fRaw Rabbit Stew"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fRaw Rabbit Stew"), 6, null, 4, 6, true, new ItemStack(Material.RABBIT_STEW))),
    BREAD_DOUGH(CC.translate("&fBread Dough"), new FoodData(Material.MUSHROOM_STEW , CC.translate("&fBread Dough"), 11, null, 4, 6, true, new ItemStack(Material.BREAD)));


    @Getter
    private final String nameID;
    @Getter
    private final FoodData foodData;




    Food(String nameID, FoodData foodData) {
        this.nameID = nameID;
        this.foodData = foodData;

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
