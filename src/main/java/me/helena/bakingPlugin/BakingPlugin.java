package me.helena.bakingPlugin;

import me.helena.bakingPlugin.utils.FishTrapListener;
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

        getServer().getPluginManager().registerEvents(new FurnaceRecipeDetector(), this);

        getServer().getPluginManager().registerEvents(new CakeBatterEat(), this);

        ItemStack output = new ItemStack(Material.CAKE);

        Bukkit.addRecipe(new FurnaceRecipe(output, Material.MUSHROOM_STEW));

        Bukkit.removeRecipe(NamespacedKey.minecraft("cake"));


        RecipeUtil.registerRecipes("cakebatter", true, "123", "456", "789", Arrays.asList(
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.WHEAT),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.EGG),
                new ItemStack(Material.SUGAR),
                new ItemStack(Material.MILK_BUCKET),
                new ItemStack(Material.BOWL),
                new ItemStack(Material.MILK_BUCKET)), (ItemUtils.CreateCustomItem(new ItemStack(Material.MUSHROOM_STEW), "&fCake Batter", "", false)));

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
