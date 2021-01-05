package com.viruss.ahs.player.effects;

import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

//TODO: Fix Icon Error msg
public class BleedingEffect extends Effect {

    public BleedingEffect() {
        super(EffectType.HARMFUL, 10682385);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

        IAttributeInstance attribute = entityLivingBaseIn.getAttributes().getAttributeInstance(IBloodAttributes.BLOOD_LVL_ATTRIBUTE);

        if(attribute!=null) {
            if (attribute.getValue() == 10)
                entityLivingBaseIn.onKillCommand();
            else
                attribute.setBaseValue(attribute.getValue() - 0.01d);
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
