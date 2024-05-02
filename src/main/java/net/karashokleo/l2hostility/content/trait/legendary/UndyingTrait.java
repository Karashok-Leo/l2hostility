package net.karashokleo.l2hostility.content.trait.legendary;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.karashokleo.l2hostility.client.TraitEffect;
import net.karashokleo.l2hostility.client.TraitEffectToClient;
import net.karashokleo.l2hostility.content.component.mob.MobDifficulty;
import net.karashokleo.l2hostility.init.LHEffects;
import net.karashokleo.l2hostility.init.LHNetworking;
import net.karashokleo.l2hostility.init.LHTraits;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.Formatting;

public class UndyingTrait extends LegendaryTrait
{
    public static final ServerLivingEntityEvents.AllowDeath allowDeath = (entity, source, amount) ->
    {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) return true;
        var diff = MobDifficulty.get(entity);
        if (diff.isEmpty()) return true;
        if (diff.get().hasTrait(LHTraits.SPLIT)) return true;
        if (diff.get().hasTrait(LHTraits.UNDYING) && validTarget(entity))
        {
            entity.setHealth(0.1F);
            entity.heal(entity.getMaxHealth() - entity.getHealth());
            LHNetworking.toTracking(entity, new TraitEffectToClient(entity, LHTraits.UNDYING, TraitEffect.UNDYING));
            return false;
        } else return true;
    };

    public static boolean validTarget(LivingEntity le)
    {
        if (le instanceof EnderDragonEntity)
            return false;
        return le.canHaveStatusEffect(new StatusEffectInstance(LHEffects.CURSE, 100));
    }

    // 传奇词条，使怪物拥有无限续杯的不死图腾。
    // 怪物死亡时会试图使用不死图腾来使自己满血复活。
    public UndyingTrait()
    {
        super(Formatting.DARK_BLUE);
    }

    @Override
    public boolean allow(LivingEntity le, int difficulty, int maxModLv)
    {
        return validTarget(le) && super.allow(le, difficulty, maxModLv);
    }
}
