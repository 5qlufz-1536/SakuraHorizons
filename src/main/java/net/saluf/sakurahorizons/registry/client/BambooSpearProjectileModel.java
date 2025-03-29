package net.saluf.sakurahorizons.registry.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;

public class BambooSpearProjectileModel extends Model {

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
        ModelPartData group = modelPartData.addChild("group", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 4.2F, -8.0F));

        ModelPartData cube_r1 = group.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.94F, -0.5F, 1.0F, 0.1F, 1.35F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -2.0F, -0.5F, 1.0F, 0.1F, 1.35F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -2.0F, -0.1F, 1.0F, 0.4F, 1.45F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r2 = group.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.05F, 0.3F, 1.0F, 0.2F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2F, -2.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r3 = group.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.63F, 0.2F, 1.0F, 0.5F, 1.8F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2F, -1.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r4 = bb_main.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.71F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 13.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r5 = bb_main.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.0F, -22.0F, 1.0F, 1.0F, 29.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -5.0F, 9.0F, -0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }
}
