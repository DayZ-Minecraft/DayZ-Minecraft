package com.github.dayzminecraft.dayzminecraft.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.client.entities.*;
import com.github.dayzminecraft.dayzminecraft.common.CommonProxy;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityBullet;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityCrawler;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityZombieDayZ;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;

public class ClientProxy extends CommonProxy {
  @Override
  public void preload(FMLPreInitializationEvent event) {
    super.preload(event);
  }

  @Override
  public void load(FMLInitializationEvent event) {
    super.load(event);
    RenderingRegistry.registerEntityRenderingHandler(EntityZombieDayZ.class, new RenderZombieDayZ(new ModelZombieDayZ(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new RenderCrawler(new ModelCrawler(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet(new ModelBullet()));
  }

  @Override
  public void postload(FMLPostInitializationEvent event) {
    super.postload(event);
  }

  @Override
  public void serverStarted(FMLServerStartedEvent event) {
    super.serverStarted(event);
  }

  @ForgeSubscribe
  public void onSoundsLoaded(SoundLoadEvent event) {
    String[] soundFiles = {"ak74", "ak74u", "makarov", "remington", "reload", "leeenfield", "glock", "dbshotgun", "usp"};
    for (String soundFile : soundFiles) {
      event.manager.addSound(DayZ.meta.modId + ":" + soundFile + ".ogg");
    }
  }
}