package com.github.dayzminecraft.dayzminecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;

import com.github.dayzminecraft.dayzminecraft.common.CommonProxy;
import com.github.dayzminecraft.dayzminecraft.common.misc.CreativeTab;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false) @Mod(modid = "DayZ", name = "DayZ Minecraft")
public class DayZ {
  public static EnumArmorMaterial enumArmorMaterialCamo = EnumHelper.addArmorMaterial("camo", 29, new int[] {2, 6, 5, 2}, 9);

  public static CreativeTabs creativeTab = new CreativeTab();

  @Instance("DayZ")
  public static DayZ INSTANCE;

  @Metadata
  public static ModMetadata meta;

  @SidedProxy(modId = "DayZ", clientSide = "com.github.dayzminecraft.dayzminecraft.client.ClientProxy", serverSide = "com.github.dayzminecraft.dayzminecraft.common.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preload(FMLPreInitializationEvent event) {
    proxy.preload(event);
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.load(event);
  }

  @EventHandler
  public void postload(FMLPostInitializationEvent event) {
    proxy.postload(event);
  }

  @EventHandler
  public void serverStarted(FMLServerStartedEvent event) {
    proxy.serverStarted(event);
  }

  public static boolean isServer() {
    return FMLCommonHandler.instance().getEffectiveSide().isServer();
  }

  public static boolean isClient() {
    return FMLCommonHandler.instance().getEffectiveSide().isClient();
  }
}