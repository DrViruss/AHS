package com.viruss.ahs.player.attributes.blood;

import com.viruss.ahs.AHS;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

import javax.annotation.Nullable;
import java.util.Random;

public class IBloodAttributes extends RangedAttribute {

//TODO: Fix resetting after rejoin
public static final IAttribute BLOOD_LVL_ATTRIBUTE = new IBloodAttributes(null,AHS.MOD_ID+".blood_level",
            100, 30, 100);

    public static final  IAttribute BLOOD_TYPE_ATTRIBUTE = new IBloodAttributes(null,AHS.MOD_ID+".blood_type",0 ,0,7).setShouldWatch(true);

    public IBloodAttributes(@Nullable IAttribute parentIn, String unlocalizedNameIn, double defaultValue, double minimumValueIn, double maximumValueIn) {
        super(parentIn, unlocalizedNameIn, defaultValue, minimumValueIn, maximumValueIn);
    }



}
