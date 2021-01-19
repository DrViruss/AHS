package com.viruss.ahs.player.effects;

import com.viruss.ahs.player.damage.DamageSources;
import com.viruss.ahs.util.PlayerHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.text.StringTextComponent;

import java.util.UUID;

//TODO: Fix Icon Error msg
public class BleedingEffect extends Effect {

    public BleedingEffect() {
        super(EffectType.HARMFUL, 10682385);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

        if(entityLivingBaseIn instanceof PlayerEntity)
        {
            if(!(PlayerHelper.getBloodLVL(entityLivingBaseIn) == 30)) {
                PlayerHelper.degreesBloodAmount(entityLivingBaseIn);
                entityLivingBaseIn.sendMessage(new StringTextComponent("current blood level ="+PlayerHelper.getBloodLVL(entityLivingBaseIn)), UUID.randomUUID());
            }
            else
                PlayerHelper.killWithCustomSource(entityLivingBaseIn,DamageSources.OUT_OF_BLOOD);
        }
    }

    @Override
    public boolean shouldRender(EffectInstance effect) {
        return false;
    }

    @Override
    public boolean shouldRenderInvText(EffectInstance effect) {
        return false;
    }

    @Override
    public boolean shouldRenderHUD(EffectInstance effect) {
        return false;
    }



    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;    /*super.isReady(duration, amplifier);*/
    }
}
