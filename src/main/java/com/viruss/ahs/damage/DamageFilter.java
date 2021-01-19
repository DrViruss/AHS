package com.viruss.ahs.damage;

import com.viruss.ahs.AHS;

import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Bus.FORGE)
							//WTF?
public class DamageFilter {
	//TODO: remove this thing
	  public static boolean isPlayerDamaged(LivingAttackEvent event)
	  {
		  return event.getEntity() instanceof PlayerEntity;
	  }
	  
	  public static boolean isPlayerFall( LivingFallEvent event)
	  {
		  return event.getEntityLiving() instanceof PlayerEntity;
	  }
	  
	  public static boolean isZombieAttacker(LivingAttackEvent event)
	  {
		  return event.getSource().getTrueSource() instanceof ZombieEntity;
	  }
	  
	  public static void DamageSystem(PlayerEntity player)
	  {
		  //player.getCombatTracker().trackDamage(damageSrc, healthIn, damageAmount);
	  }
	  
	  
}
