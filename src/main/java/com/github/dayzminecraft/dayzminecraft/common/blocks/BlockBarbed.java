package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockBarbed extends Block {

  public BlockBarbed() {
    super(Material.iron);
  }

  /**
   * Used to determine ambient occlusion and culling when rebuilding chunks for render
   */
  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  /**
   * Called When an Entity Collided with the Block
   */
  @Override
  public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
  {
    entity.attackEntityFrom(DamageSource.generic, 1);
    entity.setInWeb();
  }

  @Override
  public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
  {
    return null;
  }

  @Override
  public boolean isFullCube()
  {
    return false;
  }

  /**
   * Get the Item that this Block should drop when harvested.
   */
  public Item getItemDropped(IBlockState state, Random rand, int fortune)
  {
    return Item.getItemFromBlock(ModBlocks.nailBlock);
  }

  @SideOnly(Side.CLIENT)
  public EnumWorldBlockLayer getBlockLayer()
  {
    return EnumWorldBlockLayer.CUTOUT;
  }
}
