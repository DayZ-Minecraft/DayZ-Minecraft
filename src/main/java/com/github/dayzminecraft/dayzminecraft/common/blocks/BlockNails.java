package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockNails extends BlockMod {
  public BlockNails(Material material) {
    super(material);
  }

  @Override
  public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity) {
    entity.attackEntityFrom(DamageSource.generic, 6);
    world.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "random.break", 0.3F, 0.6F);
    world.setBlockToAir(pos);
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public int getRenderType() {
    return 6;
  }
}
