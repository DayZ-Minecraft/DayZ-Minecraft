package com.github.dayzminecraft.dayzminecraft.common.misc;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public final class ChatHandler {
  public static Logger log;

  @SuppressWarnings("unused")
  public static void chatError(ICommandSender sender, String msg) {
    if (sender instanceof EntityPlayer) {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + msg));
    } else {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText(msg));
    }
  }

  public static void chatConfirmation(ICommandSender sender, String msg) {
    if (sender instanceof EntityPlayer) {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.GREEN + msg));
    } else {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText(msg));
    }
  }

  public static void chatWarning(ICommandSender sender, String msg) {
    if (sender instanceof EntityPlayer) {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.YELLOW + msg));
    } else {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText(msg));
    }
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