package com.viruss.ahs.player.attributes;

import com.viruss.ahs.AHS;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

import javax.annotation.Nullable;

public class BloodAttributes extends RangedAttribute {


    public static final IAttribute BLOOD_LVL_ATTRIBUTE = new BloodAttributes(null, AHS.MOD_ID+".blood_level",
            100, 30, 100);

    public static final  IAttribute BLOOD_TYPE_ATTRIBUTE = new BloodAttributes(null,AHS.MOD_ID+".blood_type",0 ,0,7).setShouldWatch(true);


    public BloodAttributes(@Nullable IAttribute parentIn, String unlocalizedNameIn, double defaultValue, double minimumValueIn, double maximumValueIn) {
        super(parentIn, unlocalizedNameIn, defaultValue, minimumValueIn, maximumValueIn);
    }

}
