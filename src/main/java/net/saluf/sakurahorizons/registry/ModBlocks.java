package net.saluf.sakurahorizons.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.custom.GreenTeaBushBlock;
import net.saluf.sakurahorizons.custom.RiceCropBlock;

import java.util.function.Function;

public class ModBlocks {

    public static final Block OAK_BLOCK = register("test_oak_block", Block::new, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD), true);
    public static final Block APRICOT_OAK_LOG = register("apricot_oak_log", PillarBlock::new, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD), true);
    public static final Block APRICOT_OAK_WOOD = register("apricot_oak_wood", PillarBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block APRICOT_OAK_PLANKS = register("apricot_oak_planks", SlabBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block APRICOT_OAK_PRESSURE_PLATE = register("apricot_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final Block APRICOT_OAK_LEAVES = register("apricot_oak_leaves", LeavesBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).burnable(), true);
    public static final Block RICE_CROP_BLOCK = register("rice_crop_block", RiceCropBlock::new, AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.CROP).ticksRandomly().breakInstantly().nonOpaque(), true);
    public static final Block GREENTEA_BUSH_BLOCK = register("greentea_bush_block", GreenTeaBushBlock::new,AbstractBlock.Settings.create().sounds(BlockSoundGroup.SWEET_BERRY_BUSH),true);

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SakuraHorizonsMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SakuraHorizonsMod.MOD_ID, name));
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register( entries -> {
            entries.add(ModBlocks.OAK_BLOCK);
        });
    }
}
