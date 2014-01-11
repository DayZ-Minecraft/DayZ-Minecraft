package com.github.dayzminecraft.dayzminecraft.common.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.layer.GenLayer;

import com.github.dayzminecraft.dayzminecraft.common.world.biomes.Biomes;

public class WorldTypes extends WorldType {
  public static WorldType DAYZ;
  public static WorldType SNOW;

  public WorldTypes(String name) {
    super(name);
  }

  public static void loadWorldTypes() {
    DAYZ = new WorldTypes("DAYZBASE");
    SNOW = new WorldTypes("DAYZSNOW");
  }

  @Override
  public WorldChunkManager getChunkManager(World world) {
    return new WorldChunkManager(world);
  }

  @Override
  public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
    return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
  }

  /** Returns an array of large, "major" biomes, such as forest, desert, or taiga in the overworld. */
  public BiomeGenBase[] setMajorBiomes() {
    if (this == DAYZ) {
      return new BiomeGenBase[] {Biomes.biomeForest};
    } else if (this == SNOW) {
      return new BiomeGenBase[] {Biomes.biomeSnowPlains};
    }
    return null;
  }

  /**
   * Returns a "minor" biome based on conditions of modder's choosing. Examples of such biomes in the overworld include
   * the hilly or mountainous areas within larger biomes such as tundra or jungle, as well as the splotches of forest
   * across the plains.
   */
  @SuppressWarnings("unused")
  public BiomeGenBase setMinorBiomes(BiomeGenBase biome, GenLayer genLayer) {
    if (this == DAYZ) {
      return Biomes.biomePlains;
    } else if (this == SNOW) {
      return Biomes.biomeSnowMountains;
    }
    return null;
  }

  /**
   * Returns a biome generated in the pattern of overworld oceans; note that this does not mean the biome generated is
   * or must be an actual ocean biome.
   *
   * @params See the "setMinorBiomes" method.
   */
  @SuppressWarnings("unused")
  public BiomeGenBase setOceanBiomes(BiomeGenBase biome, GenLayer genLayer) {
    return null;
  }

  /**
   * Returns a biome generated in the pattern of overworld rivers; note that this does not mean the biome generated is
   * or must be an actual river biome.
   *
   * @params See the "setMinorBiomes" method.
   */
  @SuppressWarnings("unused")
  public BiomeGenBase setRiverBiomes(BiomeGenBase biome, GenLayer genLayer) {
    if (this == DAYZ) {
      return Biomes.biomeRiver;
    } else if (this == SNOW) {
      return Biomes.biomeRiver;
    }
    return null;
  }

  /** Returns a biome generated consistently along the border of two separate biomes. */
  @SuppressWarnings("unused")
  public BiomeGenBase setBorderBiomes(BiomeGenBase biome1, BiomeGenBase biome2, GenLayer genLayer) {
    return null;
  }

  /**
   * Returns a biome that can be generated anywhere; only the rarity of the biome, not its generation overtop of other
   * biomes, can be defined.
   */
  @SuppressWarnings("unused")
  public BiomeGenBase setMiscellaneousBiomes(GenLayer genLayer) {
    return null;
  }

  @Override
  public int getSpawnFuzz() {
    return 100;
  }
}