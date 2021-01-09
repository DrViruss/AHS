package com.viruss.ahs.event;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import com.viruss.ahs.player.capabilities.TEST.TestCaProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
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

                                /*Just_Cap_TETS*/
    @SubscribeEvent
    public static void onLivingSpawn(LivingSpawnEvent.SpecialSpawn event) {

        if (event.getSpawnReason() == SpawnReason.SPAWN_EGG) {
            LivingEntity entity = event.getEntityLiving();
            if (entity.getEntityWorld().dimension.getType().equals(DimensionType.OVERWORLD)) {
                if (entity instanceof SpiderEntity) {
                    event.setCanceled(true);
                }

                if(entity instanceof SkeletonEntity)
                {
                    entity.getCapability(TestCaProvider.TEST_BLOCKPOS_CAP).ifPresent(handler -> {
                        handler.setPos(new BlockPos(100,100,100));
                    });

                    entity.getCapability(TestCaProvider.TEST_BLOCKPOS_CAP).ifPresent(handler -> {
                        AHS.LOGGER.warn("EntityCapability + SkeletonEntity spawnPos:\t"+handler.getPos());
                    });
                }
            }
        }
    }


    @SubscribeEvent
    public static void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        // Fixed resetting after rejoin

        if (event.getObject() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getObject();
            player.getAttributes().registerAttribute(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);
            player.getAttributes().registerAttribute(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);
        }



                                        /*TEST_ZONE*/
        if ( event.getObject() instanceof SkeletonEntity)
        {
            ResourceLocation spawnLoc = new ResourceLocation(AHS.MOD_ID, "spawn_loc");
            event.addCapability(spawnLoc, new TestCaProvider());
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
        Random random = new Random();
        AbstractAttributeMap attributes = event.getPlayer().getAttributes();

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE) == null)
            attributes.registerAttribute(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);

            attributes.getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE).setBaseValue(100);

        if(attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE) == null) {
            System.out.println("UPDATING a new BLOOD_TYPE_ATTRIBUTE by RESPAWN");
            attributes.registerAttribute(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);
        }
            attributes.getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE).setBaseValue(random.nextInt(7));
    }


}