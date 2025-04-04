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
                        entries.add(ModItems.OKAKA_ONIGIRI);
                        entries.add(ModItems.SHAKE_ONIGIRI);
                        entries.add(ModItems.SHIO_ONIGIRI);
                        entries.add(ModItems.YAKI_ONIGIRI);
                        entries.add(ModItems.TORIGOMOKU);
                        entries.add(ModItems.UME_ONIGIRI);
                        entries.add(ModItems.TUNA_ONIGIRI);

                        entries.add(ModBlocks.SOY_BEAN_CROP_BLOCK);
                        entries.add(ModItems.SHOYU);
                        entries.add(ModItems.HIYAYAKKO);
                        entries.add(ModItems.TOFU);
                        entries.add(ModItems.TONYU);
                        entries.add(ModItems.NIGARI);
                        entries.add(ModItems.SALT);

                        entries.add(ModItems.AYU);
                        entries.add(ModItems.SHIO_AYU);
                        entries.add(ModItems.AYU_SHIOYAKI);
                        entries.add(ModItems.KATSUO);
                        entries.add(ModItems.KATSUOBUSHI);
                        entries.add(ModItems.SHAKE_FLAKE);
                        entries.add(ModItems.TUNA);

                        entries.add(ModItems.NAGINATA);
                        entries.add(ModItems.TAKEYARI);

                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_LEAVES);
                        entries.add(ModBlocks.MAPLE_SAPLING);

                        entries.add(ModBlocks.APRICOT_OAK_LOG);
                        entries.add(ModBlocks.APRICOT_OAK_WOOD);
                        entries.add(ModBlocks.APRICOT_OAK_PLANKS);
                        entries.add(ModBlocks.APRICOT_OAK_STAIRS);
                        entries.add(ModBlocks.APRICOT_OAK_SLAB);
                        entries.add(ModBlocks.APRICOT_OAK_LEAVES);
                        entries.add(ModBlocks.APRICOT_OAK_SAPLING);
                        entries.add(ModBlocks.APRICOT_OAK_FENCE);
                        entries.add(ModBlocks.APRICOT_OAK_FENCE_GATE);
                        entries.add(ModBlocks.APRICOT_OAK_PRESSURE_PLATE);

                        entries.add(ModItems.TYABA);
                        entries.add(ModItems.RYOKUTYA);
                        entries.add(ModItems.MATTYA);
                        entries.add(ModItems.MATTYA_KONA);
                        entries.add(ModItems.UME);
                        entries.add(ModItems.UMEBOSHI);
                        entries.add(ModItems.RICE_CROP_SEEDS);
                        entries.add(ModBlocks.RICE_CROP_BLOCK);
                        entries.add(ModItems.AMAZAKE);
                        entries.add(ModItems.MEITESTU);
                        entries.add(ModItems.TAKENOKO);


                    })).build());

    public static void registerItemGroups() {

    }
}
