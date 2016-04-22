package com.github.dayzminecraft.dayzminecraft.common.world.generation.structures;

import com.github.dayzminecraft.dayzminecraft.common.blocks.ModBlocks;
import com.github.dayzminecraft.dayzminecraft.common.misc.ChatHandler;
import com.github.dayzminecraft.dayzminecraft.common.misc.LootManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

import java.util.Random;

public abstract class Structure {
  abstract public boolean generate(World world, Random rand, BlockPos pos);

  public boolean canGenerate(World world, BlockPos pos) {
    //check that each corner is one of the valid spawn blocks
    return world.getBlockState(pos).getBlock() == Blocks.grass||
        world.getBlockState(pos.add(10, 0, 0)).getBlock() == Blocks.grass ||
        world.getBlockState(pos.add(10, 0, 10)).getBlock() == Blocks.grass ||
        world.getBlockState(pos.add(0, 0, 10)).getBlock() == Blocks.grass;
  }

  public static void generateChest(World world, BlockPos chestPos, int lootQuantity) {
    Block chest = ModBlocks.chestLoot;
    world.setBlockState(chestPos, chest.getDefaultState());
    TileEntity tileEntity = world.getTileEntity(chestPos);
    if (tileEntity != null) {
      WeightedRandomChestContent.generateChestContents(world.rand, LootManager.loot, (TileEntityChest) tileEntity, world.rand.nextInt(lootQuantity) + 1);
    }
    ChatHandler.logDebug("Day Z House Chest Created At " + chestPos.toString());
  }
}
