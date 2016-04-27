package com.github.dayzminecraft.dayzminecraft.common.items.weapons;

import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;
import net.minecraft.item.Item;

public class ItemAk74u implements IGun {
  @Override
  public int getRounds() {
    return 30;
  }

  @Override
  public int getDamage() {
    return 10;
  }

  @Override
  public String getReloadSound() {
    return "reload";
  }

  @Override
  public String getShootSound() {
    return "ak74u";
  }

  @Override
  public Item getAmmo() {
    return ModItems.ammoAk74u;
  }
}