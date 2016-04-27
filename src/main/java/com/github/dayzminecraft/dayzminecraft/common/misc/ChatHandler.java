package com.github.dayzminecraft.dayzminecraft.common.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ChatHandler {
  public static Logger log;

  @SuppressWarnings("unused")
  public static void chatError(EntityPlayer player, String msg) {
    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + msg));
  }

  public static void chatConfirmation(EntityPlayer player, String msg) {
    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + msg));
  }

  public static void chatWarning(EntityPlayer player, String msg) {
    player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + msg));
  }

  @SuppressWarnings("unused")
  public static void logException(Level level, String message, Throwable error) {
    log.log(level, message, error);
  }

  public static void logException(Level level, String message) {
    log.log(level, message);
  }

  public static void logInfo(String message) {
    log.info(message);
  }

  public static void logDebug(String message) {
    if (Config.debug) {
      log.info("[DEBUG]" + message);
    }
  }
}