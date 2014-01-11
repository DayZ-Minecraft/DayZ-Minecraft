package com.github.dayzminecraft.dayzminecraft.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.effects.EnactEffect;

public class EntityBullet extends EntityThrowable {
  private int bulletdamage;
  public Entity shootingEntity;

  public EntityBullet(World world) {
    super(world);
    setSize(0.1F, 0.1F);
  }

  public EntityBullet(World world, EntityLivingBase entityLivingBase, int damage) {
    super(world, entityLivingBase);
    bulletdamage = damage;
    shootingEntity = entityLivingBase;
    setSize(0.5F, 0.5F);
    setLocationAndAngles(entityLivingBase.posX, entityLivingBase.posY + entityLivingBase.getEyeHeight(), entityLivingBase.posZ, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch);
    posX -= MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * 0.16F;
    posY -= 0.10000000149011612D;
    posZ -= MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * 0.16F;
    setPosition(posX, posY, posZ);
    yOffset = 0.0F;
    motionX = -MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI);
    motionZ = MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI);
    motionY = (-MathHelper.sin(rotationPitch / 180.0F * (float)Math.PI));
    setThrowableHeading(motionX, motionY, motionZ, 1.5F, 1.0F);
  }

  public EntityBullet(World world, double xCoord, double yCoord, double zCoord) {
    super(world, xCoord, yCoord, zCoord);
  }

  @Override
  protected float getGravityVelocity() {
    return 0.001F;
  }

  @Override
  public void setVelocity(double motionX, double motionY, double motionZ) {
    this.motionX = motionX;
    this.motionY = motionY;
    this.motionZ = motionZ;

    if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F) {
      float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
      prevRotationYaw = rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / Math.PI);
      prevRotationPitch = rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / Math.PI);
      prevRotationPitch = rotationPitch;
      prevRotationYaw = rotationYaw;
      setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
    }
  }

  @Override
  protected void onImpact(MovingObjectPosition movingObjectPosition) {
    if (movingObjectPosition.entityHit != null) {
      int var2 = bulletdamage;

      if (movingObjectPosition.entityHit instanceof EntityLivingBase) {
        movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, shootingEntity), var2);
      }

      if (movingObjectPosition.entityHit instanceof EntityPlayer) {
        if (worldObj.difficultySetting.equals(EnumDifficulty.EASY)) {
          int j = rand.nextInt(10);
          if (j == 0) {
            ((EntityLivingBase)movingObjectPosition.entityHit).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
          }
        } else if (worldObj.difficultySetting.equals(EnumDifficulty.NORMAL)) {
          int j = rand.nextInt(5);
          if (j == 0) {
            ((EntityLivingBase)movingObjectPosition.entityHit).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
          }
        } else if (worldObj.difficultySetting.equals(EnumDifficulty.HARD)) {
          int j = rand.nextInt(3);
          if (j == 0) {
            ((EntityLivingBase)movingObjectPosition.entityHit).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
          }
        }
      }
    } else if (movingObjectPosition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
      if (!worldObj.isRemote) {
        setDead();
      }
      if (worldObj.func_147439_a(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ).equals(Blocks.glass_pane) || worldObj.func_147439_a(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ).equals(Blocks.glass)) {
        worldObj.func_147468_f(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ);
        worldObj.playSoundEffect(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ, "random.glass", 1.0F, 1.0F);
        setDead();
      } else if (worldObj.func_147439_a(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ).equals(Blocks.tallgrass)) {
        worldObj.func_147468_f(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ);
        worldObj.playSoundEffect(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ, "step.grass", 1.0F, 1.0F);
        setDead();
      } else {
        String stepsound = worldObj.func_147439_a(movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ).field_149762_H.func_150498_e();
        worldObj.playSoundAtEntity(this, stepsound, 1.0F, 1.0F);
        setDead();
      }
    }
  }
}
