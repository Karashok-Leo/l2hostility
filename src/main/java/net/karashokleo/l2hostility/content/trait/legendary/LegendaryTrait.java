package net.karashokleo.l2hostility.content.trait.legendary;

import net.karashokleo.l2hostility.config.LHConfig;
import net.karashokleo.l2hostility.content.logic.TraitManager;
import net.karashokleo.l2hostility.content.trait.base.MobTrait;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Formatting;

public class LegendaryTrait extends MobTrait
{
    public LegendaryTrait(Formatting format)
    {
        super(format);
    }

    @Override
    public boolean allow(LivingEntity le, int difficulty, int maxModLv)
    {
        return maxModLv > TraitManager.getMaxLevel() && super.allow(le, difficulty, maxModLv);
    }

    @Override
    public boolean isBanned()
    {
        return !LHConfig.common().scaling.allowLegendary || super.isBanned();
    }
}