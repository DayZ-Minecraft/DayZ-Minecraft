package com.github.dayzminecraft.dayzminecraft.common.world.genlayer;

import com.github.dayzminecraft.dayzminecraft.common.world.IWorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDayZBorderBiome extends GenLayer {
  private IWorldType worldType;

  public GenLayerDayZBorderBiome(long l, GenLayer genlayer, IWorldType worldType) {
    super(l);
    parent = genlayer;
    this.worldType = worldType;
  }

  @Override
  public int[] getInts(int par1, int par2, int par3, int par4) {
    int ai[] = parent.getInts(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
    int ai1[] = IntCache.getIntCache(par3 * par4);

    for (int i = 0; i < par4; i++) {
      for (int j = 0; j < par3; j++) {
        initChunkSeed(j + par1, i + par2);
        int k = ai[j + 1 + (i + 1) * (par3 + 2)];

        int l = ai[j + 1 + ((i + 1) - 1) * (par3 + 2)];
        int k1 = ai[j + 1 + 1 + (i + 1) * (par3 + 2)];
        int j2 = ai[((j + 1) - 1) + (i + 1) * (par3 + 2)];
        int i3 = ai[j + 1 + (i + 1 + 1) * (par3 + 2)];

        BiomeGenBase biome1 = worldType.setBorderBiomes(BiomeGenBase.getBiomeGenArray()[k], BiomeGenBase.getBiomeGenArray()[l], this);
        BiomeGenBase biome2 = worldType.setBorderBiomes(BiomeGenBase.getBiomeGenArray()[k], BiomeGenBase.getBiomeGenArray()[k1], this);
        BiomeGenBase biome3 = worldType.setBorderBiomes(BiomeGenBase.getBiomeGenArray()[k], BiomeGenBase.getBiomeGenArray()[j2], this);
        BiomeGenBase biome4 = worldType.setBorderBiomes(BiomeGenBase.getBiomeGenArray()[k], BiomeGenBase.getBiomeGenArray()[i3], this);
        if (biome1 != null) {
          ai1[j + i * par3] = biome1.biomeID;
        } else if (biome2 != null) {
          ai1[j + i * par3] = biome2.biomeID;
        } else if (biome3 != null) {
          ai1[j + i * par3] = biome3.biomeID;
        } else if (biome4 != null) {
          ai1[j + i * par3] = biome4.biomeID;
        } else {
          ai1[j + i * par3] = k;
        }
      }
    }

    return ai1;
  }
}
