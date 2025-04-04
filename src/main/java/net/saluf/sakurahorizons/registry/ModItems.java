package net.saluf.sakurahorizons.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.custom.BambooSpearItem;
import net.saluf.sakurahorizons.registry.entity.ModConsumableComponents;

import java.util.function.Function;

public class ModItems {

    public static final ToolMaterial GUIDITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            455,
            5.0F,
            1.5F,
            20,
            ItemTags.SWORDS
    );
    // 例：通常のアイテム
    //public static final Item ONIGIRI = registerItem("onigiri", Item::new, new Item.Settings());
    public static final Item ONIGIRI = registerItem("onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item TOFU = registerItem("tofu", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item SHAKE_ONIGIRI = registerItem("shake_onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item NAGINATA = registerItem("naginata",settings -> new SwordItem(GUIDITE_TOOL_MATERIAL, 11f, -3.4f, settings), new Item.Settings().enchantable(15));
    public static final Item SALT = registerItem("salt", Item::new, new Item.Settings());
    public static final Item TORIGOMOKU = registerItem("torigomoku",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(9).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item NIGARI = registerItem("nigari", Item::new, new Item.Settings().maxCount(16));
    public static final Item SHAKE_FLAKE = registerItem("shakeflake",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).build())), new Item.Settings());
    public static final Item AYU = registerItem("ayu",settings -> new Item (settings.food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item TAKENOKO = registerItem("takenoko", Item::new, new Item.Settings());
    public static final Item RICE_CROP_SEEDS = registerItem("rice_crop_seeds", Item::new, new Item.Settings());
    public static final Item TAKEYARI = registerItem("takeyari", BambooSpearItem::new, new Item.Settings().maxDamage(150) );
    public static final Item SHIO_ONIGIRI = registerItem("shio_onigiri",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item YAKI_ONIGIRI = registerItem("yaki_onigiri",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item SHOYU = registerItem("shoyu",Item::new, new Item.Settings().maxCount(16));
    public static final Item KATSUO = registerItem("katsuo",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item TYABA = registerItem("tyaba", settings -> new BlockItem(ModBlocks.GREENTEA_BUSH_BLOCK, settings), new Item.Settings());
    public static final Item TONYU = registerItem("tonyu",settings -> new PotionItem(settings.food(new FoodComponent.Builder().nutrition(0).saturationModifier(0.3f).build(), ModConsumableComponents.TONYU)), new Item.Settings());
    public static final Item TUNA = registerItem("tuna",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item KATSUOBUSHI = registerItem("katsuobushi", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).build())), new Item.Settings());
    public static final Item MEITESTU = registerItem("meitetsu",Item::new, new Item.Settings());
    public static final Item HIYAYAKKO = registerItem("hiyayakko",settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item AMAZAKE = registerItem("amazake", settings -> new PotionItem(settings.food(new FoodComponent.Builder().nutrition(0).saturationModifier(0.3f).build(), ModConsumableComponents.AMAZAKE)), new Item.Settings());
    public static final Item OKAKA_ONIGIRI = registerItem("okaka_onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item RYOKUTYA = registerItem("ryokutya", settings -> new PotionItem(settings.food(new FoodComponent.Builder().nutrition(0).saturationModifier(0.3f).build(), ModConsumableComponents.RYOKUTYA)), new Item.Settings());
    public static final Item MATTYA = registerItem("mattya", settings -> new PotionItem(settings.food(new FoodComponent.Builder().nutrition(0).saturationModifier(0.3f).build(), ModConsumableComponents.MATTYA)), new Item.Settings());
    public static final Item UMEBOSHI = registerItem("umeboshi", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build(), ModConsumableComponents.UMEBOSHI)), new Item.Settings());
    public static final Item UME_ONIGIRI = registerItem("ume_onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item TUNA_ONIGIRI = registerItem("tuna_onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item MATTYA_KONA = registerItem("mattya_kona", Item::new, new Item.Settings());
    public static final Item AYU_SHIOYAKI = registerItem("ayunoshioyaki", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item UME = registerItem("ume", Item::new, new Item.Settings());
    public static final Item SHIO_AYU = registerItem("shio_ayu", Item::new, new Item.Settings());
    //public static final Item EXAMPLE_ITEM = registerItem("onigiri", (Function<Item.Settings, Item>) new BlockItem(ModBlocks.RICE_CROP_BLOCK, new Item.Settings()), new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sakurahorizons", name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ONIGIRI);
            entries.add(TOFU);
            entries.add(SHAKE_ONIGIRI);
            entries.add(TORIGOMOKU);
            entries.add(SHAKE_FLAKE);
            entries.add(AYU);
            entries.add(SHIO_ONIGIRI);
            entries.add(YAKI_ONIGIRI);
            entries.add(KATSUO);
            entries.add(TONYU);
            entries.add(TUNA);
            entries.add(KATSUOBUSHI);
            entries.add(HIYAYAKKO);
            entries.add(AMAZAKE);
            entries.add(OKAKA_ONIGIRI);
            entries.add(RYOKUTYA);
            entries.add(MATTYA);
            entries.add(UMEBOSHI);
            entries.add(UME_ONIGIRI);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(NAGINATA);
            entries.add(TAKEYARI);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SALT);
            entries.add(NIGARI);
            entries.add(TAKENOKO);
            entries.add(RICE_CROP_SEEDS);
            entries.add(SHOYU);
            entries.add(TYABA);
            entries.add(MEITESTU);
        });
    }
}
