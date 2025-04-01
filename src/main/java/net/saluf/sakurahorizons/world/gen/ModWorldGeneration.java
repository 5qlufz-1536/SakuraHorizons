package net.saluf.sakurahorizons.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST, BiomeKeys.CHERRY_GROVE, BiomeKeys.FOREST),
                //BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.RICE_CROP_PLACED_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST, BiomeKeys.CHERRY_GROVE, BiomeKeys.TAIGA, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.DAIZU_CROP_PLACED_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.APRICOT_WOOD_PLACED_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.MAPLE_WOOD_PLACED_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST, BiomeKeys.CHERRY_GROVE, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.GREENTEA_BUSH_PLACED_KEY
        );
    }
}
