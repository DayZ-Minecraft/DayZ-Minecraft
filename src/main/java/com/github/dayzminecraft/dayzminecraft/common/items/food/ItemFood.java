package com.github.dayzminecraft.dayzminecraft.common.items.food;

import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemFood extends ItemMod {
  private final int healAmount;
  private final float saturationModifier;

  public ItemFood(int healAmount, float saturationModifier) {
    super();
    this.healAmount = healAmount;
    this.saturationModifier = saturationModifier;
    setMaxDamage(1);
  }

  public ItemFood(int healAmount) {
    this(healAmount, 0.6F);
  }

  public ItemFood(Item returnItem) {
    this(4, 0.6F);
  }

  public ItemFood() {
    this(4, 0.6F);
  }

  @Override
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
  {
    --stack.stackSize;
    playerIn.getFoodStats().addStats(healAmount, saturationModifier);
    worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
    playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
    return stack;
  }

  @Override
  public EnumAction getItemUseAction(ItemStack itemStack) {
    return EnumAction.EAT;
  }

  @Override
  public int getMaxItemUseDuration(ItemStack itemStack) {
    return 60;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (entityPlayer.canEat(false) && itemStack.getItemDamage() != itemStack.getMaxDamage()) {
      entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
    }
    return itemStack;
  }

  @Override
  public String getUnlocalizedName(ItemStack itemStack)
  {
    if (itemStack.getItemDamage() == itemStack.getMaxDamage()) {
      return getUnlocalizedName() + "-empty";
    }
    return getUnlocalizedName();
  }
}
