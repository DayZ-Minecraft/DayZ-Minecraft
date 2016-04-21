package com.github.dayzminecraft.dayzminecraft.client.entities;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityCrawler;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrawler extends RenderLiving<EntityCrawler> {

  public RenderCrawler(RenderManager manager) {
    super(manager, new ModelCrawler(), 0.5F);
  }

  public void doRender(EntityCrawler entity, double x, double y, double z, float entityYaw, float partialTicks) {
    super.doRender(entity, x, y, z, entityYaw, partialTicks);
  }

  @Override
  protected ResourceLocation getEntityTexture(EntityCrawler entity) {
    return new ResourceLocation(DayZ.meta.modId + ":textures/entities/crawler.png");
  }
}
