package com.github.dayzminecraft.dayzminecraft.client.entities;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityBullet;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;


@SideOnly(Side.CLIENT)
public class RenderBullet extends Render<EntityBullet> {

  public RenderBullet(RenderManager manager) {
    super(manager);
  }

  @Override
  protected ResourceLocation getEntityTexture(EntityBullet entity) {
    return new ResourceLocation(DayZ.meta.modId + ":textures/entities/bullet.png");
  }

  @Override
  public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks)
  {
    GL11.glPushMatrix();
    GL11.glDisable(GL11.GL_CULL_FACE);
    GL11.glTranslatef((float)x, (float)y, (float)z);
    float f2 = 0.0625F;
    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    GL11.glScalef(-1.0F, -1.0F, 1.0F);
    GL11.glEnable(GL11.GL_ALPHA_TEST);
    bindEntityTexture(entity);
    new ModelCrawler().render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f2);
    GL11.glPopMatrix();
  }
}
