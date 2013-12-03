package com.github.dayzminecraft.dayzminecraft.common.world.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.IStructure;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.StructureFort;
import com.github.dayzminecraft.dayzminecraft.common.world.generation.structures.StructureHouse;

public class StructureHandler {
  private static List<IStructure> structures = new ArrayList<>();

  public static boolean generateStructure(World world, Random rand, int xCoord, int yCoord, int zCoord) {
    return structures.get(rand.nextInt(structures.size())).generate(world, rand, xCoord, yCoord, zCoord);
  }

  public static void addStructure(IStructure structure) {
    structures.add(structure);
  }

  public static void addDefaultStructures() {
    addStructure(new StructureFort());
    addStructure(new StructureHouse());
  }
}
