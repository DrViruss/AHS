package com.viruss.ahs.player.capabilities.injure;

import com.viruss.ahs.player.capabilities.injure.IInjureCapability;
import net.minecraft.potion.EffectInstance;

public class InjureCapability implements IInjureCapability {
    private final IdlenessEnum idleness;
    private final LimbEnum limb;
    private final SideEnum side;
    private final float duration;
    private final EffectInstance Consequence;


    public InjureCapability(IdlenessEnum idleness, LimbEnum limb, SideEnum side, float duration, EffectInstance consequence) {
        this.idleness = idleness;
        this.limb = limb;
        this.side = side;
        this.duration = duration;
        Consequence = consequence;
    }



    @Override
    public IdlenessEnum getIdleness() {
        return null;
    }

    @Override
    public LimbEnum getLimb() {
        return null;
    }

    @Override
    public SideEnum getSide() {
        return null;
    }

    @Override
    public float getDuration() {
        return 0;
    }

    @Override
    public EffectInstance getConsequence() {
        return null;
    }
}
