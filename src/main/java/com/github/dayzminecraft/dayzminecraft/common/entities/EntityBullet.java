package com.github.dayzminecraft.dayzminecraft.common.entities;

import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.effects.EnactEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {
  private int bulletdamage = 0;

  public EntityBullet(World worldIn) {
    super(worldIn);
    setSize(0.1F, 0.1F);
  }

  public EntityBullet(World worldIn, EntityLivingBase throwerIn) {
    super(worldIn, throwerIn);
    setSize(0.1F, 0.1F);
  }

  public EntityBullet(World worldIn, double x, double y, double z) {
    super(worldIn, x, y, z);
    setSize(0.1F, 0.1F);
  }


  public EntityBullet(World world, EntityPlayer player, int damage) {
    super(world, player);
    setSize(0.1F, 0.1F);
    bulletdamage = damage;
  }

  @Override
  protected float getVelocity() {
    return 3F;
  }

  protected float getGravityVelocity() {
    return 0.01F;
  }


  /**
   * Called when this EntityBullet hits a block or entity.
   */
  @Override
  protected void onImpact(MovingObjectPosition position) {
    if (position.entityHit != null) {
      if (position.entityHit instanceof EntityLivingBase) {
        position.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), bulletdamage);
      }

      if (position.entityHit instanceof EntityPlayer) {
        if (worldObj.getDifficulty().equals(EnumDifficulty.EASY)) {
          int j = rand.nextInt(10);
          if (j == 0) {
            ((EntityLivingBase) position.entityHit).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
          }
        } else if (worldObj.getDifficulty().equals(EnumDifficulty.NORMAL)) {
          int j = rand.nextInt(5);
          if (j == 0) {
            ((EntityLivingBase) position.entityHit).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
          }
        } else if (worldObj.getDifficulty().equals(EnumDifficulty.HARD)) {
          int j = rand.nextInt(3);
          if (j == 0) {
            ((EntityLivingBase) position.entityHit).addPotionEffect(new EnactEffect(Effect.bleeding.getId(), 20 * 300, 1));
          }
        }
      }
    } else if (position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
      if (worldObj.getBlockState(position.getBlockPos()).getBlock().equals(Blocks.glass_pane) || worldObj.getBlockState(position.getBlockPos()).getBlock().equals(Blocks.glass)) {
        worldObj.setBlockToAir(position.getBlockPos());
        worldObj.playSoundAtEntity(this, "random.glass", 1.0F, 1.0F);
      } else if (worldObj.getBlockState(position.getBlockPos()).getBlock().equals(Blocks.tallgrass)) {
        worldObj.playSoundAtEntity(this, "step.grass", 1.0F, 1.0F);
      } else {
        String stepsound = worldObj.getBlockState(position.getBlockPos()).getBlock().stepSound.getBreakSound();
        worldObj.playSoundAtEntity(this, stepsound, 1.0F, 1.0F);
        setDead();
      }
    }
  }
}
