package net.karashokleo.l2hostility.content.advancement;

import dev.xkmc.l2serial.serialization.SerialClass;
import net.karashokleo.l2hostility.content.advancement.base.BaseCriterion;
import net.karashokleo.l2hostility.content.advancement.base.BaseCriterionConditions;
import net.karashokleo.l2hostility.content.component.mob.MobDifficulty;
import net.karashokleo.l2hostility.init.registry.LHTriggers;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class KillTraitCountTrigger extends BaseCriterion<KillTraitCountTrigger.Condition, KillTraitCountTrigger>
{
    public static Condition condition(int count)
    {
        var ans = new Condition(LHTriggers.TRAIT_COUNT.getId(), LootContextPredicate.EMPTY);
        ans.count = count;
        return ans;
    }

    public KillTraitCountTrigger(Identifier id)
    {
        super(id, Condition::new, Condition.class);
    }

    public void trigger(ServerPlayerEntity player, MobDifficulty cap)
    {
        this.trigger(player, e -> e.matchAll(cap));
    }

    @SerialClass
    public static class Condition extends BaseCriterionConditions<Condition, KillTraitCountTrigger>
    {
        @SerialClass.SerialField
        public int count;

        public Condition(Identifier id, LootContextPredicate player)
        {
            super(id, player);
        }

        public boolean matchAll(MobDifficulty cap)
        {
            return cap.traits.size() >= count;
        }
    }
}