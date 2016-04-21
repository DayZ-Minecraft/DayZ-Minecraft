package com.github.dayzminecraft.dayzminecraft.common.items.weapons;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMelee extends ItemMod {
  private float weaponDamage;

  public ItemMelee(float damage) {
    super();
    maxStackSize = 1;
    setMaxDamage(32);
    weaponDamage = damage;
  }

  @Override
  public boolean hitEntity(ItemStack itemStack, EntityLivingBase attackedEntity, EntityLivingBase attackerEntity) {
    attackedEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attackerEntity), weaponDamage);
    itemStack.damageItem(1, attackerEntity);
    return true;
  }

  @SideOnly(Side.CLIENT) @Override
  public boolean isFull3D() {
    return true;
  }

  @Override
  public EnumAction getItemUseAction(ItemStack itemStack) {
    return EnumAction.BLOCK;
  }

  @Override
  public int getMaxItemUseDuration(ItemStack itemStack) {
    return 72000;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
    return itemStack;
  }

  @Override
  public boolean getIsRepairable(ItemStack anvilSlot1, ItemStack anvilSlot2) {
    return true;
  }
}
