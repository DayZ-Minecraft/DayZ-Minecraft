package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class BlockMod extends Block {
  public BlockMod(Material material) {
    super(material);
    func_149647_a(DayZ.creativeTab);
  }

  @Override
  public void func_149651_a(IIconRegister register) {
    field_149761_L = register.registerIcon(DayZ.meta.modId + ":" + func_149739_a().substring(func_149739_a ().indexOf(".") + 1));
  }
}
