package net.saluf.sakurahorizons.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

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
    public static final Item ONIGIRI = registerItem("onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item TOFU = registerItem("tofu", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item SHAKE_ONIGIRI = registerItem("shake_onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item NAGINATA = registerItem("naginata",settings -> new SwordItem(GUIDITE_TOOL_MATERIAL,11f,-3.4f,settings),new Item.Settings());
    //public static final Item ONIGIRI = registerItem("onigiri", OnigiriItem::new, new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sakurahorizons", name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ONIGIRI);
            entries.add(TOFU);
            entries.add(SHAKE_ONIGIRI);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(NAGINATA);
        });
    }
}