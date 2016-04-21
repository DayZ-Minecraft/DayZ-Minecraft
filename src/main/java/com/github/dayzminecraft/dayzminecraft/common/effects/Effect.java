package com.github.dayzminecraft.dayzminecraft.common.effects;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.LanguageRegistry;

import java.util.Random;

public class Effect extends Potion {
  public static Effect bleeding;
  public static int bleedingId;
  public static Effect zombification;
  public static int zombificationId;

  public Effect(int id, boolean isBadEffect, int color, String name) {
    super(new ResourceLocation(name), isBadEffect, color);
    setPotionName("potion." + name);
  }

  @Override
  public Potion setIconIndex(int x, int y) {
    super.setIconIndex(x, y);
    return this;
  }

  public static void loadEffects() {
    bleeding = new Effect(bleedingId, true, 5149489, "Bleeding");
    zombification = new Effect(zombificationId, true, 5149489, "Zombification");
  }
}