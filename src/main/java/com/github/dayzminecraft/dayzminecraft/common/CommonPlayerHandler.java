package com.github.dayzminecraft.dayzminecraft.common;

import net.minecraft.entity.player.EntityPlayer;

import com.github.dayzminecraft.dayzminecraft.DayZ;
import com.github.dayzminecraft.dayzminecraft.common.thirst.PlayerDataNBT;

import cpw.mods.fml.common.IPlayerTracker;

public class CommonPlayerHandler implements IPlayerTracker {
  @Override
  public void onPlayerLogin(EntityPlayer entityPlayer) {
    PlayerDataNBT.loadData(entityPlayer);
    DayZ.thirst().thirstMap.put(entityPlayer.username, PlayerDataNBT.getPlayerData(entityPlayer).thirstLevel);
  }

  @Override
  public void onPlayerLogout(EntityPlayer entityPlayer) {
    PlayerDataNBT data = PlayerDataNBT.getPlayerData(entityPlayer);
    data.thirstLevel = DayZ.thirst().thirstMap.get(entityPlayer.username);
    PlayerDataNBT.putPlayerData(entityPlayer.username, data);
    PlayerDataNBT.saveData(entityPlayer);
  }

  @Override
  public void onPlayerChangedDimension(EntityPlayer entityPlayer) {

  }

  @Override
  public void onPlayerRespawn(EntityPlayer entityPlayer) {
    DayZ.thirst().thirstMap.put(entityPlayer.username, 0);
  }
}
