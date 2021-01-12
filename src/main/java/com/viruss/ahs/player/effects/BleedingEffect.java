package com.viruss.ahs.player.effects;

import com.viruss.ahs.player.attributes.BloodAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;

//TODO: Fix Icon Error msg
public class BleedingEffect extends Effect {

    public BleedingEffect() {
        super(EffectType.HARMFUL, 10682385);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

        IAttributeInstance attribute = entityLivingBaseIn.getAttributes().getAttributeInstance(BloodAttributes.BLOOD_LVL_ATTRIBUTE);

        if(attribute != null) {     //if this is player
            if (attribute.getValue() == 30) {
                if (!(((PlayerEntity) entityLivingBaseIn).isCreative() && entityLivingBaseIn.isSpectator()))     //TODO: OMG... Fix it..
                    entityLivingBaseIn.onKillCommand();
            }
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
