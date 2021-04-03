package com.viruss.ahs.TEST;

import com.viruss.ahs.AHS;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AHS.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class Capes {
    public ResourceLocation cape = new ResourceLocation(AHS.MOD_ID, "textures/misc/cape.png");

    @SubscribeEvent
    public void playerRender(RenderPlayerEvent.Pre event) {
        final PlayerEntity player = event.getPlayer();
        final AbstractClientPlayerEntity acp = (AbstractClientPlayerEntity) player;
        final String name = player.getDisplayName().getString();

        if (acp.hasPlayerInfo() && acp.getLocationCape() == null)
        {
            final NetworkPlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(acp.getUniqueID());

//            playerInfo.playerTextures.put(MinecraftProfileTexture.Type.CAPE, cape);
        }
    }
}
