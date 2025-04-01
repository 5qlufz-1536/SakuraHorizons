package net.saluf.sakurahorizons.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.world.gen.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator APRICOT_WOOD = new SaplingGenerator(SakuraHorizonsMod.MOD_ID + ":apricot_wood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.APRICOT_WOOD_KEY), Optional.empty());
    public static final SaplingGenerator MAPLE_WOOD = new SaplingGenerator(SakuraHorizonsMod.MOD_ID + ":maple_wood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MAPLE_WOOD_KEY), Optional.empty());
}
