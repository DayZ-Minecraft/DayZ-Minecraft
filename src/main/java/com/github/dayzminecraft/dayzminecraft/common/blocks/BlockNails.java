package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockNails extends BlockMod {
  public BlockNails(Material material) {
    super(material);
  }

  @Override
  public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord, int zCoord, Entity entity) {
    entity.attackEntityFrom(DamageSource.generic, 6);
    world.playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, "random.break", 0.3F, 0.6F);
    world.setBlockToAir(xCoord, yCoord, zCoord);
  }

  @Override
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int xCoord, int yCoord, int zCoord) {
    return null;
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public boolean renderAsNormalBlock() {
    return false;
  }

  @Override
  public int getRenderType() {
    return 6;
  }
}
