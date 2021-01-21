package com.viruss.ahs.util;

import com.viruss.ahs.AHS;
import com.viruss.ahs.items.*;
import com.viruss.ahs.items.String;
import com.viruss.ahs.items.bases.CustomItem;
import com.viruss.ahs.items.bases.ItemBase;
import com.viruss.ahs.items.bases.PillsBase;
import com.viruss.ahs.items.syringe.EmptySyringe;
import com.viruss.ahs.items.syringe.FullSyringe;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsRegistrar {
                                    /*TODO: split mod to addons*/
    public static final DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, AHS.MOD_ID);





    public static final RegistryObject<Item> Empty_BloodBag = ITEMS_REGISTER.register("empty_bloodbag", () -> new BloodBag(false));
    public static final RegistryObject<Item> Full_BloodBag = ITEMS_REGISTER.register("full_bloodbag", () -> new BloodBag(true));

    public static final RegistryObject<Item> Empty_Syringe = ITEMS_REGISTER.register("empty_syringe", EmptySyringe::new);
    public static final RegistryObject<Item> Infected_Syringe = ITEMS_REGISTER.register("infected_syringe", () -> new FullSyringe(FullSyringe.Fluid.Z_MIXTURE));
    public static final RegistryObject<Item> Adrenaline_Syringe = ITEMS_REGISTER.register("adrenaline_syringe", () -> new FullSyringe(FullSyringe.Fluid.ADRENALINE));
    public static final RegistryObject<Item> Morphine_Syringe = ITEMS_REGISTER.register("morphine_syringe", () -> new FullSyringe(FullSyringe.Fluid.MORPHINE));
    public static final RegistryObject<Item> Blood_Syringe = ITEMS_REGISTER.register("blood_syringe",() -> new FullSyringe(FullSyringe.Fluid.BLOOD));

    public static final RegistryObject<Item> Silk_String = ITEMS_REGISTER.register("silk_string", String::new);
    public static final RegistryObject<Item> Rubber_String = ITEMS_REGISTER.register("rubber_string", String::new);


    public static final RegistryObject<Item> Creative_Medkit = ITEMS_REGISTER.register("creative_medkit", () -> new MedKit(true));
    public static final RegistryObject<Item> Survival_Medkit = ITEMS_REGISTER.register("survival_medkit", () -> new MedKit(true));

    public static final RegistryObject<Item> Bandage = ITEMS_REGISTER.register("bandage", com.viruss.ahs.items.Bandage::new);
    public static final RegistryObject<Item> Elastic_Bandage = ITEMS_REGISTER.register("elastic_bandage", com.viruss.ahs.items.Bandage::new);

    public static final RegistryObject<Item> Rag = ITEMS_REGISTER.register("rag", ItemBase::new);
    public static final RegistryObject<Item> Medical_Patch = ITEMS_REGISTER.register("medical_patch", ItemBase::new);
    public static final RegistryObject<Item> Splint = ITEMS_REGISTER.register("splint", ItemBase::new);
    public static final RegistryObject<Item> Tourniquet = ITEMS_REGISTER.register("tourniquet", ItemBase::new);
    public static final RegistryObject<Item> Hydrogen_Peroxide = ITEMS_REGISTER.register("hydrogen_peroxide", ItemBase::new);

    public static final RegistryObject<Item> Ice_Bag_Empty= ITEMS_REGISTER .register("ice_bag_empty", IceBag::new);
    public static final RegistryObject<Item> Ice_Bag_Cold = ITEMS_REGISTER .register("ice_bag_cold", IceBag::new);
    public static final RegistryObject<Item> Ice_Bag_Warm = ITEMS_REGISTER .register("ice_bag_warm", IceBag::new);
    public static final RegistryObject<Item> Ice_Bag_Hot  = ITEMS_REGISTER .register("ice_bag_hot", IceBag::new);

    //Surgeon tools
    public static final RegistryObject<Item> Suture_Needle = ITEMS_REGISTER.register("suture_needle", ItemBase::new);
    public static final RegistryObject<Item> Tweezers = ITEMS_REGISTER.register("tweezers", ItemBase::new);

    //Pills
    public static final RegistryObject<Item> Antibiotics = ITEMS_REGISTER.register("antibiotics",()-> new PillsBase(Effects.ABSORPTION,600,0.3f));
    public static final RegistryObject<Item> Painkillers = ITEMS_REGISTER.register("painkillers",()-> new PillsBase(Effects.REGENERATION,600,0.3f));

    public static final RegistryObject<Item> Test_Tube = ITEMS_REGISTER.register("test_tube", TestTube::new);
    public static final RegistryObject<Item> Zombie_Saliva = ITEMS_REGISTER.register("zombie_saliva", TestTube::new);
    public static final RegistryObject<Item> Z_Vaccine = ITEMS_REGISTER.register("z_vaccine", TestTube::new);


                                                    /*TEST ITEMS*/
    public static final RegistryObject<Item> Ruby_Gem = ITEMS_REGISTER.register("ruby_gem", ItemBase::new);
    public static final RegistryObject<Item> Advanced_Ruby_Gem = ITEMS_REGISTER.register("advanced_ruby_gem", CustomItem::new);
}
