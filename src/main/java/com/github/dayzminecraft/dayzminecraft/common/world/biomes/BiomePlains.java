package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomePlains extends BiomeGenBase {
  @SuppressWarnings("unchecked")
  public BiomePlains(int id) {
    super(id);
    setColor(747097);
    setBiomeName("Plains");
    temperature = BiomeGenBase.forest.temperature;
    rainfall = BiomeGenBase.forest.rainfall;
    setHeight(new Height(0.1F, 0.1F));
    spawnableMonsterList.clear();
    spawnableCreatureList.clear();
    spawnableWaterCreatureList.clear();
    Biomes.addVanillaSpawns(spawnableCreatureList);
    theBiomeDecorator.flowersPerChunk = 4;
    theBiomeDecorator.deadBushPerChunk = 4;
    theBiomeDecorator.treesPerChunk = -999;
    theBiomeDecorator.grassPerChunk = 20;

  }
}
