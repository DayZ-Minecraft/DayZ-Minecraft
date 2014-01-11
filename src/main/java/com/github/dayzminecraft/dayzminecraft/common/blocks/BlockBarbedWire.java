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
    super(Material.field_151573_f );
  }

  @Override
  public void func_149670_a(World world, int xCoord, int yCoord, int zCoord, Entity entity) {
    entity.attackEntityFrom(DamageSource.generic, 1);
    entity.setInWeb();
  }

  @Override
  public boolean func_149662_c() {
    return false;
  }

  @Override
  public AxisAlignedBB func_149668_a(World world, int xCoord, int yCoord, int zCoord) {
    return null;
  }

  @Override
  public int func_149645_b() {
    return 6;
  }

  @Override
  public boolean func_149686_d() {
    return false;
  }

  @Override
  public Item func_149650_a(int metadata, Random rand, int fortune) {
    return Item.func_150898_a(ModBlocks.barbedWire);
  }
}