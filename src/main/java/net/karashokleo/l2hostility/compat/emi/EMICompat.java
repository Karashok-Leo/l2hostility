package net.karashokleo.l2hostility.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.karashokleo.l2hostility.L2Hostility;
import net.karashokleo.l2hostility.compat.loot.ITraitLootRecipe;
import net.karashokleo.l2hostility.content.loot.modifier.EnvyLootModifier;
import net.karashokleo.l2hostility.content.loot.modifier.GluttonyLootModifier;
import net.karashokleo.l2hostility.content.recipe.BurntRecipe;
import net.karashokleo.l2hostility.content.trait.base.MobTrait;
import net.karashokleo.l2hostility.init.*;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class EMICompat implements EmiPlugin
{
    public static final Identifier LOOT = L2Hostility.id("loot");
    public static final Identifier BURNT = L2Hostility.id("burnt");
    public static final EmiRecipeCategory LOOT_CATEGORY = new EMICategory(LOOT, EmiStack.of(Items.IRON_SWORD), LHTexts.LOOT_TITLE::get);
    public static final EmiRecipeCategory BURNT_CATEGORY = new EMICategory(BURNT, EmiStack.of(Items.LAVA_BUCKET), LHCplTexts.BURNT_TITLE::get);

    @Override
    public void register(EmiRegistry registry)
    {
        registry.addCategory(LOOT_CATEGORY);
        registry.addCategory(BURNT_CATEGORY);
        registry.addWorkstation(BURNT_CATEGORY, EmiStack.of(Items.LAVA_BUCKET));
        registry.addWorkstation(BURNT_CATEGORY, EmiStack.of(Items.FLINT_AND_STEEL));
        registry.addWorkstation(BURNT_CATEGORY, EmiStack.of(Items.FIRE_CHARGE));

        for (ITraitLootRecipe recipe : ITraitLootRecipe.LIST_CACHE)
        {
            if (recipe instanceof EnvyLootModifier)
                for (MobTrait trait : LHTraits.TRAIT)
                    registry.addRecipe(
                            new EMILootRecipe(recipe)
                                    .setTraits(EmiStack.of(trait.asItem()))
                                    .setLoot(EmiStack.of(trait.asItem()))
                    );
            else if (recipe instanceof GluttonyLootModifier)
                registry.addRecipe(new EMILootRecipe(recipe).setTraits(EmiIngredient.of(LHTags.TRAIT_ITEM)));
            else registry.addRecipe(new EMILootRecipe(recipe));
        }

        for (BurntRecipe recipe : registry.getRecipeManager().listAllOfType(LHRecipes.BURNT_RECIPE_TYPE))
            registry.addRecipe(new EMIBurntRecipe(recipe));
    }
}
