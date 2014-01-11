package com.github.dayzminecraft.dayzminecraft.client.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityCrawler;

public class RenderCrawler extends RenderLiving {
  public RenderCrawler(ModelBase par1ModelBase, float shadowSize) {
    super(par1ModelBase, shadowSize);
  }

  public void renderCrawler(EntityCrawler entityCrawler, double x, double y, double z, float yaw, float partialTickTime) {
    super.doRender(entityCrawler, x, y, z, yaw, partialTickTime);
  }

  @Override
  public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
    renderCrawler((EntityCrawler)entity, x, y, z, yaw, partialTickTime);
  }

  @Override
  protected ResourceLocation getEntityTexture(Entity entity) {
    return new ResourceLocation(DayZ.meta.modId + ":textures/entities/crawler.png");
  }
}
