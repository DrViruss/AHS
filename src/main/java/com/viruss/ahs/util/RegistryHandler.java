package com.viruss.ahs.util;

import com.viruss.ahs.AHS;
import com.viruss.ahs.blocks.BlockItemBase;
import com.viruss.ahs.blocks.CustomBlock;
import com.viruss.ahs.blocks.RubyBlock;
import com.viruss.ahs.items.String;
import com.viruss.ahs.items.*;
import com.viruss.ahs.items.bases.CustomItem;
import com.viruss.ahs.items.bases.ItemBase;
import com.viruss.ahs.items.bases.PillsBase;
import com.viruss.ahs.player.effects.BleedingEffect;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
	//Item_Register
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AHS.MOD_ID);
	//Block_Register
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AHS.MOD_ID);
	//Effect_Register
	public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, AHS.MOD_ID);
	
	
	
	
	public static void init()
	{
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

		EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	//Items
	public static final RegistryObject<Item> Empty_BloodBag = ITEMS.register("empty_bloodbag", () -> new BloodBag(false));
	public static final RegistryObject<Item> Full_BloodBag = ITEMS.register("full_bloodbag", () -> new BloodBag(true));

	public static final RegistryObject<Item> Empty_Syringe = ITEMS.register("empty_syringe", Syringe::new);
	public static final RegistryObject<Item> Infected_Syringe = ITEMS.register("infected_syringe", Syringe::new);
	public static final RegistryObject<Item> Adrenaline_Syringe = ITEMS.register("adrenaline_syringe", Syringe::new);
	public static final RegistryObject<Item> Morphine_Syringe = ITEMS.register("morphine_syringe", Syringe::new);

	public static final RegistryObject<Item> Silk_String = ITEMS.register("silk_string", String::new);
	public static final RegistryObject<Item> Rubber_String = ITEMS.register("rubber_string", String::new);

	public static final RegistryObject<Item> Test_Tube = ITEMS.register("test_tube", TestTube::new);
	public static final RegistryObject<Item> Zombie_Saliva = ITEMS.register("zombie_saliva", TestTube::new);
	public static final RegistryObject<Item> Z_Vaccine = ITEMS.register("z_vaccine", TestTube::new);

	public static final RegistryObject<Item> Creative_Medkit = ITEMS.register("creative_medkit", MedKit::new);
	public static final RegistryObject<Item> Survival_Medkit = ITEMS.register("survival_medkit", MedKit::new);

	public static final RegistryObject<Item> Bandage = ITEMS.register("bandage", Bandage::new);
	public static final RegistryObject<Item> Elastic_Bandage = ITEMS.register("elastic_bandage", Bandage::new);

	public static final RegistryObject<Item> Rag = ITEMS.register("rag", ItemBase::new);
	public static final RegistryObject<Item> Medical_Patch = ITEMS.register("medical_patch", ItemBase::new);
	public static final RegistryObject<Item> Splint = ITEMS.register("splint", ItemBase::new);
	public static final RegistryObject<Item> Tourniquet = ITEMS.register("tourniquet", ItemBase::new);
	public static final RegistryObject<Item> Hidrogen_Peroxide = ITEMS.register("hidrogen_peroxide", ItemBase::new);

	public static final RegistryObject<Item> Ice_Bag_Empty = ITEMS.register("ice_bag_empty", IceBag::new);
	public static final RegistryObject<Item> Ice_Bag_Cold = ITEMS.register("ice_bag_cold", IceBag::new);
	public static final RegistryObject<Item> Ice_Bag_Warm = ITEMS.register("ice_bag_warm", IceBag::new);
	public static final RegistryObject<Item> Ice_Bag_Hot = ITEMS.register("ice_bag_hot", IceBag::new);
	
	//Surgeon tools
	public static final RegistryObject<Item> Suture_Needle = ITEMS.register("suture_needle", ItemBase::new);
	public static final RegistryObject<Item> Tweezers = ITEMS.register("tweezers", ItemBase::new);
	
	//Pills
	public static final RegistryObject<Item>  Antibiotics = ITEMS.register("antibiotics",()-> new PillsBase(Effects.ABSORPTION,600,0.3f));
	public static final RegistryObject<Item>  Painkilllers = ITEMS.register("painkilllers",()-> new PillsBase(Effects.REGENERATION,600,0.3f));

	//Effects
	public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding", BleedingEffect::new);





											//TEST_OBJECTS

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


}
