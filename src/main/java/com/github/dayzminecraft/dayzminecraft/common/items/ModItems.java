package com.github.dayzminecraft.dayzminecraft.common.items;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;


public class ModItems {
  public static ItemMod itemMatches;
  public static ItemMod healBandage;
  public static ItemMod healAntibiotics;
  public static ItemMod healBloodbag;

  public static ItemMod gunAk74u;
  public static ItemMod gunMakarov;
  public static ItemMod gunRemington;
  public static ItemMod gunLeeEnfield;
  public static ItemMod gunGlock17;
  public static ItemMod gunDoubleBarreledShotgun;
  public static ItemMod gunUsp;

  public static ItemMod ammoAk74u;
  public static ItemMod ammoMakarov;
  public static ItemMod ammoRemington;
  public static ItemMod ammoLeeEnfield;
  public static ItemMod ammoGlock17;
  public static ItemMod ammoDoubleBarreledShotgun;
  public static ItemMod ammoUsp;

  public static ItemMod camoHelmet;
  public static ItemMod camoChest;
  public static ItemMod camoLegs;
  public static ItemMod camoBoots;

  public static ItemMod cannedBeans;
  public static ItemMod cannedSoup;
  public static ItemMod cannedPasta;
  public static ItemMod cannedFish;
  public static ItemMod cannedPickles;
  public static ItemMod cannedFruit;

  public static ItemMod drinkCanBeer;
  public static ItemMod drinkCanLemonSoda;
  public static ItemMod drinkCanCola;
  public static ItemMod drinkCanEnergyDrink;
  public static ItemMod drinkCanOrangeSoda;

  public static ItemMod drinkWhiskeyBottle;
  public static ItemMod drinkCiderBottle;
  public static ItemMod drinkVodkaBottle;

  public static ItemMod meleeBaseballBat;
  public static ItemMod meleeBaseballBatNailed;
  public static ItemMod meleePlank;
  public static ItemMod meleePlankNailed;
  public static ItemMod meleePipe;
  public static ItemMod meleeCrowbar;
  public static ItemMod meleeMachete;

  private static HashMap<String, ItemMod> items = new HashMap<String, ItemMod>();

