package com.viruss.ahs;

import com.viruss.ahs.TEST.EmptyRenderer;
import com.viruss.ahs.TEST.TEST_Registrar;
import com.viruss.ahs.player.PlayerPartEntity;
import com.viruss.ahs.player.capabilities.IAbstractInjureCapability;
import com.viruss.ahs.player.capabilities.InjureCaps;
import com.viruss.ahs.util.AttributesRegistrar;
import com.viruss.ahs.util.BlocksRegistrar;
import com.viruss.ahs.util.EffectsRegistrar;
import com.viruss.ahs.util.ItemsRegistrar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Map;


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
        initDefRegs(modBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    void initDefRegs(IEventBus modbus)
    {
        ItemsRegistrar.ITEMS_REGISTER.register(modbus);
        BlocksRegistrar.BLOCKS_REGISTER.register(modbus);
        EffectsRegistrar.EFFECTS_REGISTER.register(modbus);
        AttributesRegistrar.ATTRIBUTES_REGISTER.register(modbus);
        TEST_Registrar.ENTITIES.register(modbus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
                                            /*TO BE CONTINUED*/
        CapabilityManager.INSTANCE.register(IAbstractInjureCapability.class,new InjureCaps.AbstractInjureStorage(), InjureCaps.AbstractInjureCapability::new);
        addPlayerEntityAttributes(event);
    }

    /**
     * Adds Attributes to player.
     * All tryCatchES are required.
     * @param event - FMLCommonSetupEvent
     */
    public static void addPlayerEntityAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AttributeModifierMap oldmap = null;
            Field forgeMapField = null;


            try {
                forgeMapField = GlobalEntityTypeAttributes.class.getDeclaredField("FORGE_ATTRIBUTES");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }


            forgeMapField.setAccessible(true);


            try {
                oldmap = ((Map<EntityType<? extends LivingEntity>, AttributeModifierMap>) forgeMapField.get(null)).get(EntityType.PLAYER);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (oldmap == null) {
                Field vanillaMapField = ObfuscationReflectionHelper.findField(GlobalEntityTypeAttributes.class, "field_233833_b_");
                vanillaMapField.setAccessible(true);


                try {
                    oldmap = ((Map<EntityType<? extends LivingEntity>, AttributeModifierMap>) vanillaMapField.get(null)).get(EntityType.PLAYER);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }

            Field internalMapField = ObfuscationReflectionHelper.findField(AttributeModifierMap.class, "field_233802_a_");
            internalMapField.setAccessible(true);
            Map<Attribute, ModifiableAttributeInstance> internalMap = null;


            try {
                internalMap = (Map<Attribute, ModifiableAttributeInstance>) internalMapField.get(oldmap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            AttributeModifierMap.MutableAttribute builder = AttributeModifierMap.createMutableAttribute();

            for (Map.Entry<Attribute, ModifiableAttributeInstance> e : internalMap.entrySet())
                builder.createMutableAttribute(e.getKey(), e.getValue().getBaseValue());



            GlobalEntityTypeAttributes.put(EntityType.PLAYER, builder.createMutableAttribute(AttributesRegistrar.BLOOD_LVL_ATTRIBUTE.get()).createMutableAttribute(AttributesRegistrar.BLOOD_TYPE_ATTRIBUTE.get()).create());

        });
    }


    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        RenderingRegistry.registerEntityRenderingHandler(TEST_Registrar.PPE.get(), EmptyRenderer::new);
        
        //TODO:killME
        RenderingRegistry.registerEntityRenderingHandler(TEST_Registrar.SMTH_ELSE.get(), EmptyRenderer::new);
    }
    
    public static final ItemGroup AHS_Tab = new ItemGroup("Advanced_Health_System_Tab") {
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemsRegistrar.Empty_BloodBag.get());
    	}
    };


    public void OnLoadComplete(FMLLoadCompleteEvent event){

    }

}
