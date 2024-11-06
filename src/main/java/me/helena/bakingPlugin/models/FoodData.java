package me.helena.bakingPlugin.models;

import lombok.Data;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.List;

@Data
public class FoodData {

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
    @Getter
    private boolean isCookable;
    @Getter
    private ItemStack furnaceOutput;


    public FoodData(Material material, String name, int customModelData, List<PotionEffect> potionEffects, int saturationAmount, int foodAmount, boolean isCookable, ItemStack furnaceOutput) {
        this.material = material;
        this.name = name;
        this.customModelData = customModelData;
        this.potionEffects = potionEffects;
        this.saturationAmount = saturationAmount;
        this.foodAmount = foodAmount;
        this.isCookable = isCookable;
        this.furnaceOutput = furnaceOutput;

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
    public ItemStack getFurnaceOutput(){
        return this.furnaceOutput;
    }
    public boolean getIfIsCookable() { return this.isCookable; }

}
