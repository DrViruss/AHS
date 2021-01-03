package com.viruss.ahs.damage;

import com.viruss.ahs.AHS;

import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Bus.FORGE)
public class DamageFilter {
	
	  public static boolean isPlayerDamaged(LivingAttackEvent event)
	  {
		if(event.getEntity() instanceof PlayerEntity)
			return true;
		else
			return false;
	  }
	  
	  public static boolean isPlayerFall( LivingFallEvent event)
	  {
		  if((event.getEntityLiving() instanceof PlayerEntity))
		  {
				return true;
		  }
			else
				return false;
	  }
	  
	  public static boolean isZombieAttacker(LivingAttackEvent event)
	  {
		  if((event.getSource().getTrueSource() instanceof ZombieEntity))
		  {
				return true;
		  }
			else
				return false;
	  }
	  
	  public static void DamageSystem(PlayerEntity player)
	  {
		  //player.getCombatTracker().trackDamage(damageSrc, healthIn, damageAmount);
	  }
	  
	  
}
