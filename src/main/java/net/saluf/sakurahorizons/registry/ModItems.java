package net.saluf.sakurahorizons.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    // 例：通常のアイテム
    //public static final Item EXAMPLE_ITEM = registerItem("onigiri", Item::new, new Item.Settings());
    public static final Item EXAMPLE_ITEM = registerItem("onigiri", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f).build())), new Item.Settings());
    public static final Item TOFU = registerItem("tofu", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build())), new Item.Settings());
    //public static final Item TOFU = registerItem("tofu", settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build())), new Item.Settings());
    //public static final Item EXAMPLE_ITEM = registerItem("onigiri", OnigiriItem::new, new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sakurahorizons", name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(EXAMPLE_ITEM);
            entries.add(TOFU);
        });
    }
}
