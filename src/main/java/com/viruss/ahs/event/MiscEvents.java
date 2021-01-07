package com.viruss.ahs.event;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class MiscEvents {
//    @SubscribeEvent
//    public static void EntityInteractEvent(PlayerInteractEvent.EntityInteract event)
//    {
//        Entity traget = event.getTarget();
//        PlayerEntity player = event.getPlayer();
//
//        if(traget instanceof ZombieEntity) {
//            if (player.getHeldItemMainhand().getItem() == RegistryHandler.Test_Tube.get())
//                player.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Zombie_Saliva.get().getDefaultInstance());
//
//            if (player.getHeldItemMainhand().getItem() == RegistryHandler.Empty_Syringe.get()) {
//                player.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Infected_Syringe.get().getDefaultInstance());
//                traget.attackEntityFrom(DamageSource.GENERIC, 0.5f);
//            }
//        }
//        if(traget instanceof PlayerEntity) {
//            if (player.getHeldItemMainhand().getItem() == RegistryHandler.Infected_Syringe.get()) {
//                player.sendMessage(new StringTextComponent(event.getTarget().getName().getFormattedText() + "has been Infected"));
//                traget.sendMessage(new StringTextComponent("You has been infected!"));
//            }
//        }
//    }

    @SubscribeEvent
    public static void OnSpawn(PlayerEvent.PlayerLoggedInEvent event)
    {
        Random random = new Random();
        AbstractAttributeMap attributes = event.getPlayer().getAttributes();

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE) == null) {
            attributes.registerAttribute(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);
            System.out.println("Creating a new BLOOD_TYPE_ATTRIBUTE by LOGGED_IN");
            attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE).setBaseValue(random.nextInt(7));
        }
    }

    @SubscribeEvent
    public static void tick(TickEvent.PlayerTickEvent event)
    {
//			if(event.player.getAttribute(ZombieMode.ZOMBIE).getAttribute().getName() != null)
//				AHS.LOGGER.info(event.player.getAttribute(ZombieMode.ZOMBIE).getAttribute().getName());
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event)
    {
        Random random = new Random();
        AbstractAttributeMap attributes = event.getPlayer().getAttributes();


        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);

            attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE).setBaseValue(100);



        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE) == null) {
            attributes.registerAttribute(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);
            System.out.println("Creating a new BLOOD_TYPE_ATTRIBUTE by RESPAWNING");
        }

            System.out.println("Updating BLOOD_TYPE_ATTRIBUTE by RESPAWNING");
            attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE).setBaseValue(random.nextInt(7));
    }


}