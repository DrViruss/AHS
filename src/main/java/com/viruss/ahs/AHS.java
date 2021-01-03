package com.viruss.ahs;

import com.viruss.ahs.player.capabilities.injure.IInjureCapability;
import com.viruss.ahs.player.capabilities.injure.InjureCapability;
import com.viruss.ahs.player.capabilities.injure.InjureStorage;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.capabilities.*;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("ahs")
public class AHS
{
	public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ahs";
    public AHS() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::OnLoadComplete);

        
        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
        //dont eby
       // IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
       // modBus.addListener(this::OnLoadComplete);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
                                            /*TO BE CONTINUED*/
        CapabilityManager.INSTANCE.register(IInjureCapability.class,new InjureStorage(),() -> new InjureCapability(IInjureCapability.IdlenessEnum.Pain, IInjureCapability.LimbEnum.Leg, IInjureCapability.SideEnum.Left,10f,new EffectInstance(Potions.STRONG_SLOWNESS.getEffects().get(0))));




    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	
    }
    
    public static final ItemGroup AHS_Tab = new ItemGroup("Advanced_Health_System_Tab") {
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(RegistryHandler.Empty_BloodBag.get());
    	}
    };

    //eby nemnogo
    public void OnLoadComplete(FMLLoadCompleteEvent event){



    }

}
