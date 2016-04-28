package com.github.dayzminecraft.dayzminecraft.common.entities;

import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.effects.EnactEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityCrawler extends EntityMob {

  public EntityCrawler(World par1World) {
    super(par1World);
    setHealth(12F);
    float moveSpeed = 0.3F;
    ((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
    tasks.addTask(0, new EntityAISwimming(this));
    tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayerMP.class, moveSpeed, false));
    tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed, false));
    tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityWalker.class, moveSpeed, true));
    tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, moveSpeed, true));
    tasks.addTask(5, new EntityAIMoveThroughVillage(this, moveSpeed, false));
    tasks.addTask(6, new EntityAIWander(this, 0.3F));
    tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
    tasks.addTask(8, new EntityAILookIdle(this));
    tasks.addTask(9, new AIBreakDoors(this));
    targetTasks.addTask(10, new EntityAIHurtByTarget(this, false));
    targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
    targetTasks.addTask(13, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true));
  }

  @Override
  protected boolean canDespawn() {
    return false;
  }

  @Override
  protected String getLivingSound() {
    return "mob.zombie.say";
  }

  @Override
  protected String getHurtSound() {
    return "mob.zombie.hurt";
  }

  @Override
  protected String getDeathSound() {
    return "mob.zombie.death";
  }

  @Override
  protected void playStepSound(BlockPos pos, Block blockIn) {
    this.playSound("mob.zombie.step", 0.15F, 1.0F);
  }

  /*
  @Override
  protected Entity findPlayerToAttack() {
    EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 16D);

    if (entityplayer != null && canEntityBeSeen(entityplayer)) {
      return entityplayer;
    } else {
      return null;
    }
  }*/

  @Override
  public boolean attackEntityFrom(DamageSource damageSource, float damage) {
    if (super.attackEntityFrom(damageSource, damage)) {
      Entity entity = damageSource.getEntity();

      if (riddenByEntity == entity || ridingEntity == entity) {
        return true;
      }

      if (entity != this && entity instanceof EntityLivingBase) {
        setAttackTarget((EntityLivingBase) entity);
      }

      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean attackEntityAsMob(Entity entity) {
    if (worldObj.getDifficulty().equals(EnumDifficulty.EASY)) {
      int j = rand.nextInt(10);
      int k = rand.nextInt(20);
      if (j == 0) {
        ((EntityLivingBase) entity).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
      }
      if (k == 0) {
        ((EntityLivingBase) entity).addPotionEffect(new EnactEffect(Effect.zombification.getId(), 20 * 300, 1));
      }
      return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
    } else if (worldObj.getDifficulty().equals(EnumDifficulty.NORMAL)) {
      int j = rand.nextInt(5);
      int k = rand.nextInt(10);
      if (j == 0) {
        ((EntityLivingBase) entity).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
      }
      if (k == 0) {
        ((EntityLivingBase) entity).addPotionEffect(new EnactEffect(Effect.zombification.getId(), 20 * 300, 1));
      }
      return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2);
    } else if (worldObj.getDifficulty().equals(EnumDifficulty.HARD)) {
      int j = rand.nextInt(3);
      int k = rand.nextInt(6);
      if (j == 0) {
        ((EntityLivingBase) entity).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
      }
      if (k == 0) {
        ((EntityLivingBase) entity).addPotionEffect(new EnactEffect(Effect.zombification.getId(), 20 * 300, 1));
      }
      return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
    } else {
      return false;
    }
  }

  @Override
  public void onUpdate() {
    super.onUpdate();

    if (!worldObj.isRemote && worldObj.getDifficulty().equals(EnumDifficulty.PEACEFUL)) {
      setDead();
    }
  }

  @Override
  public float getBlockPathWeight(BlockPos pos) {
    return 0.5F - worldObj.getLightBrightness(pos);
  }

  @Override
  public void writeEntityToNBT(NBTTagCompound tagCompound) {
    super.writeEntityToNBT(tagCompound);
  }
}