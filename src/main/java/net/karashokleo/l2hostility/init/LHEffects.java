package net.karashokleo.l2hostility.init;

import net.karashokleo.l2hostility.L2Hostility;
import net.karashokleo.l2hostility.content.effect.*;
import net.karashokleo.leobrary.datagen.builder.StatusEffectBuilder;
import net.karashokleo.leobrary.datagen.generator.TagGenerator;
import net.karashokleo.leobrary.datagen.generator.LanguageGenerator;
import net.minecraft.entity.effect.StatusEffect;
import org.jetbrains.annotations.Nullable;

public class LHEffects
{
    public static GravityEffect GRAVITY = new GravityEffect();
    public static MoonwalkEffect MOONWALK = new MoonwalkEffect();
    public static AntiBuildEffect ANTI_BUILD = new AntiBuildEffect();
    public static FlameEffect FLAME = new FlameEffect();
    public static IceEffect ICE = new IceEffect();
    public static CurseEffect CURSE = new CurseEffect();
    public static CleanseEffect CLEANSE = new CleanseEffect();
    public static StoneCageEffect STONE_CAGE = new StoneCageEffect();

    public static void register()
    {
        GRAVITY = Entry.of(
                        "gravity",
                        new GravityEffect()
                )
                .addEN()
                .addENDesc("Increase entity gravity.")
                .addZH("重力")
                .addZHDesc("增加生物重力")
                .register();
        MOONWALK = Entry.of(
                        "moonwalk",
                        new MoonwalkEffect()
                )
                .addEN()
                .addENDesc("Decrease entity gravity.")
                .addZH("月步")
                .addZHDesc("减少生物重力")
                .register();
        ANTI_BUILD = Entry.of(
                        "anti_build",
                        new AntiBuildEffect()
                )
                .addEN("Antibuild")
                .addENDesc("Make player cannot place block.")
                .addZH("领域压制")
                .addZHDesc("玩家无法放置方块")
                .addTag(LHTags.SKILL_EFFECT)
                .register();
        FLAME = Entry.of(
                        "flame",
                        new FlameEffect()
                )
                .addEN("Soul Burning")
                .addENDesc("Continuously damage the entity. Bypass fire resistance, but fire-based mobs are immune to this.")
                .addZH("魂火")
                .addZHDesc("持续造成伤害。无视火焰免疫，但是不会对火基生物造成伤害")
                .register();
        ICE = Entry.of(
                        "ice",
                        new IceEffect()
                )
                .addEN("Frost")
                .addENDesc("Slow down entity, and freeze them as if they are on powdered snow.")
                .addZH("寒流")
                .addZHDesc("让实体减速，等同于让实体陷入细雪")
                .register();
        CURSE = Entry.of(
                        "curse",
                        new CurseEffect()
                )
                .addEN("Cursed")
                .addENDesc("Make the entity cannot heal.")
                .addZH("诅咒")
                .addZHDesc("持续阻止回血")
                .register();
        CLEANSE = Entry.of(
                        "cleanse",
                        new CleanseEffect()
                )
                .addEN("Cleansed")
                .addENDesc("Clear all potion effects and make the entity immune to potion effects.")
                .addZH("净化")
                .addZHDesc("清除所有效果，并且持续免疫药水效果")
                .register();
        STONE_CAGE = Entry.of(
                        "stone_cage",
                        new StoneCageEffect()
                )
                .addEN("Incarceration")
                .addENDesc("Immobilize the entity. Making it cannot move and unaffected by external forces.")
                .addZH("禁锢")
                .addZHDesc("让实体无法移动，也无法改变位置")
                .register();
    }

    static class Entry<T extends StatusEffect> extends StatusEffectBuilder<T>
    {
        public static <T extends StatusEffect> Entry<T> of(String name, T effect)
        {
            return new Entry<>(name, effect);
        }

        private Entry(String name, T effect)
        {
            super(name, effect);
        }

        @Override
        public @Nullable LanguageGenerator getEnglishGenerator()
        {
            return LHData.EN_TEXTS;
        }

        @Override
        public @Nullable LanguageGenerator getChineseGenerator()
        {
            return LHData.ZH_TEXTS;
        }

        @Override
        public @Nullable TagGenerator<StatusEffect> getTagGenerator()
        {
            return LHData.STATUS_EFFECT_TAGS;
        }

        @Override
        protected String getNameSpace()
        {
            return L2Hostility.MOD_ID;
        }
    }
}
