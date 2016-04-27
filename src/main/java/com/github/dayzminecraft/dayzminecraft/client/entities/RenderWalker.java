package com.github.dayzminecraft.dayzminecraft.client.entities;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityWalker;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWalker extends RenderBiped<EntityWalker> {

  public RenderWalker(RenderManager manager) {
    super(manager, new ModelWalker(), 0.5F, 1.0F);
  }

  @Override
  public void doRender(EntityWalker entity, double x, double y, double z, float entityYaw, float partialTicks) {
    super.doRender(entity, x, y, z, entityYaw, partialTicks);
  }

  @Override
  protected ResourceLocation getEntityTexture(EntityWalker entity) {
    return new ResourceLocation(DayZ.meta.modId + ":textures/entities/" + entity.texture);
  }
}
