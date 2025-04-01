package net.saluf.sakurahorizons.world.gen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.registry.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> RICE_CROP_PLACED_KEY = registerKey("rice_crop_placed");
    public static final RegistryKey<PlacedFeature> DAIZU_CROP_PLACED_KEY = registerKey("daizu_crop_placed");
    public static final RegistryKey<PlacedFeature> APRICOT_WOOD_PLACED_KEY = registerKey("apricot_wood_placed");
    public static final RegistryKey<PlacedFeature> MAPLE_WOOD_PLACED_KEY = registerKey("maple_wood_placed");
    public static final RegistryKey<PlacedFeature> GREENTEA_BUSH_PLACED_KEY = registerKey("greentea_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, RICE_CROP_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.RICE_CROP_KEY),
                RarityFilterPlacementModifier.of(21),
                NoiseThresholdCountPlacementModifier.of(0.2D, 1, 5),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        register(context, DAIZU_CROP_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.DAIZU_CROP_KEY),
                RarityFilterPlacementModifier.of(21),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        register(context, APRICOT_WOOD_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.APRICOT_WOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.APRICOT_OAK_SAPLING
                ));

        register(context, MAPLE_WOOD_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_WOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.MAPLE_SAPLING
                ));

        register(context, GREENTEA_BUSH_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.GREENTEA_BUSH_KEY),
                RarityFilterPlacementModifier.of(32),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SakuraHorizonsMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
