package com.github.dayzminecraft.dayzminecraft.common.misc;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;

public final class ChatHandler {
  public static Logger log;

  @SuppressWarnings("unused")
  public static void chatError(EntityPlayer player, String msg) {
    MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(player.getDisplayName()).playerNetServerHandler.processChatMessage(new C01PacketChatMessage(EnumChatFormatting.RED + msg));
  }

  public static void chatConfirmation(EntityPlayer player, String msg) {
    MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(player.getDisplayName()).playerNetServerHandler.processChatMessage(new C01PacketChatMessage(EnumChatFormatting.GREEN + msg));
  }

  public static void chatWarning(EntityPlayer player, String msg) {
    MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(player.getDisplayName()).playerNetServerHandler.processChatMessage(new C01PacketChatMessage(EnumChatFormatting.YELLOW + msg));
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