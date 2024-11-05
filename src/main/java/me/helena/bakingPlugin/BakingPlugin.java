package me.helena.bakingPlugin;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import me.helena.bakingPlugin.listeners.CustomFoodEatListener;
import me.helena.bakingPlugin.listeners.FishTrapBreakListener;
import me.helena.bakingPlugin.listeners.FurnaceRecipeDetectorListener;
import me.helena.bakingPlugin.listeners.FishTrapListener;
import me.helena.bakingPlugin.utils.ItemUtils;
import me.helena.bakingPlugin.utils.RecipeUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class BakingPlugin extends JavaPlugin {


    public static BakingPlugin getInstance() {
        return getPlugin(BakingPlugin.class);
    }


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FishTrapListener(), this);

        getServer().getPluginManager().registerEvents(new FurnaceRecipeDetectorListener(), this);

        getServer().getPluginManager().registerEvents(new CustomFoodEatListener(), this);

        getServer().getPluginManager().registerEvents(new FishTrapBreakListener(), this);

        System.out.println("Plugin loaded. 6");


        Bukkit.addRecipe(new FurnaceRecipe(new ItemStack(Material.CAKE), Material.APPLE));


        Bukkit.removeRecipe(NamespacedKey.minecraft("cake"));

        RecipeUtil.registerRecipes("butter", false, "1  ", "   ", "  ", Arrays.asList(
                new ItemStack(Material.MILK_BUCKET),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fButter", "", false), 1, "custom_model_data")));

        RecipeUtil.registerRecipes("cookie", false, "123", "4  ", "   ", Arrays.asList(
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.COCOA_BEANS),
                NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fButter", "", false), 1, "custom_model_data"),
                null,
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE, 8), "&fCookie Dough", "", false), 3, "custom_model_data")));

        RecipeUtil.registerRecipes("cakebatter", true, "123", "456", "789", Arrays.asList(
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.EGG),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.MILK_BUCKET),
                new ItemStack(Material.BOWL),
                new ItemStack(Material.MILK_BUCKET)), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fCake Batter", "", false), 2, "custom_model_data")));

        RecipeUtil.registerRecipes("fishtrap", true, " 2 ", "4 6", " 8 ", Arrays.asList(
                null,
                new ItemStack(Material.IRON_BARS),
                null,
                new ItemStack(Material.IRON_BARS),
                null,
                new ItemStack(Material.IRON_BARS),
                null,
                new ItemStack(Material.IRON_BARS),
                null), (ItemUtils.CreateCustomItem(new ItemStack(Material.IRON_BARS), "&fFishtrap", "", false)));
    }

    @Override
    public void onDisable() {
    }
}
