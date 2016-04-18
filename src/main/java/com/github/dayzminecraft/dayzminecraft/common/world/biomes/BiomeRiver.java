package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import net.minecraft.world.biome.BiomeGenRiver;

public class BiomeRiver extends BiomeGenRiver {
  public BiomeRiver(int id) {
    super(id);
    setColor(747097);
    setBiomeName("DayZ River");
    spawnableMonsterList.clear();
    spawnableCreatureList.clear();
    setHeight(new Height(-0.5F, 0.0F));
    theBiomeDecorator.treesPerChunk = -999;
    theBiomeDecorator.flowersPerChunk = 0;
    theBiomeDecorator.grassPerChunk = 15;
    theBiomeDecorator.deadBushPerChunk = 0;
  }
}
