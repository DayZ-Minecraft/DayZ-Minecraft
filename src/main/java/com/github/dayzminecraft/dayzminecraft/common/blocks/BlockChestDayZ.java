package com.github.dayzminecraft.dayzminecraft.common.blocks;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.misc.LootManager;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

import java.util.Random;

public class BlockChestDayZ extends BlockChest {
  public BlockChestDayZ() {
    super(0);
    setBlockUnbreakable();
    setCreativeTab(DayZ.creativeTab);
    setTickRandomly(true);
    setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
  }

  @Override
  public void randomTick(World world, BlockPos pos, IBlockState state, Random random) {
    if (world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 32) == null) {
      TileEntity tileEntity = world.getTileEntity(pos);
      if (tileEntity != null && (isEmpty((TileEntityChest) tileEntity))) {
        WeightedRandomChestContent.generateChestContents(random, LootManager.loot, (TileEntityChest) tileEntity, random.nextInt(5) + 1);
      }
    }
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