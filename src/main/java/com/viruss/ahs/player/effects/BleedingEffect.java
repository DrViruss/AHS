package com.viruss.ahs.player.effects;

import com.viruss.ahs.player.attributes.blood.IBloodAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;

public class BleedingEffect extends Effect {
    public static final Effect BLEEDING_EFFECT = null;
    public static final Potion BLEEDING_POTION = null;

    public BleedingEffect() {
        super(EffectType.HARMFUL, 10682385);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

        IAttributeInstance attribute = entityLivingBaseIn.getAttributes().getAttributeInstance(IBloodAttribute.BLOOD_ATTRIBUTE);

        if(attribute!=null) {
            if (attribute.getValue() == 10)
                entityLivingBaseIn.onKillCommand();
            else
                attribute.setBaseValue(attribute.getValue() - 0.5);
        }

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;    /*super.isReady(duration, amplifier);*/
    }
}
