package com.viruss.ahs.event;

import com.viruss.ahs.AHS;
import com.viruss.ahs.damage.DamageFilter;
import com.viruss.ahs.player.attributes.blood.IBloodAttribute;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Bus.FORGE/*,value = Dist.DEDICATED_SERVER*/) //SERVER-SIDE DONT WORK
public class DamageEvent
{

	// if(!event.getEntityLiving().getEntityWorld().isRemote()) - RENDER CLIENT

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
				//TODO: Add Broken leg
//				AHS.LOGGER.info("Iam fall");
			}
		}
	 @SubscribeEvent
	 public static void GenericDamage(LivingAttackEvent event)
	 {
		if(!event.getEntityLiving().getEntityWorld().isRemote())/*--------------------------*/
		 if(DamageFilter.isPlayerDamaged(event) )
		 {
			 if(DamageFilter.isZombieAttacker(event)) 
			 {
				 //TODO: Add infection
				 AHS.LOGGER.info("Player attacked by Zombie");					//
				 event.getEntityLiving().getAttribute(IBloodAttribute.BLOOD_ATTRIBUTE).setBaseValue(event.getEntityLiving().getAttribute(IBloodAttribute.BLOOD_ATTRIBUTE).getValue()-10);
				 event.getEntityLiving().sendMessage(new StringTextComponent("current blood level ="+event.getEntityLiving().getAttribute(IBloodAttribute.BLOOD_ATTRIBUTE).getValue()));
//				 				NO ATTRIBUTES! Only moddifiers! 	Try t use NBT-TAG
//				 Effects


			 }
//			 else
//			 {
//				 //TODO: Add injures: Head + Body + Arms damage [Cut Wound + Abrasion]
//				 AHS.LOGGER.info("Player attacked by some Entity");
//			 }
		 }
	 }

	 /////////////////////////////////////////////////////





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
