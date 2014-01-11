package com.github.dayzminecraft.dayzminecraft.common.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.github.dayzminecraft.dayzminecraft.DayZ;

public class ItemMod extends Item {
  public List<String> subNames;

  public ItemMod() {
    super();
    maxStackSize = 1;
    setCreativeTab(DayZ.creativeTab);
  }

  @Override
  public void registerIcons(IIconRegister register) {
    itemIcon = register.registerIcon(DayZ.meta.modId + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
  }

  @Override
  public IIcon getIcon(ItemStack stack, int pass) {
    return itemIcon;
  }

  @SuppressWarnings({"unchecked", "rawtypes"}) @Override
  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List informationList, boolean advancedItemTooltips) {
    if (subNames == null) {
      return;
    }
    for (String string : subNames) {
      informationList.add(string);
    }
  }

  public Item subNames(String... strings) {
    if (subNames == null) {
      subNames = new ArrayList<String>();
    }
    Collections.addAll(subNames, strings);
    return this;
  }
}
