package com.github.dayzminecraft.dayzminecraft.common.items.weapons;

import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;
import net.minecraft.item.Item;

public class ItemGlock17 implements IGun {
  @Override
  public int getRounds() {
    return 17;
  }

  @Override
  public int getDamage() {
    return 6;
  }

  @Override
  public String getReloadSound() {
    return "reload";
  }

  @Override
  public String getShootSound() {
    return "glock";
  }

  @Override
  public Item getAmmo() {
    return ModItems.ammoGlock17;
  }
}