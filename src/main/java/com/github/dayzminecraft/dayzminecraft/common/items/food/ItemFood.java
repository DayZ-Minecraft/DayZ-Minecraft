package com.github.dayzminecraft.dayzminecraft.common.items.food;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;

public class ItemFood extends ItemMod {
  private final int healAmount;
  private final float saturationModifier;
  private Icon emptyCanIcon;

  public ItemFood(int itemId, int healAmount, float saturationModifier) {
    super(itemId);
    this.healAmount = healAmount;
    this.saturationModifier = saturationModifier;
    setMaxDamage(1);
  }

  public ItemFood(int itemId, int healAmount) {
    this(itemId, healAmount, 0.6F);
  }

  public ItemFood(int itemId, Item returnItem) {
    this(itemId, 4, 0.6F);
  }

  public ItemFood(int itemId) {
    this(itemId, 4, 0.6F);
  }

  @Override
  public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    entityPlayer.getFoodStats().addStats(healAmount, saturationModifier);
    world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
    itemStack.damageItem(1, entityPlayer);
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
    if (entityPlayer.canEat(false) && itemStack.getItemDamage() != itemStack.getMaxDamage()) {
      entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
    }
    return itemStack;
  }

  @Override
  public Icon getIconFromDamage(int damage) {
    if (damage == 0) return this.itemIcon;
    else return emptyCanIcon;
  }

  @Override
  public void registerIcons(IconRegister register) {
    itemIcon = register.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
    emptyCanIcon = register.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1) + "-empty");
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
