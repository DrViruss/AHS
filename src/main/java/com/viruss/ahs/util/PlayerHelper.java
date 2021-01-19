package com.viruss.ahs.util;

import com.viruss.ahs.player.BloodType;
import com.viruss.ahs.player.attributes.BloodLVL_Attribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;

import java.util.Random;

public class PlayerHelper {
    private static Random random = new Random();
                                /*Other*/
    public static void killWithCustomSource(Entity entity, DamageSource source) {
        entity.attackEntityFrom(source,Float.MAX_VALUE);
    }

                                /*Blood amount Attribute*/
    public static void increaseBloodAmount(Entity entity){
        getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get()).setBaseValue(BloodLVL_Attribute.MAX);
    }
    public static void increaseBloodAmount(Entity entity,double amount){
        ModifiableAttributeInstance attribute = getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get());
        attribute.setBaseValue(attribute.getValue()+amount);
    }
    public static void degreesBloodAmount(Entity entity,double amount){
        ModifiableAttributeInstance attribute = getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get());
        attribute.setBaseValue(attribute.getValue()-amount);
    }
    public static void degreesBloodAmount(Entity entity){
        ModifiableAttributeInstance attribute = getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get());
        attribute.setBaseValue(attribute.getValue()-0.01);
    }
    public static double getBloodLVL(Entity entity){
        return getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get()).getValue();
    }

                                /*Blood group Attribute*/
    public static void randBloodGroup(Entity entity){
        getMAI(entity,AttributesRegistrar.BLOOD_TYPE_ATTRIBUTE.get()).setBaseValue(random.nextInt(7));
    }
    public static BloodType getBloodGroup(Entity entity){
        return new BloodType((int)getMAI(entity,AttributesRegistrar.BLOOD_TYPE_ATTRIBUTE.get()).getValue());
    }

                                /*Misc*/
    public static ModifiableAttributeInstance getMAI(Entity entity,Attribute attribute){
        PlayerEntity player = (PlayerEntity) entity;    //TODO: fix it. All entities must have blood!

        return player.getAttribute(attribute);
    }

}
