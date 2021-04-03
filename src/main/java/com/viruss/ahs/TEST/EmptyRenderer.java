package com.viruss.ahs.TEST;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viruss.ahs.player.PlayerPartEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class EmptyRenderer extends EntityRenderer<Entity> {

    public EmptyRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(PlayerPartEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}
