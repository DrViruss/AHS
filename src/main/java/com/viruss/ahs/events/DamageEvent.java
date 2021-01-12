package com.viruss.ahs.events;

import com.viruss.ahs.AHS;
import com.viruss.ahs.damage.DamageFilter;
import com.viruss.ahs.player.attributes.BloodAttributes;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Bus.FORGE/*,value = Dist.DEDICATED_SERVER*/) //SERVER-SIDE DONT WORK
public class DamageEvent
{
	@SubscribeEvent
	 public static void BrokenLegEvent(LivingFallEvent event) {
		if(!event.getEntityLiving().getEntityWorld().isRemote())/*--------------------------*/
			if (DamageFilter.isPlayerFall(event)) {
				event.setDamageMultiplier(0);
				float distance = event.getDistance();

				if (distance >= 4) {
					if (distance < 6) {
						if ((int) (Math.random() * 100) < 50)
							event.getEntityLiving().addPotionEffect(Potions.SLOWNESS.getEffects().get(0));

					}

					if (distance > 6 && distance < 8) {
						if ((int) (Math.random() * 100) < 70)
							event.getEntityLiving().addPotionEffect(Potions.STRONG_SLOWNESS.getEffects().get(0));

					}

					if (distance > 8 && distance < 20) {
						if ((int) (Math.random() * 100) < 90)
							event.getEntityLiving().addPotionEffect(Potions.STRONG_SLOWNESS.getEffects().get(0));
					}
					if(distance>20) {
						event.getEntityLiving().attackEntityFrom(DamageSource.FALL, Float.MAX_VALUE);
					}

				}
			}
		}
	 @SubscribeEvent
	 public static void GenericDamage(LivingAttackEvent event)
	 {
	 	LivingEntity player = event.getEntityLiving();
		if(!event.getEntityLiving().getEntityWorld().isRemote())/*--------------------------*/
		 if(DamageFilter.isPlayerDamaged(event) )
		 {
			 if(DamageFilter.isZombieAttacker(event)) 
			 {
				 AHS.LOGGER.info("Player attacked by Zombie");
				 player.getAttribute(BloodAttributes.BLOOD_LVL_ATTRIBUTE).setBaseValue(event.getEntityLiving().getAttribute(BloodAttributes.BLOOD_LVL_ATTRIBUTE).getValue()-10);
				 player.addPotionEffect(new EffectInstance(RegistryHandler.BLEEDING.get(),300,0,false,false));
				 player.sendMessage(new StringTextComponent("current blood level ="+event.getEntityLiving().getAttribute(BloodAttributes.BLOOD_LVL_ATTRIBUTE).getValue()));
			 }
//			 else
//			 {
//				 //TODO: Add injures: Head + Body + Arms damage [Cut Wound + Abrasion]
//				 AHS.LOGGER.info("Player attacked by some Entity");
//			 }
		 }
	 }



	 //			Future Zone


//	 @SubscribeEvent
//	 public static void LowDamage()
//	 {
//		 //TODO: Add injures: Head + Body + Arms damage [Bruises]
//	 }
//	 @SubscribeEvent
//	 public static void FireDamage()
//	 {
//		 //TODO: Add burns
//	 }
//	 @SubscribeEvent
//	 public static void HeadDamage()
//	 {
//		 //TODO: add "Brain Concussion"
//	 }
//	 @SubscribeEvent
//	 public static void PunctureDamage()
//	 {
//		 //TODO: add injures: Body + Arms+ Legs + Head [Puncture Wound]
//	 }
//	 @SubscribeEvent
//	 public static void ArrowDamage()
//	 {
//		 //TODO: add injures: Arrow in body
//	 }
//	 
}
