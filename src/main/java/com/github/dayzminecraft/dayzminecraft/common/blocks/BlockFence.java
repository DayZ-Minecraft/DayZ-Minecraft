package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class BlockFence extends BlockPane {
  public BlockFence(String texture, Material material) {
    super(DayZ.meta.modId + ":" + texture.substring(texture.indexOf(".") + 1), DayZ.meta.modId + ":" + texture.substring(texture.indexOf(".") + 1), material, false);
    func_149647_a(DayZ.creativeTab);
  }
}