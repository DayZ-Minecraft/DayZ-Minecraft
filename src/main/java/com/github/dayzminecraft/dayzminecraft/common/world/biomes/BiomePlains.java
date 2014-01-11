package com.github.dayzminecraft.dayzminecraft.common.world.biomes;

import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomePlains extends BiomeGenBase {
  @SuppressWarnings("unchecked")
  public BiomePlains(int id) {
    super(id);
    setColor(747097);
    setBiomeName("Plains");
    temperature = BiomeGenBase.forest.temperature;
    rainfall = BiomeGenBase.forest.rainfall;
    minHeight = 0.1F;
    maxHeight = 0.1F;
    spawnableMonsterList.clear();
    spawnableCreatureList.clear();
    spawnableWaterCreatureList.clear();
    spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 4, 4, 4));
    spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 4, 4, 4));
    theBiomeDecorator.flowersPerChunk = 4;
    theBiomeDecorator.deadBushPerChunk = 4;
    theBiomeDecorator.treesPerChunk = -999;
    theBiomeDecorator.grassPerChunk = 20;

  }
}
