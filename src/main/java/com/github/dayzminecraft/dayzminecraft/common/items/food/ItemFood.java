package com.github.dayzminecraft.dayzminecraft.common.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;

public class ItemFood extends ItemMod {
  private final int healAmount;
  private final float saturationModifier;
  private final Item returnItem;

  public ItemFood(int itemId, int healAmount, float saturationModifier, Item returnItem) {
    super(itemId);
    this.healAmount = healAmount;
    this.saturationModifier = saturationModifier;
    this.returnItem = returnItem;
  }

  public ItemFood(int itemId, int healAmount, Item returnItem) {
    this(itemId, healAmount, 0.6F, returnItem);
  }

  public ItemFood(int itemId, Item returnItem) {
    this(itemId, 4, 0.6F, returnItem);
  }

  public ItemFood(int itemId) {
    this(itemId, 4, 0.6F, null);
  }

  @Override
  public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    entityPlayer.getFoodStats().addStats(healAmount, saturationModifier);
    world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
    if (returnItem != null) entityPlayer.inventory.addItemStackToInventory(new ItemStack(returnItem));
    return itemStack;
  }

  @Override
  public EnumAction getItemUseAction(ItemStack itemStack) {
    return EnumAction.eat;
  }

  @Override
  public int getMaxItemUseDuration(ItemStack itemStack) {
    return 60;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (entityPlayer.canEat(false)) {
      entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
    }
    return itemStack;
  }
}
