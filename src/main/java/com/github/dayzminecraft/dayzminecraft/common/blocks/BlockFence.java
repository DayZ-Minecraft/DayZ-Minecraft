package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class BlockFence extends BlockPane {
  public BlockFence(int blockId, String texture, Material material) {
    super(blockId, DayZ.meta.modId + ":" + texture.substring(texture.indexOf(".") + 1), DayZ.meta.modId + ":" + texture.substring(texture.indexOf(".") + 1), material, false);
    setCreativeTab(DayZ.creativeTab);
  }
}