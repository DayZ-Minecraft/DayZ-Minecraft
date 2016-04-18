package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
  public static Block barbedWire;
  public static Block chestLoot;
  public static Block chainFence;
  public static Block sandbagBlock;
  public static Block nailBlock;

  public static void loadBlocks() {
    barbedWire = new BlockBarbedWire().setBlockName("barbedWire").setHardness(3F).setResistance(2F);
    GameRegistry.registerBlock(barbedWire, "barbedWire");
    chestLoot = new BlockChestDayZ(0).setBlockName("chestLoot");
    GameRegistry.registerBlock(chestLoot, "chestLoot");
    chainFence = new BlockFence("chainFence", Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("chainFence");
    GameRegistry.registerBlock(chainFence, "chainFence");
    sandbagBlock = new BlockMod(Material.clay).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeSand).setBlockName("sandbagBlock");
    GameRegistry.registerBlock(sandbagBlock, "sandbagBlock");
    nailBlock = new BlockNails(Material.circuits).setBlockName("nailBlock").setHardness(1F).setResistance(1F);
    GameRegistry.registerBlock(nailBlock, "nailBlock");
    GameRegistry.addRecipe(new ItemStack(nailBlock, 8), "#", "#", '#', Items.iron_ingot);
  }
}