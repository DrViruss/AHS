package com.viruss.ahs.util;

import com.viruss.ahs.player.BloodGroup;
import com.viruss.ahs.player.attributes.BloodLVL_Attribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

import java.util.Random;

public class PlayerHelper {
    private static final Random random = new Random();
                                /*Other*/
    public static void killWithCustomSource(Entity entity, DamageSource source) {
        entity.attackEntityFrom(source,Float.MAX_VALUE);
    }
    public static void createTag(ItemStack stack, String key, String data){
        stack.getOrCreateTag();
        stack.getTag().putString(key, data);
    }
    public static void replaceItem(PlayerEntity player, Hand hand,int srinkCount, Item newItem,int itemsCount,String tagKey,String tagData){
        ItemStack heldItem = player.getHeldItem(hand);
        heldItem.shrink(srinkCount);
        ItemStack result = new ItemStack(newItem,itemsCount);
        PlayerHelper.createTag(result, tagKey, tagData);
//        player.setHeldItem(hand, result);
        player.addItemStackToInventory(result);
    }
    public static void replaceItem(PlayerEntity player, Hand hand,int srinkCount, Item newItem,int itemsCount){
        ItemStack heldItem = player.getHeldItem(hand);
        heldItem.shrink(srinkCount);
        player.addItemStackToInventory(new ItemStack(newItem,itemsCount));
    }

                                /*Blood amount Attribute*/

    /**
     * Set blood amount to 100%
     * @param entity
     */
    public static void increaseBloodAmount(Entity entity){
        getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get()).setBaseValue(BloodLVL_Attribute.MAX);
    }
    /**
     * Current blood amount += amount
     * @param entity
     * @param amount
     */
    public static void increaseBloodAmount(Entity entity,double amount){
        ModifiableAttributeInstance attribute = getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get());
        attribute.setBaseValue(attribute.getValue()+amount);
    }
    /**
     * Current blood amount -= amount
     * @param entity
     * @param amount
     */
    public static void degreesBloodAmount(Entity entity,double amount){
        ModifiableAttributeInstance attribute = getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get());
        attribute.setBaseValue(attribute.getValue()-amount);
    }
    /**
     * Current blood amount -= 0.01
     * @param entity
     */
    public static void degreesBloodAmount(Entity entity){
        ModifiableAttributeInstance attribute = getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get());
        attribute.setBaseValue(attribute.getValue()-0.01);
    }
    public static double getBloodLVL(Entity entity){
        return getMAI(entity,AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get()).getValue();
    }

                                /*Blood group Attribute*/

    /**
     * Randomize blood group
     * @param entity
     */
    public static void randBloodGroup(Entity entity){
        getMAI(entity,AttributesRegistrar.BLOOD_TYPE_ATTRIBUTE.get()).setBaseValue(random.nextInt(7));
    }
    public static BloodGroup getBloodGroup(Entity entity){
        return new BloodGroup((int)getMAI(entity,AttributesRegistrar.BLOOD_TYPE_ATTRIBUTE.get()).getValue());
    }

                                /*Misc*/

    /**
     * get ModifiableAttributeInstance
     * @param entity
     * @param attribute
     * @return ModifiableAttributeInstance of given entity with given attribute
     */
    public static ModifiableAttributeInstance getMAI(Entity entity,Attribute attribute){
        PlayerEntity player = (PlayerEntity) entity;    //TODO: fix it. All entities must have blood!

        return player.getAttribute(attribute);
    }

}
