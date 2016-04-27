package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class BiomePlains extends BiomeGenBase {
  @SuppressWarnings("unchecked")
  public BiomePlains(int id) {
    super(id);
    setColor(747097);
    setBiomeName("Plains");
    temperature = BiomeGenBase.forest.temperature;
    rainfall = BiomeGenBase.forest.rainfall;
    setHeight(height_LowPlains);
    spawnableMonsterList.clear();
    spawnableCreatureList.clear();
    Biomes.addVanillaSpawns(spawnableCreatureList);
    theBiomeDecorator.treesPerChunk = -999;
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
}
