package com.viruss.ahs.util;

import com.viruss.ahs.AHS;
import com.viruss.ahs.blocks.BlockItemBase;
import com.viruss.ahs.blocks.CustomBlock;
import com.viruss.ahs.blocks.RubyBlock;
import com.viruss.ahs.items.CustomItem;
import com.viruss.ahs.items.ItemBase;
import com.viruss.ahs.player.attributes.blood.IBloodAttribute;
import com.viruss.ahs.player.effects.BleedingEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.potion.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import java.util.AbstractList;

public class RegistryHandler 
{
	//Item_Register
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AHS.MOD_ID);
	//Block_Register
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AHS.MOD_ID);


	

//	public static final DeferredRegister<Potion> POTIONS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, AHS.MOD_ID);
//	public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, AHS.MOD_ID);
	
	
	
	
	public static void init()
	{
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	//Items
	public static final RegistryObject<Item> Empty_BloodBag = ITEMS.register("empty_bloodbag", ItemBase::new);
	public static final RegistryObject<Item> Full_BloodBag = ITEMS.register("full_bloodbag", ItemBase::new);
	public static final RegistryObject<Item> Empty_Syringe = ITEMS.register("empty_syringe", ItemBase::new);
	public static final RegistryObject<Item> Infected_Syringe = ITEMS.register("infected_syringe", ItemBase::new);
	public static final RegistryObject<Item> Adrenaline_Syringe = ITEMS.register("adrenaline_syringe", ItemBase::new);
	public static final RegistryObject<Item> Morphine_Syringe = ITEMS.register("morphine_syringe", ItemBase::new);
	public static final RegistryObject<Item> Silk_String = ITEMS.register("silk_string", ItemBase::new);
	public static final RegistryObject<Item> Rubber_String = ITEMS.register("rubber_string", ItemBase::new);
	public static final RegistryObject<Item> Test_Tube = ITEMS.register("test_tube", ItemBase::new);
	public static final RegistryObject<Item> Zombie_Saliva = ITEMS.register("zombie_saliva", ItemBase::new);
	public static final RegistryObject<Item> Z_Vaccine = ITEMS.register("z_vaccine", ItemBase::new);
	public static final RegistryObject<Item> Creative_Medkit = ITEMS.register("creative_medkit", ItemBase::new);
	public static final RegistryObject<Item> Survival_Medkit = ITEMS.register("survival_medkit", ItemBase::new);
	public static final RegistryObject<Item> Bandage = ITEMS.register("bandage", ItemBase::new);
	public static final RegistryObject<Item> Elastic_Bandage = ITEMS.register("elastic_bandage", ItemBase::new);
	public static final RegistryObject<Item> Rag = ITEMS.register("rag", ItemBase::new);
	public static final RegistryObject<Item> Medical_Patch = ITEMS.register("medical_patch", ItemBase::new);
	public static final RegistryObject<Item> Splint = ITEMS.register("splint", ItemBase::new);
	public static final RegistryObject<Item> Tourniquet = ITEMS.register("tourniquet", ItemBase::new);
	public static final RegistryObject<Item> Hidrogen_Peroxide = ITEMS.register("hidrogen_peroxide", ItemBase::new);
	public static final RegistryObject<Item> Ice_Bag_Empty = ITEMS.register("ice_bag_empty", ItemBase::new);
	public static final RegistryObject<Item> Ice_Bag_Cold = ITEMS.register("ice_bag_cold", ItemBase::new);
	public static final RegistryObject<Item> Ice_Bag_Warm = ITEMS.register("ice_bag_warm", ItemBase::new);
	public static final RegistryObject<Item> Ice_Bag_Hot = ITEMS.register("ice_bag_hot", ItemBase::new);
	
	//Surgeon tools
	public static final RegistryObject<Item> Suture_Needle = ITEMS.register("suture_needle", ItemBase::new);
	public static final RegistryObject<Item> Tweezers = ITEMS.register("tweezers", ItemBase::new);
	
	//Pills
//	public static final Item Antibiotics = new Food("antibiotics",0,0f,true, new Effect(Effects.ABSORPTION,(10*20),0,false,false));
//	public static final Item Painkilllers = new FoodEffectBase("painkilllers",0,0f,true, new PotionEffect(MobEffects.REGENERATION,(20*20),1,false,false));


	//TEST_OBJECTS
	//
	//Items
		public static final RegistryObject<Item> Ruby_Gem = ITEMS.register("ruby_gem", ItemBase::new);
		public static final RegistryObject<Item> Advanced_Ruby_Gem = ITEMS.register("advanced_ruby_gem", CustomItem::new);
		
	
	//Block + BlockItem
		public static final RegistryObject<Block> Ruby_Block = BLOCKS.register("ruby_block", RubyBlock::new);
	//+
		public static final RegistryObject<Item> Ruby_Block_Item = ITEMS.register("ruby_block", () -> new BlockItemBase(Ruby_Block.get()));
		
	//CustomBlock + CustomBlockItem
		public static final RegistryObject<Block> Custom_Block = BLOCKS.register("custom_block", CustomBlock::new);
	//+
		public static final RegistryObject<Item> Custom_Block_Item = ITEMS.register("custom_block", () -> new BlockItemBase(Custom_Block.get()));





//		public static final RegistryObject<Effect> Bleeding_Effect = EFFECTS.register("bleeding_effect",() -> new BleedingEffect(EffectType.HARMFUL,10682385)); //.addAttributesModifier(IBloodAttribute.BLOOD_ATTRIBUTE,"f5a30c50-4d48-11eb-ae93-0242ac130002",1d, AttributeModifier.Operation.ADDITION)
//		public static final RegistryObject<Potion> Bleeding_Potion = POTIONS.register("bleeding_effect", () -> new Potion("bleeding_effect", new EffectInstance(BleedingEffect.BLEEDING_EFFECT,3400)));
}
