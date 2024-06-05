package net.karashokleo.l2hostility.content.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.karashokleo.l2hostility.L2Hostility;
import net.karashokleo.l2hostility.content.item.misc.tool.Detector;
import net.karashokleo.l2hostility.content.item.misc.tool.DetectorGlasses;
import net.karashokleo.l2hostility.content.item.misc.tool.WitchWand;
import net.karashokleo.l2hostility.content.item.misc.wand.AiConfigWand;
import net.karashokleo.l2hostility.content.item.misc.wand.EquipmentWand;
import net.karashokleo.l2hostility.content.item.misc.wand.TargetSelectWand;
import net.karashokleo.l2hostility.content.item.misc.wand.TraitAdderWand;
import net.karashokleo.l2hostility.content.item.traits.SealedItem;
import net.karashokleo.l2hostility.init.LHItems;
import net.karashokleo.l2hostility.init.LHTags;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.minecraft.item.NetherStarItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class MiscItems
{
    public static final Identifier GUIDE_BOOK = L2Hostility.id("hostility_guide");
    public static Item WITCH_DROPLET;
    public static Detector DETECTOR;
    public static DetectorGlasses DETECTOR_GLASSES;
    public static WitchWand WITCH_WAND;
    public static Item CHAOS_INGOT;
    public static NetherStarItem HOSTILITY_ESSENCE;
    public static NetherStarItem MIRACLE_POWDER;
    public static NetherStarItem MIRACLE_INGOT;
    public static TraitAdderWand TRAIT_ADDER_WAND;
    public static TargetSelectWand TARGET_SELECT_WAND;
    public static AiConfigWand AI_CONFIG_WAND;
    public static EquipmentWand EQUIPMENT_WAND;
    public static SealedItem SEAL;

    public static void register()
    {
        WITCH_DROPLET = LHItems.Entry.of(
                        "witch_droplet",
                        new Item(
                                new FabricItemSettings()
                        )
                )
                .addModel()
                .addEN()
                .addZH("女巫浓缩凝露")
                .register();


        DETECTOR = LHItems.Entry.of(
                        "hostility_detector",
                        new Detector(
                                new FabricItemSettings()
                                        .maxCount(1)
                        )
                )
                .addModel()
                .addEN()
                .addZH("恶意探测器")
                .register();

        DETECTOR_GLASSES = LHItems.Entry.of(
                        "detector_glasses",
                        new DetectorGlasses(
                                new FabricItemSettings()
                                        .maxCount(1)
                        )
                )
                .addModel()
                .addEN()
                .addZH("侦测眼镜")
                .addTag(LHTags.FACE_SLOT)
                .register();

        WITCH_WAND = LHItems.Entry.of(
                        "witch_wand",
                        new WitchWand(
                                new FabricItemSettings()
                                        .maxDamage(300)
                                        .rarity(Rarity.EPIC)
                                        .fireproof()
                        )
                )
                .addModel(Models.HANDHELD)
                .addEN()
                .addZH("混乱魔药法杖")
                .addTag(LHTags.CHAOS)
                .register();

        CHAOS_INGOT = LHItems.Entry.of(
                        "chaos_ingot",
                        new Item(
                                new FabricItemSettings()
                                        .rarity(Rarity.EPIC)
                                        .fireproof()
                        )
                )
                .addModel()
                .addEN()
                .addZH("混沌锭")
                .addTag(LHTags.CHAOS)
                .register();

        HOSTILITY_ESSENCE = LHItems.Entry.of(
                        "hostility_essence",
                        new NetherStarItem(
                                new FabricItemSettings()
                                        .rarity(Rarity.EPIC)
                                        .fireproof()
                        )
                )
                .addModel()
                .addEN()
                .addZH("恶意精华")
                .register();

        MIRACLE_POWDER = LHItems.Entry.of(
                        "miracle_powder",
                        new NetherStarItem(
                                new FabricItemSettings()
                                        .rarity(Rarity.EPIC)
                                        .fireproof()
                        )
                )
                .addModel()
                .addEN()
                .addZH("奇迹粉末")
                .register();

        MIRACLE_INGOT = LHItems.Entry.of(
                        "miracle_ingot",
                        new NetherStarItem(
                                new FabricItemSettings()
                                        .rarity(Rarity.EPIC)
                                        .fireproof()
                        )
                )
                .addModel()
                .addEN()
                .addZH("奇迹锭")
                .register();


        TRAIT_ADDER_WAND = LHItems.Entry.of(
                        "trait_adder_wand",
                        new TraitAdderWand(
                                new FabricItemSettings()
                                        .maxCount(1)
                        )
                )
                .addModel(Models.HANDHELD)
                .addEN()
                .addZH("词条配置手杖")
                .register();

        TARGET_SELECT_WAND = LHItems.Entry.of(
                        "target_select_wand",
                        new TargetSelectWand(
                                new FabricItemSettings()
                                        .maxCount(1)
                        )
                )
                .addModel(Models.HANDHELD)
                .addEN()
                .addZH("攻击目标控制手杖")
                .register();

        EQUIPMENT_WAND = LHItems.Entry.of(
                        "equipment_wand",
                        new EquipmentWand(
                                new FabricItemSettings()
                                        .maxCount(1)
                        )
                )
                .addModel(Models.HANDHELD)
                .addEN()
                .addZH("装备配置手杖")
                .register();

        AI_CONFIG_WAND = LHItems.Entry.of(
                        "ai_config_wand",
                        new AiConfigWand(
                                new FabricItemSettings()
                                        .maxCount(1)
                        )
                )
                .addModel(Models.HANDHELD)
                .addEN()
                .addZH("AI控制手杖")
                .register();

        SEAL = LHItems.Entry.of(
                        "sealed_item",
                        new SealedItem(
                                new FabricItemSettings()
                                        .maxCount(1)
                                        .fireproof()
                        )
                )
                .addModel(Models.HANDHELD)
                .addEN()
                .addZH("被封印的物品")
                .addTag(LHTags.NO_SEAL)
                .setTab(null)
                .register();
    }
}
