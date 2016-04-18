package com.github.dayzminecraft.dayzminecraft.common.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockBarbedWire extends BlockMod {
  public BlockBarbedWire() {
    super(Material.iron );
  }

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
  }
}