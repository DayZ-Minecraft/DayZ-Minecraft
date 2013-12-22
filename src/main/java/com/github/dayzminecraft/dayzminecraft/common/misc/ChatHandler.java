package com.github.dayzminecraft.dayzminecraft.common.misc;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public final class ChatHandler {
  public static Logger log;

  @SuppressWarnings("unused")
  public static void chatError(EntityPlayer player, String msg) {
    PacketDispatcher.sendPacketToPlayer(new Packet3Chat(ChatMessageComponent.createFromText(EnumChatFormatting.RED + msg)), (Player)player);
  }

  public static void chatConfirmation(EntityPlayer player, String msg) {
    PacketDispatcher.sendPacketToPlayer(new Packet3Chat(ChatMessageComponent.createFromText(EnumChatFormatting.GREEN + msg)), (Player)player);
  }

  public static void chatWarning(EntityPlayer player, String msg) {
    PacketDispatcher.sendPacketToPlayer(new Packet3Chat(ChatMessageComponent.createFromText(EnumChatFormatting.YELLOW + msg)), (Player)player);
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