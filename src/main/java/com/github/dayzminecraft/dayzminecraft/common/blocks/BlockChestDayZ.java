package com.github.dayzminecraft.dayzminecraft.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.misc.LootManager;

public class BlockChestDayZ extends BlockChest {
  public BlockChestDayZ(int isTrapped) {
    super(isTrapped);
    setBlockUnbreakable();
    setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    setCreativeTab(DayZ.creativeTab);
    setTickRandomly(true);
  }

  public void updateTick(World world, int x, int y, int z, Random random) {/*
    if (world.getClosestPlayer(x, y, z, 32) == null) {
      TileEntity tileEntity = world.getTileEntity(x, y, z);
      if (tileEntity != null && (isEmpty((TileEntityChest)tileEntity))) {
        WeightedRandomChestContent.generateChestContents(random, LootManager.loot, (TileEntityChest)tileEntity, random.nextInt(5) + 1);
      }
    }*/
  }

  private boolean isEmpty(TileEntityChest tileEntityChest) {
    for (int slot = 0; slot < 27; slot++) {
      if (tileEntityChest.getStackInSlot(slot) != null) {
        return false;
      }
    }
    return true;
  }
}