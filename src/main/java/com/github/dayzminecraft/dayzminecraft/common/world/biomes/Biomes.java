package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

public class Biomes {
  public static BiomeGenBase biomeForest;
  public static BiomeGenBase biomePlains;
  public static BiomeGenBase biomeRiver;
  public static BiomeGenBase biomeSnowPlains;
  public static BiomeGenBase biomeSnowMountains;
  private static int biomeForestId;
  private static int biomePlainsId;
  private static int biomeRiverId;
  private static int biomeSnowPlainsId;
  private static int biomeSnowMountainsId;

  public static void loadBiomes() {
    biomeForest = (new BiomeForest(biomeForestId));
    biomePlains = (new BiomePlains(biomePlainsId));
    biomeRiver = (new BiomeRiver(biomeRiverId));
    biomeSnowPlains = (new BiomeSnow(biomeSnowPlainsId, false).setBiomeName("Snow Plains").setEnableSnow());
    biomeSnowMountains = (new BiomeSnow(biomeSnowMountainsId, true).setBiomeName("Snow Mountains").setEnableSnow());
  }

  public static void biomeConfig(Configuration config) {
    biomeForestId = config.get("biome", "biomeForestId", 25).getInt();
    biomePlainsId = config.get("biome", "biomePlainsId", 26).getInt();
    biomeRiverId = config.get("biome", "biomeRiverId", 27).getInt();
    biomeSnowPlainsId = config.get("biome", "biomeSnowPlainsId", 28).getInt();
    biomeSnowMountainsId = config.get("biome", "biomeSnowMountainsId", 29).getInt();
  }

  public static void addVillages() {
    BiomeManager.addVillageBiome(Biomes.biomeForest, true);
    BiomeManager.addVillageBiome(Biomes.biomePlains, true);
    BiomeManager.addVillageBiome(Biomes.biomeRiver, true);
    BiomeManager.addVillageBiome(Biomes.biomeSnowPlains, true);
    BiomeManager.addVillageBiome(Biomes.biomeSnowMountains, true);
  }

  public static void addVanillaSpawns(List<SpawnListEntry> spawnableCreatureList) {
    spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 4, 4, 4));
  }
}
