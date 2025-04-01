package net.saluf.sakurahorizons.world.gen;

import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.registry.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> RICE_CROP_KEY = registerKey("rice_crop");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAIZU_CROP_KEY = registerKey("daizu_crop");
    public static final RegistryKey<ConfiguredFeature<?, ?>> APRICOT_WOOD_KEY = registerKey("apricot_wood");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_WOOD_KEY = registerKey("maple_wood");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREENTEA_BUSH_KEY = registerKey("greentea_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, RICE_CROP_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RICE_CROP_BLOCK.getDefaultState())),
                        List.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND)
                )
        );

        register(context, DAIZU_CROP_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SOY_BEAN_CROP_BLOCK.getDefaultState())),
                        List.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND)
                ));

        register(context, APRICOT_WOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.APRICOT_OAK_LOG),
                new StraightTrunkPlacer(5, 3, 1),
                BlockStateProvider.of(ModBlocks.APRICOT_OAK_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(2, 4, 3)
        ).build());

        register(context, MAPLE_WOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(5, 4, 2),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(3), UniformIntProvider.create(4, 6)),
                new TwoLayersFeatureSize(0, 4, 3)
        ).build());

        register(context, GREENTEA_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREENTEA_BUSH_BLOCK.getDefaultState().with(SweetBerryBushBlock.AGE, 3)))
                ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SakuraHorizonsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
