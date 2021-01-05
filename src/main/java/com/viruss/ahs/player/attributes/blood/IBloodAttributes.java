package com.viruss.ahs.player.attributes.blood;

import com.viruss.ahs.AHS;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

import java.util.Random;

public interface IBloodAttributes {

//TODO: Fix resetting after rejoin
    IAttribute BLOOD_LVL_ATTRIBUTE = (new RangedAttribute(null,AHS.MOD_ID+".blood_level",
            100, 30, 100))
            .setDescription("blood level").setShouldWatch(true);

    IAttribute BLOOD_TYPE_ATTRIBUTE = (new RangedAttribute(null,AHS.MOD_ID+".blood_type",0 ,0,7));
}
