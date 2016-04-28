package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

import java.util.Random;

public class BiomeForest extends BiomeGenBase {
  private static final WorldGenTaiga1 worldGenTaiga1 = new WorldGenTaiga1();
  private static final WorldGenTaiga2 worldGenTaiga2 = new WorldGenTaiga2(false);
  private static final WorldGenMegaPineTree worldGenMegaPineTree = new WorldGenMegaPineTree(false, false);
  private static final WorldGenMegaPineTree worldGenMegaPineTree1 = new WorldGenMegaPineTree(false, true);

  public BiomeForest(int id) {
    super(id);
    setColor(747097);
    setBiomeName("Forest");
    temperature = BiomeGenBase.forest.temperature;
    rainfall = BiomeGenBase.forest.rainfall;
    setHeight(height_Default);
    spawnableMonsterList.clear();
    spawnableCreatureList.clear();
    spawnableWaterCreatureList.clear();
    Biomes.addVanillaSpawns(spawnableCreatureList);
    theBiomeDecorator.treesPerChunk = 7;
  }

  @Override
  public void decorate(World worldIn, Random rand, BlockPos pos) {
    double d0 = GRASS_COLOR_NOISE.func_151601_a((double) (pos.getX() + 8) / 200.0D, (double) (pos.getZ() + 8) / 200.0D);

    this.theBiomeDecorator.flowersPerChunk = 4;
    this.theBiomeDecorator.grassPerChunk = 40;
    DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);

    for (int i = 0; i < 7; ++i) {
      int j = rand.nextInt(16) + 8;
      int k = rand.nextInt(16) + 8;
      int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
      DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
    }

    super.decorate(worldIn, rand, pos);
  }

  @Override
  public WorldGenAbstractTree genBigTreeChance(Random rand) {
    return rand.nextInt(3) == 0 ? (rand.nextInt(13) != 0 ? worldGenMegaPineTree : worldGenMegaPineTree1) :
        (rand.nextInt(3) == 0 ? worldGenTaiga1 : worldGenTaiga2);
  }
}
