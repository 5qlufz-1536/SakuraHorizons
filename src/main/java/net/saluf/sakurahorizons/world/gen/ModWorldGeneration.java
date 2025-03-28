package net.saluf.sakurahorizons.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                //BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.RICE_CROP_PLACED_KEY);
    }
}
