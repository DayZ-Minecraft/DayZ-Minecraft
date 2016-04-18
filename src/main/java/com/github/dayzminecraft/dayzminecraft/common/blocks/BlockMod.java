package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class BlockMod extends Block {
  public BlockMod(Material material) {
    super(material);
    setCreativeTab(DayZ.creativeTab);
  }

  @Override
  public void registerBlockIcons(IIconRegister register) {
    blockIcon = register.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
  }
}
