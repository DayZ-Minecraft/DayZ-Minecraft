package com.github.dayzminecraft.dayzminecraft.common.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.world.EnumDifficulty;

public class AIBreakDoors extends EntityAIBreakDoor {
  private int breakingTime;
  private int previousBreakProgress = -1;

  public AIBreakDoors(EntityLiving entityLiving) {
    super(entityLiving);
  }

  @Override
  public void updateTask() {
    super.updateTask();

    if (this.theEntity.getRNG().nextInt(20) == 0) {
      this.theEntity.worldObj.playAuxSFX(1010, this.doorPosition, 0);
    }

    ++this.breakingTime;
    int i = (int) ((float) this.breakingTime / 240.0F * 10.0F);

    if (i != this.previousBreakProgress) {
      this.theEntity.worldObj.sendBlockBreakProgress(this.theEntity.getEntityId(), this.doorPosition, i);
      this.previousBreakProgress = i;
    }

    if (this.breakingTime == 240 && this.theEntity.worldObj.getDifficulty() == EnumDifficulty.HARD) {
      this.theEntity.worldObj.setBlockToAir(this.doorPosition);
      this.theEntity.worldObj.playAuxSFX(1012, this.doorPosition, 0);
      this.theEntity.worldObj.playAuxSFX(2001, this.doorPosition, Block.getIdFromBlock(this.doorBlock));
    }
  }
}
