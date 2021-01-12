package com.viruss.ahs;

import com.viruss.ahs.player.capabilities.IAbstractInjureCapability;
import com.viruss.ahs.player.capabilities.InjureCaps;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(AHS.MOD_ID)
public class AHS
{
	public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ahs";


    public AHS() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);
        modBus.addListener(this::doClientStuff);
        modBus.addListener(this::OnLoadComplete);

        RegistryHandler.initDefRegs();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
                                            /*TO BE CONTINUED*/
        CapabilityManager.INSTANCE.register(IAbstractInjureCapability.class,new InjureCaps.AbstractInjureStorage(), InjureCaps.AbstractInjureCapability::new);

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


    public void OnLoadComplete(FMLLoadCompleteEvent event){

    }

}
