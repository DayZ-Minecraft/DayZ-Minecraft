package com.github.dayzminecraft.dayzminecraft.client;

import com.github.dayzminecraft.dayzminecraft.client.entities.RenderBullet;
import com.github.dayzminecraft.dayzminecraft.client.entities.RenderCrawler;
import com.github.dayzminecraft.dayzminecraft.client.entities.RenderWalker;
import com.github.dayzminecraft.dayzminecraft.common.CommonProxy;
import com.github.dayzminecraft.dayzminecraft.common.blocks.ModBlocks;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityBullet;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityCrawler;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityWalker;
import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

public class ClientProxy extends CommonProxy {

  @Override
  public void preload(FMLPreInitializationEvent event) {
    super.preload(event);
    RenderingRegistry.registerEntityRenderingHandler(EntityWalker.class, new IRenderFactory<EntityWalker>() {
      @Override
      public Render<? super EntityWalker> createRenderFor(RenderManager manager) {
        return new RenderWalker(manager);
      }
    });
    RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new IRenderFactory<EntityCrawler>() {
      @Override
      public Render<? super EntityCrawler> createRenderFor(RenderManager manager) {
        return new RenderCrawler(manager);
      }
    });
    RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new IRenderFactory<EntityBullet>() {
      @Override
      public Render<? super EntityBullet> createRenderFor(RenderManager manager) {
        return new RenderBullet(manager);
      }
    });
  }

  @Override
  public void load(FMLInitializationEvent event) {
    super.load(event);
    ModItems.registerClient(Minecraft.getMinecraft().getRenderItem());
    ModBlocks.registerClient(Minecraft.getMinecraft().getRenderItem());
  }

  @Override
  public void postload(FMLPostInitializationEvent event) {
    super.postload(event);
  }

  @Override
  public void serverStarted(FMLServerStartedEvent event) {
    super.serverStarted(event);
  }
}