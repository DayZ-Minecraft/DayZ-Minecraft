package com.github.dayzminecraft.dayzminecraft;

import com.github.dayzminecraft.dayzminecraft.common.CommonProxy;
import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;
import com.github.dayzminecraft.dayzminecraft.common.world.WorldTypeOriginal;
import com.github.dayzminecraft.dayzminecraft.common.world.WorldTypeSnow;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

@Mod(modid = "DayZ", name = "DayZ Minecraft")
public class DayZ {

  public static WorldType worldTypeOriginal = new WorldTypeOriginal();
  public static WorldType worldTypeSnow = new WorldTypeSnow();
  //TODO public static ArmorMaterial enumArmorMaterialCamo = EnumHelper.addArmorMaterial("camo", 29, new int[] {2, 6, 5, 2}, 9);

  public static CreativeTabs creativeTab = new CreativeTabs("creativeTabDayZ") {
    @Override
    public Item getTabIconItem() {
      return ModItems.gunAk74u;
    }
  };

  @Mod.Instance("DayZ")
  public static DayZ INSTANCE;

  @Mod.Metadata
  public static ModMetadata meta;

  @SidedProxy(clientSide = "com.github.dayzminecraft.dayzminecraft.client.ClientProxy", serverSide = "com.github.dayzminecraft.dayzminecraft.common.CommonProxy")
  public static CommonProxy proxy;

  public static boolean isServer() {
    return FMLCommonHandler.instance().getEffectiveSide().isServer();
  }

  public static boolean isClient() {
    return FMLCommonHandler.instance().getEffectiveSide().isClient();
  }

  @Mod.EventHandler
  public void preload(FMLPreInitializationEvent event) {
    proxy.preload(event);
  }

  @Mod.EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.load(event);
  }

  @Mod.EventHandler
  public void postload(FMLPostInitializationEvent event) {
    proxy.postload(event);
  }

  @Mod.EventHandler
  public void serverStarted(FMLServerStartedEvent event) {
    proxy.serverStarted(event);
  }
}