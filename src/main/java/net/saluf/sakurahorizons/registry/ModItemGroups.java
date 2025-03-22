package net.saluf.sakurahorizons.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;

public class ModItemGroups {

    public  static final ItemGroup SAKURA_HORIZONS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SakuraHorizonsMod.MOD_ID, "sakurahorizons_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM))
                    .displayName(Text.translatable("itemgroup.sakurahorizons.main"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.EXAMPLE_ITEM);
                        entries.add(ModItems.TOFU);
                    })).build());

    public static void registerItemGroups() {

    }
}
