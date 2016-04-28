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

  public static void loadBiomes() {
    biomeForest = (new BiomeForest(25));
    biomePlains = (new BiomePlains(26));
    biomeRiver = (new BiomeRiver(27));
    biomeSnowPlains = (new BiomeSnow(28, false).setBiomeName("Snow Plains").setEnableSnow());
    biomeSnowMountains = (new BiomeSnow(29, true).setBiomeName("Snow Mountains").setEnableSnow());
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
