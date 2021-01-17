package com.viruss.ahs.player.attributes;

import com.viruss.ahs.util.AttributesRegistrar;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class BloodGroup_Attribute extends RangedAttribute {
    public BloodGroup_Attribute() {
        super(AttributesRegistrar.NAME_PATERN+".blood_type", 0, 0, 7);
    }


}
