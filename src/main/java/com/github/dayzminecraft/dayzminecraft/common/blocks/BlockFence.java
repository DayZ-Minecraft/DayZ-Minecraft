package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class BlockFence extends BlockPane {
  public BlockFence() {
    super(Material.iron, true);
    setCreativeTab(DayZ.creativeTab);
  }
}