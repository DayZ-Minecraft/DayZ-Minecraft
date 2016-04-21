package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.material.Material;

public class BlockBarbedWire extends BlockMod {

  private final String name = "";

  public BlockBarbedWire() {
    super(Material.iron );
  }
/*
  @Override
  public void onEntityCollidedWithBlock(World world, int xCoord, int yCoord, int zCoord, Entity entity) {
    entity.attackEntityFrom(DamageSource.generic, 1);
    entity.setInWeb();
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int xCoord, int yCoord, int zCoord) {
    return null;
  }

  @Override
  public int getRenderType() {
    return 6;
  }

  @Override
  public boolean renderAsNormalBlock() {
    return false;
  }

  @Override
  public Item getItemDropped(int metadata, Random rand, int fortune) {
    return Item.getItemFromBlock(ModBlocks.barbedWire);
  }*/
}