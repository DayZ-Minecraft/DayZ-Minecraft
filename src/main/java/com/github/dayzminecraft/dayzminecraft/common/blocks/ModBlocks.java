package com.github.dayzminecraft.dayzminecraft.common.blocks;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

  public static Block barbedWire;
  public static Block chestLoot;
  public static Block sandbagBlock;
  public static Block nailBlock;

  public static void loadBlocks() {

    barbedWire = new BlockBarbed().setHardness(3F).setResistance(2F);
    chestLoot = new BlockChestDayZ();
    sandbagBlock = new Block(Material.clay).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeSand);
    nailBlock = new BlockNails().setHardness(1F).setResistance(1F);

    registerBlock(barbedWire, "barbedWire");
    registerBlock(chestLoot, "chestLoot");
    registerBlock(sandbagBlock, "sandbagBlock");
    registerBlock(nailBlock, "nailBlock");

    GameRegistry.addRecipe(new ItemStack(nailBlock, 8), "#", "#", '#', Items.iron_ingot);
  }

  private static void registerBlock(Block block, String name) {
    block.setCreativeTab(DayZ.creativeTab);
    block.setUnlocalizedName(name);
    GameRegistry.registerBlock(block, name);
  }

  public static void registerClient(RenderItem renderItem) {
    renderItem.getItemModelMesher().register(Item.getItemFromBlock(nailBlock   ), 0, new ModelResourceLocation(DayZ.meta.modId + ":" +    "nailBlock", "inventory"));
    renderItem.getItemModelMesher().register(Item.getItemFromBlock(barbedWire  ), 0, new ModelResourceLocation(DayZ.meta.modId + ":" +   "barbedWire", "inventory"));
    renderItem.getItemModelMesher().register(Item.getItemFromBlock(sandbagBlock), 0, new ModelResourceLocation(DayZ.meta.modId + ":" + "sandbagBlock", "inventory"));
  }
}