package com.github.dayzminecraft.dayzminecraft.common.items.misc;

import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemHeal extends ItemMod {
  private int healAmount;
  private Potion[] potionsToStop;

  public ItemHeal(int amountToHeal, Potion... potionsToStop) {
    super();
    healAmount = amountToHeal;
    this.potionsToStop = potionsToStop;
  }

  public int getHealAmount() {
    return healAmount;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    itemStack.stackSize--;
    entityPlayer.heal(healAmount);
    entityPlayer.clearActivePotions();
    return itemStack;
  }
}
