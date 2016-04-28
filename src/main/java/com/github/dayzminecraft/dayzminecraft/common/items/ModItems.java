package com.github.dayzminecraft.dayzminecraft.common.items;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.blocks.ModBlocks;
import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemDrink;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemDrinkBottle;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemFood;
import com.github.dayzminecraft.dayzminecraft.common.items.misc.ItemFirestarter;
import com.github.dayzminecraft.dayzminecraft.common.items.misc.ItemHeal;
import com.github.dayzminecraft.dayzminecraft.common.items.weapons.*;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
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
    registerItem(gunAk74u = new ItemGunAuto(new ItemAk74u()).setName("item_ak74u"));
    registerItem(gunMakarov = new ItemGunSemi(new ItemMakarov()).setName("item_makarov"));
    registerItem(gunRemington = new ItemGunSemi(new ItemRemington()).setName("item_remington"));
    registerItem(gunLeeEnfield = new ItemGunSemi(new ItemEnfield()).setName("item_leeenfield"));
    registerItem(gunGlock17 = new ItemGunAuto(new ItemGlock17()).setName("item_glock17"));
    registerItem(gunDoubleBarreledShotgun = new ItemGunSemi(new ItemDbShotgun()).setName("item_dbshotgun"));
    registerItem(gunUsp = new ItemGunSemi(new ItemUsp()).setName("item_usp"));

    registerItem(ammoAk74u = new ItemAmmo().setName("item_ammo_ak74u"));
    registerItem(ammoMakarov = new ItemAmmo().setName("item_ammo_makarov"));
    registerItem(ammoRemington = new ItemAmmo().setName("item_ammo_remington"));
    registerItem(ammoLeeEnfield = new ItemAmmo().setName("item_ammo_leeenfield"));
    registerItem(ammoGlock17 = new ItemAmmo().setName("item_ammo_glock17"));
    registerItem(ammoDoubleBarreledShotgun = new ItemAmmo().setName("item_ammo_dbshotgun"));
    registerItem(ammoUsp = new ItemAmmo().setName("item_ammo_usp"));

    registerItem(itemMatches = (new ItemFirestarter(8)).setName("item_matches"));

    registerItem(healBandage = new ItemHeal(0, Effect.bleeding).subNames(StatCollector.translateToLocal("item.item_bandage.description")).setName("item_bandage"));
    registerItem(healAntibiotics = new ItemHeal(0, Effect.zombification).subNames(StatCollector.translateToLocal("item.item_antibiotics.description")).setName("item_antibiotics"));
    registerItem(healBloodbag = new ItemMod().subNames(StatCollector.translateToLocal("item.item_bloodbag.description")).setName("item_bloodbag"));

    registerItem(cannedBeans = new ItemFood().setName("item_beans"));
    registerItem(cannedSoup = new ItemFood().setName("item_soup"));
    registerItem(cannedPasta = new ItemFood().setName("item_pasta"));
    registerItem(cannedFish = new ItemFood().setName("item_fish"));
    registerItem(cannedPickles = new ItemFood().setName("item_pickles"));
    registerItem(cannedFruit = new ItemFood().setName("item_fruit"));

    registerItem(drinkCanBeer = new ItemDrink().setName("item_beer"));
    registerItem(drinkCanLemonSoda = new ItemDrink().setName("item_lemonsoda"));
    registerItem(drinkCanCola = new ItemDrink().setName("item_cola"));
    registerItem(drinkCanEnergyDrink = new ItemDrink().setName("item_energy"));
    registerItem(drinkCanOrangeSoda = new ItemDrink().setName("item_orangesoda"));

    registerItem(drinkWhiskeyBottle = new ItemDrinkBottle(4000, true).isAlcohol(true).setName("item_whiskeybottle"));
    registerItem(drinkCiderBottle = new ItemDrinkBottle(4000, false).setName("item_ciderbottle"));
    registerItem(drinkVodkaBottle = new ItemDrinkBottle(4000, true).isAlcohol(true).setName("item_vodkabottle"));

    registerItem(meleeBaseballBat = new ItemMelee(6).setName("item_baseballbat"));
    registerItem(meleeBaseballBatNailed = new ItemMelee(8).setName("item_baseballbatnailed"));
    registerItem(meleePlank = new ItemMelee(7).setName("item_plank"));
    registerItem(meleePlankNailed = new ItemMelee(8).setName("item_planknailed"));
    registerItem(meleePipe = new ItemMelee(8).setName("item_pipe"));
    registerItem(meleeCrowbar = new ItemMelee(8).setName("item_crowbar"));
    registerItem(meleeMachete = new ItemMelee(7).setName("item_machete"));

    GameRegistry.addShapelessRecipe(new ItemStack(meleeBaseballBatNailed, 1), new ItemStack(meleeBaseballBat, 1), new ItemStack(ModBlocks.nailBlock, 1, 0));
    GameRegistry.addShapelessRecipe(new ItemStack(meleePlankNailed, 1), new ItemStack(meleePlank, 1), new ItemStack(ModBlocks.nailBlock, 1, 0));
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
        renderItem.getItemModelMesher().register(item, 1, new ModelResourceLocation(DayZ.meta.modId + ":" + name + "_empty", "inventory"));
      }
    }
    items = null;
  }
}
