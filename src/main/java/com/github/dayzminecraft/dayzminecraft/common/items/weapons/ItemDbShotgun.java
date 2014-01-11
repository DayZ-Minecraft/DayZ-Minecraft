package com.github.dayzminecraft.dayzminecraft.common.items.weapons;

import net.minecraft.item.Item;

import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;

public class ItemDbShotgun implements IGun {
  @Override
  public int getRounds() {
    return 1;
  }

  @Override
  public int getDamage() {
    return 20;
  }

  @Override
  public String getReloadSound() {
    return "reload";
  }

  @Override
  public String getShootSound() {
    return "dbshotgun";
  }

  @Override
  public Item getAmmo() {
    return ModItems.ammoDoubleBarreledShotgun;
  }
}