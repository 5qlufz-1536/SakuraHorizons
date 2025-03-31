package net.saluf.sakurahorizons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.saluf.sakurahorizons.client.MortarScreen;
import net.saluf.sakurahorizons.registry.*;
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
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREENTEA_BUSH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APRICOT_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
        ModWorldGeneration.generateModWorldGen();

        EntityModelLayerRegistry.registerModelLayer(BambooSpearProjectileModel.TAKEYARI, BambooSpearProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.THROWN_BAMBOO_SPEAR, BambooSpearProjectileRenderer::new);
        System.out.println("Mod初期化完了");
    }
}
