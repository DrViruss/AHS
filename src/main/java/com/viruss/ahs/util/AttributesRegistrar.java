package com.viruss.ahs.util;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.attributes.BloodGroup_Attribute;
import com.viruss.ahs.player.attributes.BloodLVL_Attribute;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AttributesRegistrar {
    public static final String NAME_PATERN = "attribute.name."+AHS.MOD_ID;

    public static final DeferredRegister<Attribute> ATTRIBUTES_REGISTER = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, AHS.MOD_ID);
    public static final RegistryObject<Attribute> BLOOD_LVL_ATTRIBUTE = ATTRIBUTES_REGISTER.register(AHS.MOD_ID+".blood_level", BloodLVL_Attribute::new);
    public static final RegistryObject<Attribute> BLOOD_TYPE_ATTRIBUTE = ATTRIBUTES_REGISTER.register(AHS.MOD_ID+".blood_type", BloodGroup_Attribute::new);


}
