package com.viruss.ahs.player.capabilities.injure;

import net.minecraft.potion.EffectInstance;

public interface IInjureCapability {
    enum LimbEnum{Hand,Leg,Body,Head}
    enum SideEnum{Left,Right}
    enum IdlenessEnum{OneLimb,Slowness,Infection,Zombification,Fait,Pain,Death}

    IdlenessEnum getIdleness();
    LimbEnum getLimb();
    SideEnum getSide();
    float getDuration();
    EffectInstance getConsequence();




}
