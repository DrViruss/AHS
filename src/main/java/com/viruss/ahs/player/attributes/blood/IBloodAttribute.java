package com.viruss.ahs.player.attributes.blood;

import com.viruss.ahs.AHS;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public interface IBloodAttribute {
    public static final int MAX_BLOOD_LVL = 100;
    public static final int MIN_BLOOD_LVL = 10;


    public static final IAttribute BLOOD_ATTRIBUTE = (new RangedAttribute(null,AHS.MOD_ID+".blood",
            MAX_BLOOD_LVL, MIN_BLOOD_LVL, MAX_BLOOD_LVL))
            .setDescription("blood level").setShouldWatch(true);
}
