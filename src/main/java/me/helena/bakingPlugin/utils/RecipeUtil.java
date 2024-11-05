package me.helena.bakingPlugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.List;

public class RecipeUtil {


    @SuppressWarnings("SameParameterValue")
    public static void registerRecipes(String key, boolean isShaped, String column1, String column2, String column3, List<ItemStack> ritems, ItemStack output) {
        Recipe recipe = isShaped ? new ShapedRecipe(NamespacedKey.minecraft(key), output) : new ShapelessRecipe(
                NamespacedKey.minecraft(key), output);
        if (recipe instanceof ShapedRecipe shapedRecipe) {
            shapedRecipe.shape(column1, column2, column3);
            for (int i = 0; i < ritems.size(); i++) {

                if (i >= 9) break;

                ItemStack itemStack = ritems.get(i);

                if (itemStack != null)
                    shapedRecipe.setIngredient(Character.forDigit(i + 1, 10), new RecipeChoice.ExactChoice(itemStack));
            }
        } else {
            ShapelessRecipe shapelessRecipe = (ShapelessRecipe) recipe;
            ritems.forEach((itemStack) -> {
                if (itemStack != null) shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(itemStack));});
        }
        Bukkit.removeRecipe(NamespacedKey.minecraft(key));
        Bukkit.addRecipe(recipe);

    }


   // public static void registerFurnaceRecipes(String key)
}
