package com.github.dayzminecraft.dayzminecraft.common.world.generation.structures;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface IStructure {
  boolean generate(World world, Random rand, BlockPos pos);
}
