package com.github.dayzminecraft.dayzminecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;

import com.github.dayzminecraft.dayzminecraft.common.CommonProxy;
import com.github.dayzminecraft.dayzminecraft.common.misc.CreativeTab;
import com.github.dayzminecraft.dayzminecraft.common.thirst.Thirst;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false) @Mod(modid = "DayZ", name = "DayZ Minecraft")
public class DayZ {
  public Thirst thirst;

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
  public void serverStarting(FMLServerStartingEvent event) {
    proxy.serverStarting(event);
  }

  public static Thirst thirst() {
    return INSTANCE.thirst;
  }
}