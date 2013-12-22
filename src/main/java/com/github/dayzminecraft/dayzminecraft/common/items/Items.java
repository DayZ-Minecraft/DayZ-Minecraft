package com.github.dayzminecraft.dayzminecraft.common.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.Configuration;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.blocks.Blocks;
import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemDrink;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemDrinkBottle;
import com.github.dayzminecraft.dayzminecraft.common.items.food.ItemFood;
import com.github.dayzminecraft.dayzminecraft.common.items.misc.ItemFirestarter;
import com.github.dayzminecraft.dayzminecraft.common.items.misc.ItemHeal;
import com.github.dayzminecraft.dayzminecraft.common.items.weapons.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class Items {
  private static List<Integer> idResolverUsedIds = new ArrayList<>();

  public static Item itemMatches;
  private static int itemMatchesId;
  public static Item healBandage;
  private static int healBandageId;
  public static Item healAntibiotics;
  private static int healAntibioticsId;
  public static Item healBloodbag;
  private static int healBloodbagId;

  public static Item gunAk74u;
  private static int gunAk74uId;
  public static Item gunMakarov;
  private static int gunMakarovId;
  public static Item gunRemington;
  private static int gunRemingtonId;
  public static Item gunLeeEnfield;
  private static int gunLeeEnfieldId;
  public static Item gunGlock17;
  private static int gunGlock17Id;
  public static Item gunDoubleBarreledShotgun;
  private static int gunDoubleBarreledShotgunId;
  public static Item gunUsp;
  private static int gunUspId;
  //public static Item gunAk74;
  //private static int gunAk74Id;

  public static Item ammoAk74u;
  private static int ammoAk74uId;
  public static Item ammoMakarov;
  private static int ammoMakarovId;
  public static Item ammoRemington;
  private static int ammoRemingtonId;
  public static Item ammoLeeEnfield;
  private static int ammoLeeEnfieldId;
  public static Item ammoGlock17;
  private static int ammoGlock17Id;
  public static Item ammoDoubleBarreledShotgun;
  private static int ammoDoubleBarreledShotgunId;
  public static Item ammoUsp;
  private static int ammoUspId;
  //public static Item ammoAk74;
  //private static int ammoAk74Id;

  public static Item camoHelmet;
  private static int camoHelmetId;
  public static Item camoChest;
  private static int camoChestId;
  public static Item camoLegs;
  private static int camoLegsId;
  public static Item camoBoots;
  private static int camoBootsId;

  public static Item cannedBeans;
  private static int cannedBeansId;
  public static Item cannedSoup;
  private static int cannedSoupId;
  public static Item cannedPasta;
  private static int cannedPastaId;
  public static Item cannedFish;
  private static int cannedFishId;
  public static Item cannedPickles;
  private static int cannedPicklesId;
  public static Item cannedFruit;
  private static int cannedFruitId;

  public static Item drinkCanBeer;
  private static int drinkCanBeerId;
  public static Item drinkCanLemonSoda;
  private static int drinkCanLemonSodaId;
  public static Item drinkCanCola;
  private static int drinkCanColaId;
  public static Item drinkCanEnergyDrink;
  private static int drinkCanEnergyDrinkId;
  public static Item drinkCanOrangeSoda;
  private static int drinkCanOrangeSodaId;

  public static Item drinkWhiskeyBottle;
  private static int drinkWhiskeyBottleId;
  public static Item drinkCiderBottle;
  private static int drinkCiderBottleId;
  public static Item drinkVodkaBottle;
  private static int drinkVodkaBottleId;

  public static Item meleeBaseballBat;
  private static int meleeBaseballBatId;
  public static Item meleeBaseballBatNailed;
  private static int meleeBaseballBatNailedId;
  public static Item meleePlank;
  private static int meleePlankId;
  public static Item meleePlankNailed;
  private static int meleePlankNailedId;
  public static Item meleePipe;
  private static int meleePipeId;
  public static Item meleeCrowbar;
  private static int meleeCrowbarId;
  public static Item meleeMachete;
  private static int meleeMacheteId;

  public static void loadItems() {
    gunAk74u = new ItemGunAuto(gunAk74uId, new ItemAk74u()).setUnlocalizedName("gunAk74u");
    gunMakarov = new ItemGunSemi(gunMakarovId, new ItemMakarov()).setUnlocalizedName("gunMakarov");
    gunRemington = new ItemGunSemi(gunRemingtonId, new ItemRemington()).setUnlocalizedName("gunRemington");
    gunLeeEnfield = new ItemGunSemi(gunLeeEnfieldId, new ItemEnfield()).setUnlocalizedName("gunLeeEnfield");
    gunGlock17 = new ItemGunAuto(gunGlock17Id, new ItemGlock17()).setUnlocalizedName("gunGlock17");
    gunDoubleBarreledShotgun = new ItemGunSemi(gunDoubleBarreledShotgunId, new ItemDbShotgun()).setUnlocalizedName("gunDoubleBarreledShotgun");
    gunUsp = new ItemGunSemi(gunUspId, new ItemUsp()).setUnlocalizedName("gunUsp");

    ammoAk74u = new ItemAmmo(ammoAk74uId).setUnlocalizedName("ammoAk74u");
    ammoMakarov = new ItemAmmo(ammoMakarovId).setUnlocalizedName("ammoMakarov");
    ammoRemington = new ItemAmmo(ammoRemingtonId).setUnlocalizedName("ammoRemington");
    ammoLeeEnfield = new ItemAmmo(ammoLeeEnfieldId).setUnlocalizedName("ammoLeeEnfield");
    ammoGlock17 = new ItemAmmo(ammoGlock17Id).setUnlocalizedName("ammoGlock17");
    ammoDoubleBarreledShotgun = new ItemAmmo(ammoDoubleBarreledShotgunId).setUnlocalizedName("ammoDoubleBarreledShotgun");
    ammoUsp = new ItemAmmo(ammoUspId).setUnlocalizedName("ammoUsp");

    itemMatches = (new ItemFirestarter(itemMatchesId, 8)).setUnlocalizedName("itemMatches");

    healBandage = new ItemHeal(healBandageId, 0, Effect.bleeding).subNames(StatCollector.translateToLocal("item.healBandage.description")).setUnlocalizedName("healBandage");
    healAntibiotics = new ItemHeal(healAntibioticsId, 0, Effect.zombification).subNames(StatCollector.translateToLocal("item.healAntibiotics.description")).setUnlocalizedName("healAntibiotics");
    healBloodbag = new ItemMod(healBloodbagId).subNames(StatCollector.translateToLocal("item.healBloodbag.description")).setUnlocalizedName("healBloodbag");

    camoHelmet = (new ItemCamo(camoHelmetId, DayZ.enumArmorMaterialCamo, 4, 0)).setUnlocalizedName("camoHelmet");
    camoChest = (new ItemCamo(camoChestId, DayZ.enumArmorMaterialCamo, 4, 1)).setUnlocalizedName("camoChest");
    camoLegs = (new ItemCamo(camoLegsId, DayZ.enumArmorMaterialCamo, 4, 2)).setUnlocalizedName("camoLegs");
    camoBoots = (new ItemCamo(camoBootsId, DayZ.enumArmorMaterialCamo, 4, 3)).setUnlocalizedName("camoBoots");

    cannedBeans = new ItemFood(cannedBeansId).setUnlocalizedName("cannedBeans");
    cannedSoup = new ItemFood(cannedSoupId).setUnlocalizedName("cannedSoup");
    cannedPasta = new ItemFood(cannedPastaId).setUnlocalizedName("cannedPasta");
    cannedFish = new ItemFood(cannedFishId).setUnlocalizedName("cannedFish");
    cannedPickles = new ItemFood(cannedPicklesId).setUnlocalizedName("cannedPickles");
    cannedFruit = new ItemFood(cannedFruitId).setUnlocalizedName("cannedFruit");

    drinkCanBeer = new ItemDrink(drinkCanBeerId).setUnlocalizedName("drinkCanBeer");
    drinkCanLemonSoda = new ItemDrink(drinkCanLemonSodaId).setUnlocalizedName("drinkCanLemonSoda");
    drinkCanCola = new ItemDrink(drinkCanColaId).setUnlocalizedName("drinkCanCola");
    drinkCanEnergyDrink = new ItemDrink(drinkCanEnergyDrinkId).setUnlocalizedName("drinkCanEnergyDrink");
    drinkCanOrangeSoda = new ItemDrink(drinkCanOrangeSodaId).setUnlocalizedName("drinkCanOrangeSoda");

    drinkWhiskeyBottle = new ItemDrinkBottle(drinkWhiskeyBottleId, 4000, true).isAlcohol(true).setUnlocalizedName("drinkWhiskeyBottle");
    drinkCiderBottle = new ItemDrinkBottle(drinkCiderBottleId, 4000, false).setUnlocalizedName("drinkCiderBottle");
    drinkVodkaBottle = new ItemDrinkBottle(drinkVodkaBottleId, 4000, true).isAlcohol(true).setUnlocalizedName("drinkVodkaBottle");

    meleeBaseballBat = new ItemMelee(meleeBaseballBatId, 6).setUnlocalizedName("meleeBaseballBat");
    meleeBaseballBatNailed = new ItemMelee(meleeBaseballBatNailedId, 8).setUnlocalizedName("meleeBaseballBatNailed");
    meleePlank = new ItemMelee(meleePlankId, 7).setUnlocalizedName("meleePlank");
    meleePlankNailed = new ItemMelee(meleePlankNailedId, 8).setUnlocalizedName("meleePlankNailed");
    meleePipe = new ItemMelee(meleePipeId, 8).setUnlocalizedName("meleePipe");
    meleeCrowbar = new ItemMelee(meleeCrowbarId, 8).setUnlocalizedName("meleeCrowbar");
    meleeMachete = new ItemMelee(meleeMacheteId, 7).setUnlocalizedName("meleeMachete");

    GameRegistry.addShapelessRecipe(new ItemStack(meleeBaseballBatNailed, 1), new ItemStack(meleeBaseballBat, 1), new ItemStack(Blocks.nailBlock, 1, 0));
    GameRegistry.addShapelessRecipe(new ItemStack(meleePlankNailed, 1), new ItemStack(meleePlank, 1), new ItemStack(Blocks.nailBlock, 1, 0));
    GameRegistry.addRecipe(new ItemStack(meleePlank, 1), "#", "#", "#", '#', Block.planks);
    GameRegistry.addRecipe(new ItemStack(meleeBaseballBat, 1), "##!", '#', Block.planks, '!', Item.stick);
  }

  public static void itemConfig(Configuration config) {
    itemMatchesId = config.get(Configuration.CATEGORY_ITEM, "itemMatchesId", getNextId()).getInt();
    healBandageId = config.get(Configuration.CATEGORY_ITEM, "healBandageId", getNextId()).getInt();
    healAntibioticsId = config.get(Configuration.CATEGORY_ITEM, "healAntibioticsId", getNextId()).getInt();
    healBloodbagId = config.get(Configuration.CATEGORY_ITEM, "healBloodbagId", getNextId()).getInt();

    gunAk74uId = config.get(Configuration.CATEGORY_ITEM, "gunAk74uId", getNextId()).getInt();
    gunMakarovId = config.get(Configuration.CATEGORY_ITEM, "gunMakarovId", getNextId()).getInt();
    gunRemingtonId = config.get(Configuration.CATEGORY_ITEM, "gunRemingtonId", getNextId()).getInt();
    gunLeeEnfieldId = config.get(Configuration.CATEGORY_ITEM, "gunLeeEnfieldId", getNextId()).getInt();
    gunGlock17Id = config.get(Configuration.CATEGORY_ITEM, "gunGlock17Id", getNextId()).getInt();
    gunDoubleBarreledShotgunId = config.get(Configuration.CATEGORY_ITEM, "gunDoubleBarreledShotgunId", getNextId()).getInt();

    ammoAk74uId = config.get(Configuration.CATEGORY_ITEM, "ammoAk74uId", getNextId()).getInt();
    ammoMakarovId = config.get(Configuration.CATEGORY_ITEM, "ammoMakarovId", getNextId()).getInt();
    ammoRemingtonId = config.get(Configuration.CATEGORY_ITEM, "ammoRemingtonId", getNextId()).getInt();
    ammoLeeEnfieldId = config.get(Configuration.CATEGORY_ITEM, "ammoLeeEnfieldId", getNextId()).getInt();
    ammoGlock17Id = config.get(Configuration.CATEGORY_ITEM, "ammoGlock17Id", getNextId()).getInt();
    ammoDoubleBarreledShotgunId = config.get(Configuration.CATEGORY_ITEM, "ammoDoubleBarreledShotgunId", getNextId()).getInt();

    camoHelmetId = config.get(Configuration.CATEGORY_ITEM, "camoHelmetId", getNextId()).getInt();
    camoChestId = config.get(Configuration.CATEGORY_ITEM, "camoChestId", getNextId()).getInt();
    camoLegsId = config.get(Configuration.CATEGORY_ITEM, "camoLegsId", getNextId()).getInt();
    camoBootsId = config.get(Configuration.CATEGORY_ITEM, "camoBootsId", getNextId()).getInt();

    cannedBeansId = config.get(Configuration.CATEGORY_ITEM, "cannedBeansId", getNextId()).getInt();
    cannedSoupId = config.get(Configuration.CATEGORY_ITEM, "cannedSoupId", getNextId()).getInt();
    cannedPastaId = config.get(Configuration.CATEGORY_ITEM, "cannedPastaId", getNextId()).getInt();
    cannedFishId = config.get(Configuration.CATEGORY_ITEM, "cannedFishId", getNextId()).getInt();
    cannedPicklesId = config.get(Configuration.CATEGORY_ITEM, "cannedPicklesId", getNextId()).getInt();
    cannedFruitId = config.get(Configuration.CATEGORY_ITEM, "cannedFruitId", getNextId()).getInt();

    drinkCanBeerId = config.get(Configuration.CATEGORY_ITEM, "drinkCanBeerId", getNextId()).getInt();
    drinkCanLemonSodaId = config.get(Configuration.CATEGORY_ITEM, "drinkCanLemonSodaId", getNextId()).getInt();
    drinkCanColaId = config.get(Configuration.CATEGORY_ITEM, "drinkCanColaId", getNextId()).getInt();
    drinkCanEnergyDrinkId = config.get(Configuration.CATEGORY_ITEM, "drinkCanEnergyDrinkId", getNextId()).getInt();
    drinkCanOrangeSodaId = config.get(Configuration.CATEGORY_ITEM, "drinkCanOrangeSodaId", getNextId()).getInt();

    drinkWhiskeyBottleId = config.get(Configuration.CATEGORY_ITEM, "drinkWhiskeyBottleId", getNextId()).getInt();
    drinkCiderBottleId = config.get(Configuration.CATEGORY_ITEM, "drinkCiderBottleId", getNextId()).getInt();
    drinkVodkaBottleId = config.get(Configuration.CATEGORY_ITEM, "drinkVodkaBottleId", getNextId()).getInt();

    meleeBaseballBatId = config.get(Configuration.CATEGORY_ITEM, "meleeBaseballBatId", getNextId()).getInt();
    meleeBaseballBatNailedId = config.get(Configuration.CATEGORY_ITEM, "meleeBaseballBatNailedId", getNextId()).getInt();
    meleePlankId = config.get(Configuration.CATEGORY_ITEM, "meleePlankId", getNextId()).getInt();
    meleePlankNailedId = config.get(Configuration.CATEGORY_ITEM, "meleePlankNailedId", getNextId()).getInt();
    meleePipeId = config.get(Configuration.CATEGORY_ITEM, "meleePipeId", getNextId()).getInt();
    meleeCrowbarId = config.get(Configuration.CATEGORY_ITEM, "meleeCrowbarId", getNextId()).getInt();
    meleeMacheteId = config.get(Configuration.CATEGORY_ITEM, "meleeMacheteId", getNextId()).getInt();

    gunUspId = config.get(Configuration.CATEGORY_ITEM, "gunUspId", getNextId()).getInt();
    //gunAk74Id = config.get(Configuration.CATEGORY_ITEM, "gunAk74Id", 7135).getInt();
    ammoUspId = config.get(Configuration.CATEGORY_ITEM, "ammoUspId", getNextId()).getInt();
    //ammoAk74Id = config.get(Configuration.CATEGORY_ITEM, "ammoAk74Id", 7137).getInt();
  }

  private static int getNextId() {
    int startId = 7100;
    for (int slot = startId; slot < Item.itemsList.length; slot++) {
      if (Item.itemsList[slot] == null && !idResolverUsedIds.contains(slot)) {
        idResolverUsedIds.add(slot);
        return slot;
      }
    }
    return 1;
  }
}
