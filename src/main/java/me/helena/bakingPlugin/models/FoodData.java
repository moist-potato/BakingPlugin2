package me.helena.bakingPlugin.models;

import lombok.Data;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;

import java.util.List;

@Data
public class FoodData {

    @Getter private int id;
    @Getter
    private Material material;
    @Getter
    private String name;
    @Getter
    private int customModelData;
    @Getter
    private List<PotionEffect> potionEffects;
    @Getter
    private int saturationAmount;
    @Getter
    private int foodAmount;


    public FoodData(int id, Material material, String name, int customModelData, List<PotionEffect> potionEffects, int saturationAmount, int foodAmount) {
        this.id = id;
        this.material = material;
        this.name = name;
        this.customModelData = customModelData;
        this.potionEffects = potionEffects;
        this.saturationAmount = saturationAmount;
        this.foodAmount = foodAmount;

    }

    public int getID() {
        return this.id;
    }

    public List<PotionEffect> getPotionEffects() {
        return this.potionEffects;
    }

    public String name() {
        return this.name;
    }

    public int getSaturationAmount() {
        return this.saturationAmount;
    }

    public int getFoodAmount() {
        return this.foodAmount;
    }
}
