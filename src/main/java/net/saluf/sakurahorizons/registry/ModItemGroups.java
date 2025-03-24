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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ONIGIRI))
                    .displayName(Text.translatable("itemgroup.sakurahorizons.main"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.ONIGIRI);
                        entries.add(ModItems.TOFU);
                        entries.add(ModItems.SHAKE_ONIGIRI);
                        entries.add(ModItems.TORIGOMOKU);
                        entries.add(ModItems.SHAKE_FLAKE);
                        entries.add(ModItems.AYU);
                        entries.add(ModItems.NAGINATA);
                        entries.add(ModItems.NIGARI);
                        entries.add(ModItems.SALT);
                        entries.add(ModBlocks.TEST_OAK_BLOCK);
                        entries.add(ModBlocks.TEST_OAK_BLOCK2);
                    })).build());

    public static void registerItemGroups() {

    }
}
