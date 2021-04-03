package com.viruss.ahs.TEST;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.PlayerPartEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class TEST_Events {
    private static PlayerPartEntity ppe;

    @SubscribeEvent
    public static void OnSpawn(EntityJoinWorldEvent event)
    {
        Entity entity = event.getEntity();
        World world = entity.getEntityWorld();

        if(entity instanceof PlayerEntity && world instanceof ServerWorld) {
            ppe = new PlayerPartEntity(TEST_Registrar.PPE.get(),world,entity, PlayerPartEntity.PartType.Body);
        }
    }

}