  public static void loadItems() {
    registerItem(gunAk74u = new ItemGunAuto(new ItemAk74u()).setName("gunAk74u"));
    registerItem(gunMakarov = new ItemGunSemi(new ItemMakarov()).setName("gunMakarov"));
    registerItem(gunRemington = new ItemGunSemi(new ItemRemington()).setName("gunRemington"));
    registerItem(gunLeeEnfield = new ItemGunSemi(new ItemEnfield()).setName("gunLeeEnfield"));
    registerItem(gunGlock17 = new ItemGunAuto(new ItemGlock17()).setName("gunGlock17"));
    registerItem(gunDoubleBarreledShotgun = new ItemGunSemi(new ItemDbShotgun()).setName("gunDoubleBarreledShotgun"));
    registerItem(gunUsp = new ItemGunSemi(new ItemUsp()).setName("gunUsp"));

    registerItem(ammoAk74u = new ItemAmmo().setName("ammoAk74u"));
    registerItem(ammoMakarov = new ItemAmmo().setName("ammoMakarov"));
    registerItem(ammoRemington = new ItemAmmo().setName("ammoRemington"));
    registerItem(ammoLeeEnfield = new ItemAmmo().setName("ammoLeeEnfield"));
    registerItem(ammoGlock17 = new ItemAmmo().setName("ammoGlock17"));
    registerItem(ammoDoubleBarreledShotgun = new ItemAmmo().setName("ammoDoubleBarreledShotgun"));
    registerItem(ammoUsp = new ItemAmmo().setName("ammoUsp"));

    registerItem(itemMatches = (new ItemFirestarter(8)).setName("itemMatches"));

    registerItem(healBandage = new ItemHeal(0, Effect.bleeding).subNames(StatCollector.translateToLocal("item.healBandage.description")).setName("healBandage"));
    registerItem(healAntibiotics = new ItemHeal(0, Effect.zombification).subNames(StatCollector.translateToLocal("item.healAntibiotics.description")).setName("healAntibiotics"));
    registerItem(healBloodbag = new ItemMod().subNames(StatCollector.translateToLocal("item.healBloodbag.description")).setName("healBloodbag"));
    /*
    registerItem(camoHelmet = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 0)).setName("camoHelmet"));
    registerItem(camoChest = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 1)).setName("camoChest"));
    registerItem(camoLegs = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 2)).setName("camoLegs"));
    registerItem(camoBoots = (new ItemCamo(DayZ.enumArmorMaterialCamo, 4, 3)).setName("camoBoots"));
    */
    registerItem(cannedBeans = new ItemFood().setName("cannedBeans"));
    registerItem(cannedSoup = new ItemFood().setName("cannedSoup"));
    registerItem(cannedPasta = new ItemFood().setName("cannedPasta"));
    registerItem(cannedFish = new ItemFood().setName("cannedFish"));
    registerItem(cannedPickles = new ItemFood().setName("cannedPickles"));
    registerItem(cannedFruit = new ItemFood().setName("cannedFruit"));

    registerItem(drinkCanBeer = new ItemDrink().setName("drinkCanBeer"));
    registerItem(drinkCanLemonSoda = new ItemDrink().setName("drinkCanLemonSoda"));
    registerItem(drinkCanCola = new ItemDrink().setName("drinkCanCola"));
    registerItem(drinkCanEnergyDrink = new ItemDrink().setName("drinkCanEnergyDrink"));
    registerItem(drinkCanOrangeSoda = new ItemDrink().setName("drinkCanOrangeSoda"));

    registerItem(drinkWhiskeyBottle = new ItemDrinkBottle(4000, true).isAlcohol(true).setName("drinkWhiskeyBottle"));
    registerItem(drinkCiderBottle = new ItemDrinkBottle(4000, false).setName("drinkCiderBottle"));
    registerItem(drinkVodkaBottle = new ItemDrinkBottle(4000, true).isAlcohol(true).setName("drinkVodkaBottle"));

    registerItem(meleeBaseballBat = new ItemMelee(6).setName("meleeBaseballBat"));
    registerItem(meleeBaseballBatNailed = new ItemMelee(8).setName("meleeBaseballBatNailed"));
    registerItem(meleePlank = new ItemMelee(7).setName("meleePlank"));
    registerItem(meleePlankNailed = new ItemMelee(8).setName("meleePlankNailed"));
    registerItem(meleePipe = new ItemMelee(8).setName("meleePipe"));
    registerItem(meleeCrowbar = new ItemMelee(8).setName("meleeCrowbar"));
    registerItem(meleeMachete = new ItemMelee(7).setName("meleeMachete"));

    //GameRegistry.addShapelessRecipe(new ItemStack(meleeBaseballBatNailed, 1), new ItemStack(meleeBaseballBat, 1), new ItemStack(ModBlocks.nailBlock, 1, 0));
    //GameRegistry.addShapelessRecipe(new ItemStack(meleePlankNailed, 1), new ItemStack(meleePlank, 1), new ItemStack(ModBlocks.nailBlock, 1, 0));
    GameRegistry.addRecipe(new ItemStack(meleePlank, 1), "#", "#", "#", '#', Blocks.planks);
    GameRegistry.addRecipe(new ItemStack(meleeBaseballBat, 1), "##!", '#', Blocks.planks, '!', Items.stick);
  }
  
  private static void registerItem(ItemMod item) {
    GameRegistry.registerItem(item, item.getName());
    items.put(item.getName(), item);
  }

  public static void registerClient(RenderItem renderItem) {
    for (String name : items.keySet()) {
      ItemMod item = items.get(name);
      renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(DayZ.meta.modId + ":" + name, "inventory"));
      if (item instanceof ItemFood) {
        renderItem.getItemModelMesher().register(item, 1, new ModelResourceLocation(DayZ.meta.modId + ":" + name + "-empty", "inventory"));
      }
    }
    items = null;
  }
}
