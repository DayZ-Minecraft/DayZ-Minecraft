package com.github.dayzminecraft.dayzminecraft.common.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.github.dayzminecraft.dayzminecraft.common.items.Items;

public class CreativeTab extends CreativeTabs {
  public CreativeTab() {
    super("creativeTabDayZ");
  }

  @Override
  public ItemStack getIconItemStack() {
    return new ItemStack(Items.gunAk74u, 1, 0);
  }
}