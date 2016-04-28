package com.github.dayzminecraft.dayzminecraft.common.world;

import com.github.dayzminecraft.dayzminecraft.common.world.biomes.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldTypeOriginal extends WorldType implements IWorldType {
  public WorldTypeOriginal() {
    super("dayz-original");
  }

  @Override
  public WorldChunkManager getChunkManager(World world) {
    return new WorldChunkManager(world);
  }

  @Override
  public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
    return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
  }

  @Override
  public BiomeGenBase[] setMajorBiomes() {
    return new BiomeGenBase[]{Biomes.biomeForest};
  }

  @Override
  public BiomeGenBase setMinorBiomes(BiomeGenBase biome, GenLayer genLayer) {
    return Biomes.biomePlains;
  }

  @Override
  public BiomeGenBase setOceanBiomes(BiomeGenBase biome, GenLayer genLayer) {
    return null;
  }

  @Override
  public BiomeGenBase setRiverBiomes(BiomeGenBase biome, GenLayer genLayer) {
    return Biomes.biomeRiver;
  }

  @Override
  public BiomeGenBase setBorderBiomes(BiomeGenBase biome1, BiomeGenBase biome2, GenLayer genLayer) {
    return null;
  }

  @Override
  public BiomeGenBase setMiscellaneousBiomes(GenLayer genLayer) {
    return null;
  }

  @Override
  public int getSpawnFuzz() {
    return 100;
  }
}