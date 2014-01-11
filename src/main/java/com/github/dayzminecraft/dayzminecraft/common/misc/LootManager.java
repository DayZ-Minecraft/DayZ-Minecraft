package com.github.dayzminecraft.dayzminecraft.common.misc;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.common.ChestGenHooks;

import com.github.dayzminecraft.dayzminecraft.common.blocks.ModBlocks;
import com.github.dayzminecraft.dayzminecraft.common.items.ModItems;

public class LootManager {
  public static WeightedRandomChestContent[] loot = new WeightedRandomChestContent[] {};

  public static void init() {
    for (WeightedRandomChestContent content : StructureVillagePieces.House2.villageBlacksmithChestContents) {
      ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, content.theItemId);
    }

    for (WeightedRandomChestContent content : WorldServer.bonusChestContent) {
      ChestGenHooks.removeItem(ChestGenHooks.BONUS_CHEST, content.theItemId);
    }

    registerAllItems();

    loadDayZ();
  }

  private static void loadDayZ() {
    addLoot(new ItemStack(ModItems.gunMakarov), 7);
    addLoot(new ItemStack(ModItems.gunGlock17), 7);
    addLoot(new ItemStack(ModItems.ammoUsp), 7);
    addLoot(new ItemStack(ModItems.gunMakarov), 5);
    addLoot(new ItemStack(ModItems.gunGlock17), 5);
    addLoot(new ItemStack(ModItems.gunUsp), 5);
    addLoot(new ItemStack(ModItems.ammoAk74u), 5);
    addLoot(new ItemStack(ModItems.ammoLeeEnfield), 5);
    addLoot(new ItemStack(ModItems.ammoDoubleBarreledShotgun), 5);
    addLoot(new ItemStack(ModItems.ammoRemington), 5);
    addLoot(new ItemStack(ModItems.gunLeeEnfield), 1);
    addLoot(new ItemStack(ModItems.gunDoubleBarreledShotgun), 1);
    addLoot(new ItemStack(ModItems.gunAk74u), 1);
    addLoot(new ItemStack(ModItems.gunRemington), 1);
  }

  public static void addLoot(ItemStack itemStack, int itemWorth) {
    ArrayList<WeightedRandomChestContent> contents = new ArrayList<WeightedRandomChestContent>(Arrays.asList(loot));
    contents.add(new WeightedRandomChestContent(itemStack, 1, 1, itemWorth));
    loot = contents.toArray(new WeightedRandomChestContent[contents.size()]);

    ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(itemStack, 1, 1, itemWorth));
    ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(itemStack, 1, 1, itemWorth));
  }

  public static void registerAllItems() {
    addLoot(new ItemStack(ModBlocks.barbedWire), 3);
  /*addLoot(new ItemStack(ModItems.camoHelmet), 3);
    addLoot(new ItemStack(ModItems.camoChest), 3);
    addLoot(new ItemStack(ModItems.camoLegs), 3);
    addLoot(new ItemStack(ModItems.camoBoots), 3);*/
    addLoot(new ItemStack(Blocks.cake), 3);
    addLoot(new ItemStack(Items.bow), 5);
    addLoot(new ItemStack(ModItems.meleeBaseballBatNailed), 5);
    addLoot(new ItemStack(ModItems.meleePipe), 5);
    addLoot(new ItemStack(ModItems.meleePlankNailed), 5);
    addLoot(new ItemStack(ModItems.meleeCrowbar), 5);
    addLoot(new ItemStack(ModItems.meleeMachete), 5);
    addLoot(new ItemStack(Items.map), 5);
    addLoot(new ItemStack(Items.coal), 5);
    addLoot(new ItemStack(Items.iron_ingot), 5);
    addLoot(new ItemStack(Items.writable_book), 5);
    addLoot(new ItemStack(Items.arrow), 5);
    addLoot(new ItemStack(Items.bone), 5);
    addLoot(new ItemStack(ModItems.healBloodbag), 5);
    addLoot(new ItemStack(Blocks.tripwire_hook), 5);
    addLoot(new ItemStack(Items.string), 5);
    addLoot(new ItemStack(Items.boat), 5);
    addLoot(new ItemStack(Items.emerald), 5);
    addLoot(new ItemStack(ModItems.healBandage), 7);
    addLoot(new ItemStack(ModItems.meleeBaseballBat), 7);
    addLoot(new ItemStack(ModItems.meleePlank), 7);
    addLoot(new ItemStack(ModItems.drinkWhiskeyBottle), 7);
    addLoot(new ItemStack(ModItems.drinkCiderBottle), 7);
    addLoot(new ItemStack(ModItems.drinkVodkaBottle), 7);
    addLoot(new ItemStack(ModBlocks.nailBlock), 7);
    addLoot(new ItemStack(Items.beef), 9);
    addLoot(new ItemStack(Items.cooked_beef), 9);
    addLoot(new ItemStack(Items.porkchop), 9);
    addLoot(new ItemStack(Items.cooked_porkchop), 9);
    addLoot(new ItemStack(Items.fish), 9);
    addLoot(new ItemStack(Items.cooked_fished), 9);
    addLoot(new ItemStack(Items.apple), 9);
    addLoot(new ItemStack(Items.mushroom_stew), 9);
    addLoot(new ItemStack(Items.melon), 9);
    addLoot(new ItemStack(Items.cookie), 9);
    addLoot(new ItemStack(Items.potato), 9);
    addLoot(new ItemStack(ModItems.healAntibiotics), 9);
    addLoot(new ItemStack(ModItems.cannedBeans), 9);
    addLoot(new ItemStack(ModItems.cannedSoup), 9);
    addLoot(new ItemStack(ModItems.cannedPasta), 9);
    addLoot(new ItemStack(ModItems.cannedFish), 9);
    addLoot(new ItemStack(ModItems.cannedPickles), 9);
    addLoot(new ItemStack(ModItems.cannedFruit), 9);
    addLoot(new ItemStack(ModItems.drinkCanBeer), 9);
    addLoot(new ItemStack(ModItems.drinkCanLemonSoda), 9);
    addLoot(new ItemStack(ModItems.drinkCanCola), 9);
    addLoot(new ItemStack(ModItems.drinkCanEnergyDrink), 9);
    addLoot(new ItemStack(ModItems.drinkCanOrangeSoda), 9);
    addLoot(new ItemStack(ModItems.cannedBeans, 1, 1), 11);
    addLoot(new ItemStack(ModItems.cannedSoup, 1, 1), 11);
    addLoot(new ItemStack(ModItems.cannedPasta, 1, 1), 11);
    addLoot(new ItemStack(ModItems.cannedFish, 1, 1), 11);
    addLoot(new ItemStack(ModItems.cannedPickles, 1, 1), 11);
    addLoot(new ItemStack(ModItems.cannedFruit, 1, 1), 11);
    addLoot(new ItemStack(ModItems.drinkCanBeer, 1, 1), 11);
    addLoot(new ItemStack(ModItems.drinkCanLemonSoda, 1, 1), 11);
    addLoot(new ItemStack(ModItems.drinkCanCola, 1, 1), 11);
    addLoot(new ItemStack(ModItems.drinkCanEnergyDrink, 1, 1), 11);
    addLoot(new ItemStack(ModItems.drinkCanOrangeSoda, 1, 1), 11);
  }
}
