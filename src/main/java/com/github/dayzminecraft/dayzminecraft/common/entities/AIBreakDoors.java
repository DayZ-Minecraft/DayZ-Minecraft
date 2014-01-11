package com.github.dayzminecraft.dayzminecraft.common.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.world.EnumDifficulty;

public class AIBreakDoors extends EntityAIBreakDoor {
  private int breakingTime;
  private int field_75358_j = -1;

  public AIBreakDoors(EntityLiving entityLiving) {
    super(entityLiving);
  }

  @Override
  public void updateTask() {
    super.updateTask();

    if (this.theEntity.getRNG().nextInt(20) == 0) {
      this.theEntity.worldObj.playAuxSFX(1010, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
    }

    ++this.breakingTime;
    int i = (int)((float)this.breakingTime / 240.0F * 10.0F);

    if (i != this.field_75358_j) {
      this.theEntity.worldObj.func_147443_d(this.theEntity.func_145782_y(), this.entityPosX, this.entityPosY, this.entityPosZ, i);
      this.field_75358_j = i;
    }

    if (this.breakingTime == 240 && this.theEntity.worldObj.difficultySetting == EnumDifficulty.HARD) {
      this.theEntity.worldObj.func_147468_f(this.entityPosX, this.entityPosY, this.entityPosZ);
      this.theEntity.worldObj.playAuxSFX(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
      this.theEntity.worldObj.playAuxSFX(2001, this.entityPosX, this.entityPosY, this.entityPosZ, Block.func_149682_b(this.field_151504_e));
    }
  }
}
