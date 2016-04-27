package com.github.dayzminecraft.dayzminecraft.common.misc;

import com.github.dayzminecraft.dayzminecraft.common.world.biomes.Biomes;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class Config {
  public static boolean debug;
  public static boolean thirstEnabled;
  public static int structureGenerationChance;
  public static boolean canSpawnZombiesInDefaultWorld;
  public static boolean showWorldTypeWarning;

  public static void init(FMLPreInitializationEvent event) {
    Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "DayZ Config.txt"));

    config.load();

    Biomes.biomeConfig(config);

    debug = config.get(Configuration.CATEGORY_GENERAL, "debug", false, "Should DayZ log extra information?").getBoolean(false);
    showWorldTypeWarning = config.get(Configuration.CATEGORY_GENERAL, "show-world-type-warning", true, "Should DayZ warn if the worldtype is not DayZ?").getBoolean(true);
    thirstEnabled = config.get(Configuration.CATEGORY_GENERAL, "thirst-enabled", true, "Should DayZ thirst be enabled?").getBoolean(true);
    structureGenerationChance = config.get(Configuration.CATEGORY_GENERAL, "structure-generation-chance", 80, "1 in x chance to generate a structure in a given chunk").getInt(80);
    canSpawnZombiesInDefaultWorld = config.get(Configuration.CATEGORY_GENERAL, "spawn zombies-in-default-world", false, "Should DayZ zombies generate in the surface world?").getBoolean(false);

    config.save();
  }
}