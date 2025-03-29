package net.saluf.sakurahorizons.registry.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.registry.entity.BambooSpearEntity;

public class BambooSpearProjectileRenderer extends EntityRenderer<BambooSpearEntity, BambooSpearEntityState> {
    protected BambooSpearProjectileModel model;
    public static final Identifier TEXTURE = Identifier.of(SakuraHorizonsMod.MOD_ID, "textures/entity/takeyari/takeyari.png");

    public BambooSpearProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new BambooSpearProjectileModel(context.getPart(BambooSpearProjectileModel.TAKEYARI));
    }

    @Override
    public BambooSpearEntityState createRenderState() {
        return new BambooSpearEntityState();
    }

    @Override
    public void render(BambooSpearEntityState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(BambooSpearEntityState.yaw - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(BambooSpearEntityState.pitch + 90.0F)); // + 90.0F
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers, this.model.getLayer(TEXTURE), false, false
        );
        this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(state, matrixStack, vertexConsumers, light);
    }
}
