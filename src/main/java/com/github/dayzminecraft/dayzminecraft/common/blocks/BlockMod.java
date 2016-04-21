package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class BlockMod extends Block {

  public BlockMod(Material material) {
    super(material);
    setCreativeTab(DayZ.creativeTab);
  }
}
