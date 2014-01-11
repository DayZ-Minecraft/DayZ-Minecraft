package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeForest extends BiomeGenBase {
  private static final WorldGenTaiga1 taiga1 = new WorldGenTaiga1();
  private static final WorldGenTaiga2 taiga2 = new WorldGenTaiga2(false);

  @SuppressWarnings("unchecked")
  public BiomeForest(int id) {
    super(id);
    setColor(747097);
    setBiomeName("Forest");
    temperature = BiomeGenBase.forest.temperature;
    rainfall = BiomeGenBase.forest.rainfall;
    minHeight = 0.1F;
    maxHeight = 0.2F;
    spawnableMonsterList.clear();
    spawnableCreatureList.clear();
    spawnableWaterCreatureList.clear();
    Biomes.addVanillaSpawns(spawnableCreatureList);
    theBiomeDecorator.treesPerChunk = 7;
    theBiomeDecorator.flowersPerChunk = 4;
    theBiomeDecorator.grassPerChunk = 10;
    theBiomeDecorator.deadBushPerChunk = 4;
  }

  @Override
  public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
    return (p_150567_1_.nextInt(3) == 0 ? taiga1 : taiga2);
  }

}
