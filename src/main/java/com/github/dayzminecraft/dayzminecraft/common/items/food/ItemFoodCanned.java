package com.github.dayzminecraft.dayzminecraft.common.items.food;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;
import com.github.dayzminecraft.dayzminecraft.common.items.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodCanned extends ItemMod {
  @SideOnly(Side.CLIENT)
  private Icon[] icons;
  private String[] names = new String[] {"Canned_Beans", "Canned_Soup", "Canned_Pasta", "Canned_Fish", "Canned_Pickles", "Canned_Fruit"};

  private float saturationModifier;
  private int healAmount;

  public ItemFoodCanned(int id, int healAmount, float saturationModifier) {
    super(id);
    setHasSubtypes(true);
    this.healAmount = healAmount;
    this.saturationModifier = saturationModifier;
    setHasSubtypes(true);
  }

  @Override
  public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.foodCanEmpty, 1, itemStack.getItemDamage()));
    --itemStack.stackSize;
    entityPlayer.getFoodStats().addStats(healAmount, saturationModifier);
    world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
    onFoodEaten(itemStack, entityPlayer);
    return itemStack;
  }

  protected void onFoodEaten(ItemStack itemStack, EntityPlayer entityPlayer) {
    entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.foodCanEmpty, getDamage(itemStack)));
  }

  @Override
  public int getMaxItemUseDuration(ItemStack itemStack) {
    return 32;
  }

  @Override
  public EnumAction getItemUseAction(ItemStack itemStack) {
    return EnumAction.eat;
  }

  @Override
  public String getUnlocalizedName(ItemStack itemStack) {
    int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 5);
    return super.getUnlocalizedName() + "." + names[i].toLowerCase();
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
    return itemStack;
  }

  @Override @SideOnly(Side.CLIENT)
  public Icon getIconFromDamage(int damage) {
    int j = MathHelper.clamp_int(damage, 0, 5);
    return icons[j];
  }

  @Override @SideOnly(Side.CLIENT) @SuppressWarnings("unchecked")
  public void getSubItems(int itemId, CreativeTabs creativeTab, List containerList) {
    for (int damage = 0; damage < 6; ++damage) {
      containerList.add(new ItemStack(itemId, 1, damage));
    }
  }

  @Override
  public void registerIcons(IconRegister register) {
    icons = new Icon[6];

    for (int damage = 0; damage < 6; ++damage) {
      icons[damage] = register.registerIcon(DayZ.meta.modId + ":" + "foodCanned".substring("foodCanned".indexOf(".") + 1) + damage);
    }
  }
}