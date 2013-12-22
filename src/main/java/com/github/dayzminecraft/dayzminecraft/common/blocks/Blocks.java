package com.github.dayzminecraft.dayzminecraft.common.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks {
  private static List<Integer> idResolverUsedIds = new ArrayList<>();

  public static Block barbedWire;
  private static int barbedWireId;
  public static Block chestLoot;
  private static int chestLootId;
  public static Block chainFence;
  private static int chainFenceId;
  public static Block sandbagBlock;
  private static int sandbagBlockId;
  public static Block nailBlock;
  private static int nailBlockId;

  public static void loadBlocks() {
    barbedWire = new BlockBarbedWire(barbedWireId).setUnlocalizedName("barbedWire").setHardness(3F).setResistance(2F);
    GameRegistry.registerBlock(barbedWire, "barbedWire");
    chestLoot = new BlockChestDayZ(chestLootId, 0).setUnlocalizedName("chestLoot");
    GameRegistry.registerBlock(chestLoot, "chestLoot");
    chainFence = new BlockFence(chainFenceId, "chainFence", Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("chainFence");
    GameRegistry.registerBlock(chainFence, "chainFence");
    sandbagBlock = new BlockMod(sandbagBlockId, Material.clay).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("sandbagBlock");
    GameRegistry.registerBlock(sandbagBlock, "sandbagBlock");
    nailBlock = new BlockNails(nailBlockId, Material.circuits).setUnlocalizedName("nailBlock").setHardness(1F).setResistance(1F);
    GameRegistry.registerBlock(nailBlock, "nailBlock");
    GameRegistry.addRecipe(new ItemStack(nailBlock, 8), "#", "#", '#', Item.ingotIron);
  }

  public static void blockConfig(Configuration config) {
    barbedWireId = config.get(Configuration.CATEGORY_BLOCK, "barbedwireID", getNextId(), "Barbed Wire Block ID").getInt();
    chestLootId = config.get(Configuration.CATEGORY_BLOCK, "dayzchestallID", getNextId(), "All Item Chest Block ID").getInt();
    chainFenceId = config.get(Configuration.CATEGORY_BLOCK, "chainlinkfenceID", getNextId(), "Chainlink Fence Block ID").getInt();
    sandbagBlockId = config.get(Configuration.CATEGORY_BLOCK, "sandbagblockID", getNextId(), "Sandbag Block ID").getInt();
    nailBlockId = config.get(Configuration.CATEGORY_BLOCK, "nailsID", getNextId(), "Nail Block ID").getInt();
  }

  private static int getNextId() {
    int startId = 160;
    for (int slot = startId; slot < Block.blocksList.length; slot++) {
      if (Block.blocksList[slot] == null && !idResolverUsedIds.contains(slot)) {
        idResolverUsedIds.add(slot);
        return slot;
      }
    }
    return 1;
  }
}