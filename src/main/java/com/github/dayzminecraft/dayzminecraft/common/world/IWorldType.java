package com.github.dayzminecraft.dayzminecraft.common.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public interface IWorldType {

  /**
   * Returns an array of large, "major" biomes, such as forest, desert, or taiga in the overworld.
   */
  BiomeGenBase[] setMajorBiomes();

  /**
   * Returns a "minor" biome based on conditions of modder's choosing. Examples of such biomes in the overworld include
   * the hilly or mountainous areas within larger biomes such as tundra or jungle, as well as the splotches of forest
   * across the plains.
   */
  BiomeGenBase setMinorBiomes(BiomeGenBase biome, GenLayer genLayer);

  /**
   * Returns a biome generated in the pattern of overworld oceans; note that this does not mean the biome generated is
   * or must be an actual ocean biome.
   *
   * @params See the "setMinorBiomes" method.
   */
  BiomeGenBase setOceanBiomes(BiomeGenBase biome, GenLayer genLayer);

  /**
   * Returns a biome generated in the pattern of overworld rivers; note that this does not mean the biome generated is
   * or must be an actual river biome.
   *
   * @params See the "setMinorBiomes" method.
   */
  BiomeGenBase setRiverBiomes(BiomeGenBase biome, GenLayer genLayer);

  /**
   * Returns a biome generated consistently along the border of two separate biomes.
   */
  BiomeGenBase setBorderBiomes(BiomeGenBase biome1, BiomeGenBase biome2, GenLayer genLayer);

  /**
   * Returns a biome that can be generated anywhere; only the rarity of the biome, not its generation overtop of other
   * biomes, can be defined.
   */
  BiomeGenBase setMiscellaneousBiomes(GenLayer genLayer);
}
