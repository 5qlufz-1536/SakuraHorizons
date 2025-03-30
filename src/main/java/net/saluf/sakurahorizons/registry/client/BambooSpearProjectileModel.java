package net.saluf.sakurahorizons.registry.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.saluf.sakurahorizons.SakuraHorizonsMod;

public class BambooSpearProjectileModel extends EntityModel<ProjectileEntityRenderState> {

    public static final EntityModelLayer TAKEYARI = new EntityModelLayer(Identifier.of(SakuraHorizonsMod.MOD_ID, "takeyari"), "main");
    private final ModelPart group;
    private final ModelPart bb_main;

    public BambooSpearProjectileModel(ModelPart root) {
        super(root, RenderLayer::getEntitySolid);
        this.group = root.getChild("group");
        this.bb_main = root.getChild("bb_main");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData group = modelPartData.addChild("group", ModelPartBuilder.create(), ModelTransform.of(-8.0F, 18.45F, -14.375F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r1 = group.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0161F, -0.8827F, 1.0F, 0.1F, 1.35F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -1.0761F, -0.8827F, 1.0F, 0.1F, 1.35F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -1.0761F, -0.4827F, 1.0F, 0.4F, 1.45F, new Dilation(0.0F)), ModelTransform.of(9.0F, 0.0F, -3.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r2 = group.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.05F, 0.3F, 1.0F, 0.2F, 3.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, -0.2F, -5.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r3 = group.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.63F, 0.2F, 1.0F, 0.5F, 1.8F, new Dilation(0.0F)), ModelTransform.of(9.0F, -0.2F, -4.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -16.0F, 1.0F, 1.0F, 29.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -5.0F, 12.6F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    public void setAngles(ProjectileEntityRenderState projectileEntityRenderState) {
        super.setAngles(projectileEntityRenderState);
        if (projectileEntityRenderState.shake > 0.0F) {
            float f = -MathHelper.sin(projectileEntityRenderState.shake * 3.0F) * projectileEntityRenderState.shake;
            this.root.roll += f * (float) (Math.PI / 180.0);
        }
    }
}
