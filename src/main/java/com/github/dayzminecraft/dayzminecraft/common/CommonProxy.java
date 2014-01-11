package com.github.dayzminecraft.dayzminecraft.common;

import java.util.logging.Logger;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.event.world.WorldEvent;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.blocks.ModBlocks;
import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityBullet;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityCrawler;
import com.github.dayzminecraft.dayzminecraft.common.entities.EntityZombieDayZ;
import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;
import com.github.dayzminecraft.dayzminecraft.common.misc.ChatHandler;
import com.github.dayzminecraft.dayzminecraft.common.misc.Config;
import com.github.dayzminecraft.dayzminecraft.common.misc.DamageType;
import com.github.dayzminecraft.dayzminecraft.common.misc.LootManager;
import com.github.dayzminecraft.dayzminecraft.common.thirst.PlayerData;
import com.github.dayzminecraft.dayzminecraft.common.world.WorldTypes;
import com.github.dayzminecraft.dayzminecraft.common.world.biomes.Biomes;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.StructureHandler;
import com.github.dayzminecraft.dayzminecraft.common.world.genlayer.GenLayerDayZ;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {
  public void preload(FMLPreInitializationEvent event) {
    ChatHandler.log = Logger.getLogger(DayZ.meta.modId);
    MinecraftForge.EVENT_BUS.register(DayZ.proxy);
    MinecraftForge.TERRAIN_GEN_BUS.register(DayZ.proxy);
    Config.init(event);

    ModBlocks.loadBlocks();
    ModItems.loadItems();
    Biomes.loadBiomes();
    Biomes.addVillages();
    WorldTypes.loadWorldTypes();
    Effect.loadEffects();
    StructureHandler.addDefaultStructures();
    Effect.register();
    EntityRegistry.registerGlobalEntityID(EntityZombieDayZ.class, "Walker", EntityRegistry.findGlobalUniqueEntityId(), 1, 2);
    EntityRegistry.registerGlobalEntityID(EntityCrawler.class, "Crawler", EntityRegistry.findGlobalUniqueEntityId(), 1, 2);

    EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 1, DayZ.INSTANCE, 250, 5, true);

    EntityRegistry.addSpawn(EntityZombieDayZ.class, 200, 1, 4, EnumCreatureType.creature, Biomes.biomeForest, Biomes.biomePlains, Biomes.biomeRiver, Biomes.biomeSnowMountains, Biomes.biomeSnowPlains);
    EntityRegistry.addSpawn(EntityCrawler.class, 100, 1, 4, EnumCreatureType.creature, Biomes.biomeForest, Biomes.biomePlains, Biomes.biomeRiver, Biomes.biomeSnowMountains, Biomes.biomeSnowPlains);

  }

  public void load(FMLInitializationEvent event) {
 }

  public void postload(FMLPostInitializationEvent event) {
    LootManager.init();
  }

  public void serverStarted(FMLServerStartedEvent event) {
    /*MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
    server.logInfo("Day Z " + DayZ.meta.version + " Loaded.");
    if (Config.showWorldTypeWarning && !server.worldServers[0].getWorldInfo().getTerrainType().getWorldTypeName().equals("DAYZBASE") && !server.worldServers[0].getWorldInfo().getTerrainType().getWorldTypeName().equals("DAYZBASE")) {
      server.logInfo("You have not generated a DayZ world! Make sure your server.properties has one of the following lines to generate a DayZ world:");
      server.logInfo("level-type=DAYZBASE - To create the original DayZ world.");
      server.logInfo("level-type=DAYZSNOW - To create snowy DayZ world.");
    } */
  }

  @SubscribeEvent
  public void worldLoad(WorldEvent.Load event) {
    for (Object obj : event.world.field_147482_g) {
      if (obj instanceof TileEntityChest) {
        TileEntityChest chest = (TileEntityChest)obj;
        if (event.world.func_147439_a(chest.field_145851_c, chest.field_145848_d, chest.field_145849_e) == ModBlocks.chestLoot) {
          boolean continueChecking = true;
          int slotNumber = 0;
          while (continueChecking) {
            if (chest.getStackInSlot(slotNumber) == null && slotNumber < 27) {
              if (slotNumber == 26) {
                WeightedRandomChestContent.generateChestContents(event.world.rand, LootManager.loot, chest, event.world.rand.nextInt(5) + 1);
                ChatHandler.logDebug("Refilled chest at " + chest.field_145851_c + ", " + chest.field_145848_d + ", " + chest.field_145849_e + ".");
                continueChecking = false;
              } else {
                slotNumber++;
              }
            } else {
              continueChecking = false;
            }
          }
        }
      }
    }
  }

  @SubscribeEvent
  public void playerInteract(EntityInteractEvent event) {
    if (event.target != null && event.target instanceof EntityPlayer && event.entityPlayer.getCurrentEquippedItem().getItem().equals(ModItems.healBloodbag)) {
      ((EntityPlayer)event.target).heal(20F);
      event.entityPlayer.getCurrentEquippedItem().stackSize--;
    }
  }

  @SubscribeEvent
  public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
    if (event.entityLiving instanceof EntityPlayer && DayZ.isServer()) {
      PlayerData.get((EntityPlayer)event.entityLiving).handleThirst();
    }
    if (event.entityLiving.isPotionActive(Effect.bleeding)) {
      if (event.entityLiving.getActivePotionEffect(Effect.bleeding).getDuration() == 0) {
        event.entityLiving.removePotionEffect(Effect.bleeding.id);
        return;
      }
      if (event.entityLiving.worldObj.rand.nextInt(100) == 0) {
        event.entityLiving.attackEntityFrom(DamageType.bleedOut, 2);
      }
    }
    if (event.entityLiving.isPotionActive(Effect.zombification)) {
      if (event.entityLiving.getActivePotionEffect(Effect.zombification).getDuration() == 0) {
        event.entityLiving.removePotionEffect(Effect.zombification.id);
        return;
      }
      if (event.entityLiving.worldObj.rand.nextInt(100) == 0) {
        if (event.entityLiving.getHealth() > 1.0F) {
          event.entityLiving.attackEntityFrom(DamageType.zombieInfection, 1.0F);
        } else {
          EntityZombieDayZ var2 = new EntityZombieDayZ(event.entityLiving.worldObj);
          var2.setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
          event.entityLiving.worldObj.spawnEntityInWorld(var2);
          event.entityLiving.attackEntityFrom(DamageType.zombieInfection, 1.0F);
        }
      }
    }
  }

  @SubscribeEvent
  public void onEntityConstructing(EntityEvent.EntityConstructing event)
  {
    if (event.entity instanceof EntityPlayer && PlayerData.get((EntityPlayer)event.entity) == null) {
      PlayerData.register((EntityPlayer) event.entity);
    }
    if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlayerData.EXT_PROP_NAME) == null) {
      event.entity.registerExtendedProperties(PlayerData.EXT_PROP_NAME, new PlayerData((EntityPlayer) event.entity));
    }
  }

  @SubscribeEvent
  public void initBiomeGens(WorldTypeEvent.InitBiomeGens event) {
    if (event.worldType instanceof WorldTypes) {
      event.newBiomeGens = GenLayerDayZ.getGenLayers(event.seed, (WorldTypes)event.worldType);
    }
  }

  @SubscribeEvent
  public void populateChunk(PopulateChunkEvent.Populate event) {
    if (event.world.getWorldInfo().getTerrainType() instanceof WorldTypes) {
      if (event.type == PopulateChunkEvent.Populate.EventType.LAKE) {
        event.setResult(Event.Result.DENY);
      }
      if (event.type == PopulateChunkEvent.Populate.EventType.LAVA) {
        event.setResult(Event.Result.DENY);
      }
      if (event.type == PopulateChunkEvent.Populate.EventType.DUNGEON) {
        event.setResult(Event.Result.DENY);
      }
    }

    if (event.world.getWorldInfo().getTerrainType() instanceof WorldTypes && event.world.rand.nextInt(Config.structureGenerationChance) == 0) {
      for (int i = 0; i < 12; ++i) {
        int x = event.chunkX * 16 + event.rand.nextInt(16) + 8;
        int y = event.rand.nextInt(128);
        int z = event.chunkZ * 16 + event.rand.nextInt(16) + 8;

        StructureHandler.generateStructure(event.world, event.rand, x, y, z);
      }
    }
  }
}