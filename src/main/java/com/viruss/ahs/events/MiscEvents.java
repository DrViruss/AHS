package com.viruss.ahs.events;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.attributes.BloodAttributes;
import com.viruss.ahs.player.capabilities.InjureCaps;
import com.viruss.ahs.player.injures.AbstractInjure;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
        {
            PlayerEntity player = (PlayerEntity) event.getObject();

                                    /*Attributes*/
            player.getAttributes().registerAttribute(BloodAttributes.BLOOD_LVL_ATTRIBUTE);
            player.getAttributes().registerAttribute(BloodAttributes.BLOOD_TYPE_ATTRIBUTE);

                                    /*Capabilities*/
            event.addCapability(new ResourceLocation(AHS.MOD_ID,"injure"),new InjureCaps.InjureProvider());
        }
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
        if(!event.getPlayer().world.isRemote) {
            Random random = new Random();

            AbstractAttributeMap attributes = event.getPlayer().getAttributes();
            attributes.getAttributeInstance(BloodAttributes.BLOOD_LVL_ATTRIBUTE).setBaseValue(100);
            attributes.getAttributeInstance(BloodAttributes.BLOOD_TYPE_ATTRIBUTE).setBaseValue(random.nextInt(7));


                                        /*CapTEST*/
            event.getPlayer().getCapability(InjureCaps.ABSTRACT_INJURE_CAPABILITY).ifPresent(handler -> {
                    ArrayList<AbstractInjure> arr = handler.getData();
                    arr.add(new AbstractInjure(AbstractInjure.Type.Bleeding, 0));

                    System.out.println(handler.getData().toString());
            });
        }
    }


}