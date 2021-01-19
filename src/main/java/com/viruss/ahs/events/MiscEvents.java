package com.viruss.ahs.events;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.capabilities.InjureCaps;
import com.viruss.ahs.player.injures.AbstractInjure;
import com.viruss.ahs.util.AttributesRegistrar;
import com.viruss.ahs.util.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
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
    public static void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof PlayerEntity)
            event.addCapability(new ResourceLocation(AHS.MOD_ID,"injure"),new InjureCaps.InjureProvider());
    }







    @SubscribeEvent
    public static void OnSpawn(PlayerEvent.PlayerLoggedInEvent event)
    {
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
        PlayerEntity player = event.getPlayer();
        if(!player.world.isRemote) {

            PlayerHelper.increaseBloodAmount(player);
            PlayerHelper.randBloodGroup(player);

            player.getCapability(InjureCaps.ABSTRACT_INJURE_CAPABILITY).ifPresent(handler -> {
                handler.getOrCreate(handler.getData(), AbstractInjure.Type.Bleeding).setDuration(10);
                System.out.println(handler.getData().toString());
                handler.setData(new ArrayList<>());
            });
        }
    }


}