package com.viruss.ahs.TEST;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.PlayerPartEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TEST_Registrar {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, AHS.MOD_ID);


    public static final RegistryObject<EntityType<PlayerPartEntity>> PPE = ENTITIES.register("ppe", () -> EntityType.Builder.<PlayerPartEntity>create(PlayerPartEntity::new, EntityClassification.WATER_AMBIENT).size(0.5F, 0.4F).build(new ResourceLocation("ppe", "textures/entities/ppe.png").toString()));
    public static final RegistryObject<EntityType<PPE_Mother>> SMTH_ELSE = ENTITIES.register("ppe-mother", () -> EntityType.Builder.<PPE_Mother>create(PPE_Mother::new, EntityClassification.CREATURE).size(1F, 0.7F).build(new ResourceLocation("ppe", "textures/entities/ppe.png").toString()));

}
