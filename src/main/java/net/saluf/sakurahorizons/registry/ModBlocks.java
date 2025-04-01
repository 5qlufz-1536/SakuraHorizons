package net.saluf.sakurahorizons.registry;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.custom.GreenTeaBushBlock;
import net.saluf.sakurahorizons.custom.MortarBlock;
import net.saluf.sakurahorizons.custom.RiceCropBlock;
import net.saluf.sakurahorizons.custom.SoyBeenCropBlock;

import java.util.function.Function;

public class ModBlocks {

    public static final Block APRICOT_OAK_LOG = register("apricot_oak_log", PillarBlock::new, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD), true);
    public static final Block APRICOT_OAK_WOOD = register("apricot_oak_wood", PillarBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block APRICOT_OAK_PLANKS = register("apricot_oak_planks", PillarBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block APRICOT_OAK_SLAB = register("apricot_oak_slab", SlabBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block APRICOT_OAK_STAIRS = register("apricot_oak_stairs", settings -> new StairsBlock(ModBlocks.APRICOT_OAK_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD), true);
    public static final Block APRICOT_OAK_PRESSURE_PLATE = register("apricot_oak_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY), true);
    public static final Block APRICOT_OAK_LEAVES = register("apricot_oak_leaves", LeavesBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().nonOpaque().sounds(BlockSoundGroup.GRASS).burnable().suffocates(Blocks::never).blockVision(Blocks::never).pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never), true);
    public static final Block APRICOT_OAK_SAPLING = register("apricot_oak_sapling", settings -> new SaplingBlock(SaplingGenerator.OAK, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY), true);
    public static final Block APRICOT_OAK_FENCE = register("apricot_oak_fence", FenceBlock::new, AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block APRICOT_OAK_FENCE_GATE = register("apricot_oak_fence_gate", settings -> new FenceGateBlock(WoodType.OAK, settings), AbstractBlock.Settings.create().solid().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block MORTAR = register("mortar", MortarBlock::new, AbstractBlock.Settings.create().strength(4f), true);
    public static final Block RICE_CROP_BLOCK = register("rice_crop_block", RiceCropBlock::new, AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.CROP).ticksRandomly().breakInstantly().nonOpaque(), true);
    public static final Block GREENTEA_BUSH_BLOCK = register("greentea_bush_block", GreenTeaBushBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY),true);
    public static final Block SOY_BEAN_CROP_BLOCK = register("daizu_crop_block", SoyBeenCropBlock::new, AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.CROP).ticksRandomly().breakInstantly().nonOpaque(), true);
    public static final Block MAPLE_LOG = register("maple_log", PillarBlock::new, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD),true);
    public static final Block MAPLE_WOOD = register("maple_wood", PillarBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable(),true);
    public static final Block MAPLE_PLANKS = register("maple_planks", PillarBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F,3.0F).sounds(BlockSoundGroup.WOOD).burnable(),true);
    public static final Block MAPLE_SLAB = register("maple_slab", SlabBlock::new, AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable(), true);
    public static final Block MAPLE_STAIRS = register("maple_stairs", settings -> new StairsBlock(ModBlocks.MAPLE_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD), true);
    public static final Block MAPLE_LEAVES = register("maple_leaves", LeavesBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).ticksRandomly().nonOpaque().sounds(BlockSoundGroup.GRASS).burnable().suffocates(Blocks::never).blockVision(Blocks::never).pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never), true);
    public static final Block MAPLE_SAPLING = register("maple_sapling", settings -> new SaplingBlock(SaplingGenerator.OAK, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY), true);

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
    }
}
