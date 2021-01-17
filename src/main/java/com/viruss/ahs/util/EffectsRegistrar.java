package com.viruss.ahs.util;

import com.viruss.ahs.AHS;
import com.viruss.ahs.player.effects.BleedingEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectsRegistrar
{
	public static final DeferredRegister<Effect> EFFECTS_REGISTER = DeferredRegister.create(ForgeRegistries.POTIONS, AHS.MOD_ID);

	
	

	public static final RegistryObject<Effect> BLEEDING = EFFECTS_REGISTER.register("bleeding", BleedingEffect::new);

}
