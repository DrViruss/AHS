package com.viruss.ahs.player.attributes;

import com.viruss.ahs.util.AttributesRegistrar;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class BloodLVL_Attribute extends RangedAttribute {
    public static final float MAX = 100;
    public static final float MIN = 30;

    public BloodLVL_Attribute() {
        super(AttributesRegistrar.NAME_PATERN+".blood_level", MAX, MIN, MAX);
    }

}
