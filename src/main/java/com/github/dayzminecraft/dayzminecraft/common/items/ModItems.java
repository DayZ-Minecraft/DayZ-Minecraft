package com.github.dayzminecraft.dayzminecraft.common.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.blocks.ModBlocks;
import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemDrink;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemDrinkBottle;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemFood;
import com.github.dayzminecraft.dayzminecraft.common.items.misc.ItemFirestarter;
import com.github.dayzminecraft.dayzminecraft.common.items.misc.ItemHeal;
import com.github.dayzminecraft.dayzminecraft.common.items.weapons.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
  public static Item itemMatches;
  public static Item healBandage;
  public static Item healAntibiotics;
  public static Item healBloodbag;

  public static Item gunAk74u;
  public static Item gunMakarov;
  public static Item gunRemington;
  public static Item gunLeeEnfield;
  public static Item gunGlock17;
  public static Item gunDoubleBarreledShotgun;
  public static Item gunUsp;

  public static Item ammoAk74u;
  public static Item ammoMakarov;
  public static Item ammoRemington;
  public static Item ammoLeeEnfield;
  public static Item ammoGlock17;
  public static Item ammoDoubleBarreledShotgun;
  public static Item ammoUsp;

  public static Item camoHelmet;
  public static Item camoChest;
  public static Item camoLegs;
  public static Item camoBoots;

  public static Item cannedBeans;
  public static Item cannedSoup;
  public static Item cannedPasta;
  public static Item cannedFish;
  public static Item cannedPickles;
  public static Item cannedFruit;

  public static Item drinkCanBeer;
  public static Item drinkCanLemonSoda;
  public static Item drinkCanCola;
  public static Item drinkCanEnergyDrink;
  public static Item drinkCanOrangeSoda;

  public static Item drinkWhiskeyBottle;
  public static Item drinkCiderBottle;
  public static Item drinkVodkaBottle;

  public static Item meleeBaseballBat;
  public static Item meleeBaseballBatNailed;
  public static Item meleePlank;
  public static Item meleePlankNailed;
  public static Item meleePipe;
  public static Item meleeCrowbar;
  public static Item meleeMachete;

  public static void loadItems() {
    registerItem(gunAk74u = new ItemGunAuto(new ItemAk74u()).setUnlocalizedName("gunAk74u"));
    registerItem(gunMakarov = new ItemGunSemi(new ItemMakarov()).setUnlocalizedName("gunMakarov"));
    registerItem(gunRemington = new ItemGunSemi(new ItemRemington()).setUnlocalizedName("gunRemington"));
    registerItem(gunLeeEnfield = new ItemGunSemi(new ItemEnfield()).setUnlocalizedName("gunLeeEnfield"));
    registerItem(gunGlock17 = new ItemGunAuto(new ItemGlock17()).setUnlocalizedName("gunGlock17"));
    registerItem(gunDoubleBarreledShotgun = new ItemGunSemi(new ItemDbShotgun()).setUnlocalizedName("gunDoubleBarreledShotgun"));
    registerItem(gunUsp = new ItemGunSemi(new ItemUsp()).setUnlocalizedName("gunUsp"));

    registerItem(ammoAk74u = new ItemAmmo().setUnlocalizedName("ammoAk74u"));
    registerItem(ammoMakarov = new ItemAmmo().setUnlocalizedName("ammoMakarov"));
    registerItem(ammoRemington = new ItemAmmo().setUnlocalizedName("ammoRemington"));
    registerItem(ammoLeeEnfield = new ItemAmmo().setUnlocalizedName("ammoLeeEnfield"));
    registerItem(ammoGlock17 = new ItemAmmo().setUnlocalizedName("ammoGlock17"));
    registerItem(ammoDoubleBarreledShotgun = new ItemAmmo().setUnlocalizedName("ammoDoubleBarreledShotgun"));
    registerItem(ammoUsp = new ItemAmmo().setUnlocalizedName("ammoUsp"));

    registerItem(itemMatches = (new ItemFirestarter(8)).setUnlocalizedName("itemMatches"));

    registerItem(healBandage = new ItemHeal(0, Effect.bleeding).subNames(StatCollector.translateToLocal("item.healBandage.description")).setUnlocalizedName("healBandage"));
    registerItem(healAntibiotics = new ItemHeal(0, Effect.zombification).subNames(StatCollector.translateToLocal("item.healAntibiotics.description")).setUnlocalizedName("healAntibiotics"));
    registerItem(healBloodbag = new ItemMod().subNames(StatCollector.translateToLocal("item.healBloodbag.description")).setUnlocalizedName("healBloodbag"));

    registerItem(camoHelmet = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 0)).setUnlocalizedName("camoHelmet"));
    registerItem(camoChest = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 1)).setUnlocalizedName("camoChest"));
    registerItem(camoLegs = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 2)).setUnlocalizedName("camoLegs"));
    registerItem(camoBoots = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 3)).setUnlocalizedName("camoBoots"));

    registerItem(cannedBeans = new ItemFood().setUnlocalizedName("cannedBeans"));
    registerItem(cannedSoup = new ItemFood().setUnlocalizedName("cannedSoup"));
    registerItem(cannedPasta = new ItemFood().setUnlocalizedName("cannedPasta"));
    registerItem(cannedFish = new ItemFood().setUnlocalizedName("cannedFish"));
    registerItem(cannedPickles = new ItemFood().setUnlocalizedName("cannedPickles"));
    registerItem(cannedFruit = new ItemFood().setUnlocalizedName("cannedFruit"));

    registerItem(drinkCanBeer = new ItemDrink().setUnlocalizedName("drinkCanBeer"));
    registerItem(drinkCanLemonSoda = new ItemDrink().setUnlocalizedName("drinkCanLemonSoda"));
    registerItem(drinkCanCola = new ItemDrink().setUnlocalizedName("drinkCanCola"));
    registerItem(drinkCanEnergyDrink = new ItemDrink().setUnlocalizedName("drinkCanEnergyDrink"));
    registerItem(drinkCanOrangeSoda = new ItemDrink().setUnlocalizedName("drinkCanOrangeSoda"));

    registerItem(drinkWhiskeyBottle = new ItemDrinkBottle(4000, true).isAlcohol(true).setUnlocalizedName("drinkWhiskeyBottle"));
    registerItem(drinkCiderBottle = new ItemDrinkBottle(4000, false).setUnlocalizedName("drinkCiderBottle"));
    registerItem(drinkVodkaBottle = new ItemDrinkBottle(4000, true).isAlcohol(true).setUnlocalizedName("drinkVodkaBottle"));

    registerItem(meleeBaseballBat = new ItemMelee(6).setUnlocalizedName("meleeBaseballBat"));
    registerItem(meleeBaseballBatNailed = new ItemMelee(8).setUnlocalizedName("meleeBaseballBatNailed"));
    registerItem(meleePlank = new ItemMelee(7).setUnlocalizedName("meleePlank"));
    registerItem(meleePlankNailed = new ItemMelee(8).setUnlocalizedName("meleePlankNailed"));
    registerItem(meleePipe = new ItemMelee(8).setUnlocalizedName("meleePipe"));
    registerItem(meleeCrowbar = new ItemMelee(8).setUnlocalizedName("meleeCrowbar"));
    registerItem(meleeMachete = new ItemMelee(7).setUnlocalizedName("meleeMachete"));

    GameRegistry.addShapelessRecipe(new ItemStack(meleeBaseballBatNailed, 1), new ItemStack(meleeBaseballBat, 1), new ItemStack(ModBlocks.nailBlock, 1, 0));
    GameRegistry.addShapelessRecipe(new ItemStack(meleePlankNailed, 1), new ItemStack(meleePlank, 1), new ItemStack(ModBlocks.nailBlock, 1, 0));
    GameRegistry.addRecipe(new ItemStack(meleePlank, 1), "#", "#", "#", '#', Blocks.planks);
    GameRegistry.addRecipe(new ItemStack(meleeBaseballBat, 1), "##!", '#', Blocks.planks, '!', Items.stick);
  }
  
  private static void registerItem(Item item) {
    GameRegistry.registerItem(item, item.getUnlocalizedName());
  }
}
