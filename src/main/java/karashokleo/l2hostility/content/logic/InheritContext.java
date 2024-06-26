package karashokleo.l2hostility.content.logic;

import karashokleo.l2hostility.content.component.mob.MobDifficulty;
import net.minecraft.entity.LivingEntity;

public record InheritContext(
        LivingEntity parent,
        MobDifficulty parentCap,
        LivingEntity child,
        MobDifficulty childCap,
        boolean isPrimary
)
{
}
