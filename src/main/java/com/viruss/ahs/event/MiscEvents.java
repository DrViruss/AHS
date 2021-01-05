package com.viruss.ahs.event;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class MiscEvents {

    @SubscribeEvent
    public static void EntityInteractEvent(PlayerInteractEvent.EntityInteract event)
    {
        Entity traget = event.getTarget();
        PlayerEntity player = event.getPlayer();

        if(traget instanceof ZombieEntity) {
            if (player.getHeldItemMainhand().getItem() == RegistryHandler.Test_Tube.get())
                player.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Zombie_Saliva.get().getDefaultInstance());

            if (player.getHeldItemMainhand().getItem() == RegistryHandler.Empty_Syringe.get()) {
                player.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Infected_Syringe.get().getDefaultInstance());
                traget.attackEntityFrom(DamageSource.GENERIC, 0.5f);
            }
        }
        if(traget instanceof PlayerEntity) {
            if (player.getHeldItemMainhand().getItem() == RegistryHandler.Infected_Syringe.get()) {
                player.sendMessage(new StringTextComponent(event.getTarget().getName().getFormattedText() + "has been Infected"));
                traget.sendMessage(new StringTextComponent("You has been infected!"));
            }
        }
    }

    @SubscribeEvent
    public static void OnSpawn(PlayerEvent.PlayerLoggedInEvent event)
    {
        AbstractAttributeMap attributes = event.getPlayer().getAttributes();

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);
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
        AbstractAttributeMap attributes = event.getPlayer().getAttributes();
        Random random = new Random();

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);
        else
            attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE).setBaseValue(100);



        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);

            attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE).setBaseValue(random.nextInt(7));
    }


}