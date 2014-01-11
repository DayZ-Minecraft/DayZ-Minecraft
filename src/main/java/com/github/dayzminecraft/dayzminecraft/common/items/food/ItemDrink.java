package com.github.dayzminecraft.dayzminecraft.common.items.food;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;
import com.github.dayzminecraft.dayzminecraft.common.thirst.PlayerData;

public class ItemDrink extends ItemMod {
  private final int healAmount;
  private final boolean isAlcohol;
  private IIcon emptyCanIcon;

  public ItemDrink(int healAmount, boolean isAlcohol) {
    super();
    this.healAmount = healAmount;
    this.isAlcohol = isAlcohol;
    setMaxDamage(1);
  }

  public ItemDrink(int healAmount) {
    this(healAmount, false);
  }

  public ItemDrink() {
    this(4000, false);
  }

  @Override
  public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    PlayerData.get(entityPlayer).drink(healAmount);
    if (isAlcohol) {
      entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 1));
    }
    world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
    itemStack.damageItem(1, entityPlayer);
    return itemStack;
  }

  @Override
  public EnumAction getItemUseAction(ItemStack itemStack) {
    return EnumAction.drink;
  }

  @Override
  public int getMaxItemUseDuration(ItemStack itemStack) {
    return 32;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (itemStack.getItemDamage() != itemStack.getMaxDamage()) {
      entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
    }
    return itemStack;
  }

  @Override
  public IIcon getIconFromDamage(int damage) {
    if (damage != getMaxDamage()) return this.itemIcon;
    else return emptyCanIcon;
  }

  @Override
  public void registerIcons(IIconRegister register) {
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
