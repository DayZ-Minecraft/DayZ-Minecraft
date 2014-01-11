package com.github.dayzminecraft.dayzminecraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
  public static Block barbedWire;
  public static Block chestLoot;
  public static Block chainFence;
  public static Block sandbagBlock;
  public static Block nailBlock;

  public static void loadBlocks() {
    barbedWire = new BlockBarbedWire().func_149663_c("barbedWire").func_149711_c(3F).func_149752_b(2F);
    GameRegistry.registerBlock(barbedWire, "barbedWire");
    chestLoot = new BlockChestDayZ(0).func_149663_c("chestLoot");
    GameRegistry.registerBlock(chestLoot, "chestLoot");
    chainFence = new BlockFence("chainFence", Material.field_151573_f).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(Block.field_149777_j).func_149663_c("chainFence");
    GameRegistry.registerBlock(chainFence, "chainFence");
    sandbagBlock = new BlockMod(Material.field_151595_p).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(Block.field_149776_m).func_149663_c("sandbagBlock");
    GameRegistry.registerBlock(sandbagBlock, "sandbagBlock");
    nailBlock = new BlockNails(Material.field_151594_q).func_149663_c("nailBlock").func_149711_c(1F).func_149752_b(1F);
    GameRegistry.registerBlock(nailBlock, "nailBlock");
    GameRegistry.addRecipe(new ItemStack(nailBlock, 8), "#", "#", '#', Items.iron_ingot);
  }
}