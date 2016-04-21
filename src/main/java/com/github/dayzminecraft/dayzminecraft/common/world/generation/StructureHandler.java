package com.github.dayzminecraft.dayzminecraft.common.world.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.IStructure;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.StructureFort;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.StructureHouse;

public class StructureHandler {
  private static List<IStructure> structures = new ArrayList<IStructure>();

  public static boolean generateStructure(World world, Random rand, BlockPos pos) {
    return structures.get(rand.nextInt(structures.size())).generate(world, rand, pos);
  }

  public static void addStructure(IStructure structure) {
    structures.add(structure);
  }

  public static void addDefaultStructures() {
    addStructure(new StructureFort());
    addStructure(new StructureHouse());
  }
}
