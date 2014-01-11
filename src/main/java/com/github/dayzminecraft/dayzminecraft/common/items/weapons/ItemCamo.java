package com.github.dayzminecraft.dayzminecraft.common.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;

public class ItemCamo extends ItemArmor {
  private String[] armourTypes = new String[] {"camoHelmet", "camoChest","camoLegs", "camoBoots"};

  public ItemCamo(ArmorMaterial armorMaterial, int renderIndex, int armourType) {
    super(armorMaterial, renderIndex, armourType);
    maxStackSize = 1;
    setCreativeTab(DayZ.creativeTab);
  }

  @Override
  public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String layer) {
    if (itemStack.getItem().equals(ModItems.camoHelmet) || itemStack.getItem().equals(ModItems.camoChest) || itemStack.getItem().equals(ModItems.camoBoots)) {
      return DayZ.meta.modId + ":textures/armor/camo_1.png";
    } else {
      return DayZ.meta.modId + ":textures/armor/camo_2.png";
    }
  }

  @Override
  public void registerIcons(IIconRegister register) {
    itemIcon = register.registerIcon(DayZ.meta.modId + ":" + armourTypes[armorType]);
  }
}