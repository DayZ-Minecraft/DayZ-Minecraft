package com.github.dayzminecraft.dayzminecraft.common.items;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemMod extends Item {
  public List<String> subNames;
  private String name;

  public ItemMod() {
    super();
    maxStackSize = 1;
    setCreativeTab(DayZ.creativeTab);
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


  public ItemMod subNames(String... strings) {
    if (subNames == null) {
      subNames = new ArrayList<String>();
    }
    Collections.addAll(subNames, strings);
    return this;
  }

  public String getName() {
    return name;
  }

  public ItemMod setName(String name) {
    this.name = name;
    setUnlocalizedName(name);
    return this;
  }
}
