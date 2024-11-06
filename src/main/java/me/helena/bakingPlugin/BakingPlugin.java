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
import org.bukkit.entity.Item;
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

        System.out.println("Plugin loaded. 7");


        Bukkit.addRecipe(new FurnaceRecipe(new ItemStack(Material.CAKE), Material.APPLE));
        Bukkit.addRecipe(new FurnaceRecipe(new ItemStack(Material.BEETROOT_SOUP), Material.MUSHROOM_STEW));



        Bukkit.removeRecipe(NamespacedKey.minecraft("cake"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("pumpkin_pie"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("rabbit_stew"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("beetroot_soup"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("mushroom_stew"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("bread"));


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
                new ItemStack(Material.MILK_BUCKET)), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fCake Batter", "", false), 1, "custom_model_data")));

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

        RecipeUtil.registerRecipes("butteredbread", false, "12 ", "   ", "   ", Arrays.asList(
                NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fButter", "", false), 1, "custom_model_data"),
                new ItemStack(Material.BREAD),
                null,
                null,
                null,
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fButtered Bread", "", false), 4, "custom_model_data")));

        RecipeUtil.registerRecipes("rawapplepie", false, "123", "456", "   ", Arrays.asList(
                new ItemStack(Material.APPLE),
                new ItemStack(Material.APPLE),
                NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fButter", "", false), 1, "custom_model_data"),
                new ItemStack(Material.EGG),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.SUGAR),
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fRaw Apple Pie", "", false), 8, "custom_model_data")));

        RecipeUtil.registerRecipes("rawpumpkinpie", false, "123", "   ", "   ", Arrays.asList(
                new ItemStack(Material.PUMPKIN),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.EGG),
                null,
                null,
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fRaw Pumpkin Pie", "", false), 9, "custom_model_data")));

        RecipeUtil.registerRecipes("carrotcakebatter", true, "123", "456", "789", Arrays.asList(
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.EGG),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.CARROT),
                new ItemStack(Material.BOWL),
                new ItemStack(Material.CARROT)), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fCarrot Cake Batter", "", false), 2, "custom_model_data")));

        RecipeUtil.registerRecipes("goldencarrotcakebatter", true, "123", "456", "789", Arrays.asList(
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.EGG),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.GOLDEN_CARROT),
                new ItemStack(Material.BOWL),
                new ItemStack(Material.GOLDEN_CARROT)), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fGolden Carrot Cake Batter", "", false), 3, "custom_model_data")));

        RecipeUtil.registerRecipes("rawbeetrootsoup", false, "111", "111", "7  ", Arrays.asList(
                new ItemStack(Material.BEETROOT),
                new ItemStack(Material.BEETROOT),
                new ItemStack(Material.BEETROOT),
                new ItemStack(Material.BEETROOT),
                new ItemStack(Material.BEETROOT),
                new ItemStack(Material.BEETROOT),
                new ItemStack(Material.BOWL),
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fRaw Beetroot Soup", "", false), 4, "custom_model_data")));

        RecipeUtil.registerRecipes("rawmushroomstew", false, "12 ", "   ", "   ", Arrays.asList(
                new ItemStack(Material.RED_MUSHROOM),
                new ItemStack(Material.BROWN_MUSHROOM),
                new ItemStack(Material.BOWL),
                null,
                null,
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fRaw Mushroom Stew", "", false), 5, "custom_model_data")));

        RecipeUtil.registerRecipes("rawrabbitstew", false, "123", "45 ", "   ", Arrays.asList(
                new ItemStack(Material.RABBIT),
                new ItemStack(Material.CARROT),
                new ItemStack(Material.BAKED_POTATO),
                new ItemStack(Material.BROWN_MUSHROOM),
                new ItemStack(Material.BOWL),
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fRaw Rabbit Stew", "", false), 6, "custom_model_data")));

        RecipeUtil.registerRecipes("rawchickenpie", false, "123", "45 ", "   ", Arrays.asList(
                NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fButter", "", false), 1, "custom_model_data"),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.MILK_BUCKET),
                new ItemStack(Material.CARROT),
                new ItemStack(Material.CHICKEN),
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fRaw Chicken Pie", "", false), 10, "custom_model_data")));

        RecipeUtil.registerRecipes("breaddough1", true, "123", "   ", "   ", Arrays.asList(
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                null,
                null,
                null,
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fBread Dough", "", false), 11, "custom_model_data")));

        RecipeUtil.registerRecipes("breaddough2", true, "   ", "456", "   ", Arrays.asList(
                null,
                null,
                null,
                null,
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                null,
                null,
                null), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fBread Dough", "", false), 11, "custom_model_data")));

        RecipeUtil.registerRecipes("breaddough3", true, "   ", "   ", "789", Arrays.asList(
                null,
                null,
                null,
                null,
                null,
                null,
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT)), (NBTEditor.set(ItemUtils.CreateCustomItem(new ItemStack(Material.APPLE), "&fBread Dough", "", false), 11, "custom_model_data")));
    }

    @Override
    public void onDisable() {
    }
}
