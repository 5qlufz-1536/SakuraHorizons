package net.saluf.sakurahorizons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.saluf.sakurahorizons.registry.ModBlocks;
import net.saluf.sakurahorizons.registry.ModEntities;
import net.saluf.sakurahorizons.registry.ModItemGroups;
import net.saluf.sakurahorizons.registry.ModItems;
import net.saluf.sakurahorizons.registry.client.BambooSpearProjectileModel;
import net.saluf.sakurahorizons.registry.client.BambooSpearProjectileRenderer;
import net.saluf.sakurahorizons.world.gen.ModWorldGeneration;

public class SakuraHorizonsMod implements ModInitializer {
    public static final String MOD_ID = "sakurahorizons";

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerEntities();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP_BLOCK, RenderLayer.getCutout());
        ModWorldGeneration.generateModWorldGen();

        EntityModelLayerRegistry.registerModelLayer(BambooSpearProjectileModel.TAKEYARI, BambooSpearProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.THROWN_BAMBOO_SPEAR, BambooSpearProjectileRenderer::new);
        System.out.println("Mod初期化完了");
    }
}
