package com.github.dayzminecraft.dayzminecraft.common.items.misc;

import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemFirestarter extends ItemMod {
  public ItemFirestarter(int numOfUses) {
    super();
    setMaxDamage(numOfUses);
  }

  @Override
  public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
    pos = pos.offset(side);

    if (!playerIn.canPlayerEdit(pos, side, stack)) {
      return false;
    } else {
      if (worldIn.isAirBlock(pos)) {
        worldIn.playSoundEffect((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
      }

      stack.damageItem(1, playerIn);
      return true;
    }
  }
}
