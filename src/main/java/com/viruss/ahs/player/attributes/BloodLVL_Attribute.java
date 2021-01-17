package com.viruss.ahs.player.attributes;

import com.viruss.ahs.util.AttributesRegistrar;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class BloodLVL_Attribute extends RangedAttribute {
    public BloodLVL_Attribute() {
        super(AttributesRegistrar.NAME_PATERN+".blood_level", 100, 30, 100);
    }

}
