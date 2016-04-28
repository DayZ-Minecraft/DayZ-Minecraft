package com.github.dayzminecraft.dayzminecraft.common.misc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Config {

  public static boolean debug;
  public static boolean thirstEnabled;
  public static int structureGenerationChance;
  public static boolean canSpawnZombiesInDefaultWorld;
  public static boolean showWorldTypeWarning;


  static class ConfigItem {

    private final String description;
    private final Object value;

    ConfigItem(String description, Object value) {
      this.description = description;
      this.value = value;
    }

    public String getDescription() {
      return description;
    }

    public Object getValue() {
      return value;
    }
  }

  private static HashMap<String, ConfigItem> configItems;

  public static void init(FMLPreInitializationEvent event) {

    File configLocation = new File(event.getModConfigurationDirectory(), "dayz-config.json");

    FileInputStream inputStream = null;
    try {
      inputStream = new FileInputStream(configLocation);
      Type type = new TypeToken<HashMap<String, ConfigItem>>(){}.getType();
      configItems = new Gson().fromJson(IOUtils.toString(inputStream), type);
      inputStream.close();
    } catch (FileNotFoundException e) {
      createNewConfig(event);
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
      createNewConfig(event);
    }

    debug = getBoolean("debug-mode", false);
    thirstEnabled = getBoolean("thirst-enabled", true);
    structureGenerationChance = getInt("structure-generation-chance", 80);
    canSpawnZombiesInDefaultWorld = getBoolean("spawn-zombies-in-default-world", false);
    showWorldTypeWarning = getBoolean("show-world-type-warning", true);
  }

  private static void createNewConfig(FMLPreInitializationEvent event) {
    configItems = new HashMap<String, ConfigItem>();

    configItems.put("debug-mode", new ConfigItem("Should DayZ log extra information?", false));
    configItems.put("show-world-type-warning", new ConfigItem("Should DayZ warn if the worldtype is not DayZ?", true));
    configItems.put("thirst-enabled", new ConfigItem("Should DayZ thirst be enabled?", true));
    configItems.put("structure-generation-chance", new ConfigItem("1 in x chance to generate a structure in a given chunk", 80));
    configItems.put("spawn-zombies-in-default-world", new ConfigItem("Should DayZ zombies generate in the surface world?", false));

    String config = new GsonBuilder().setPrettyPrinting().create().toJson(configItems);

    Writer writer = null;
    File configLocation = new File(event.getModConfigurationDirectory(), "dayz-config.json");

    try {
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(configLocation), "utf-8"));
      writer.write(config);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        writer.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static Object get(String key) {
    return configItems.get(key).getValue();
  }

  public static int getInt(String key, int defaultValue) {
    try {
      return Integer.parseInt(configItems.get(key).getValue().toString().replace(".0", ""));
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
    return defaultValue;
  }

  public static boolean getBoolean(String key, boolean defaultValue) {
    try {
      return Boolean.parseBoolean(configItems.get(key).getValue().toString());
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
    return defaultValue;
  }
}