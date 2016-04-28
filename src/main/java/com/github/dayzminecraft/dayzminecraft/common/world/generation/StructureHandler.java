package com.github.dayzminecraft.dayzminecraft.common.world.generation;

import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.Structure;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.StructureFort;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.StructureHouse;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StructureHandler {
  private static List<Structure> structures = new ArrayList<Structure>();

  public static boolean generateStructure(World world, Random rand, BlockPos pos) {
    Structure structure = structures.get(rand.nextInt(structures.size()));
    return structure.canGenerate(world, pos) && structure.generate(world, rand, pos.down());
  }

  public static void addStructure(Structure structure) {
    structures.add(structure);
  }

  public static void addDefaultStructures() {
    addStructure(new StructureFort());
    addStructure(new StructureHouse());
  }
}
