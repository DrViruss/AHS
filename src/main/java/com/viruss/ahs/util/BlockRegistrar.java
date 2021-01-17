package com.viruss.ahs.util;

import com.viruss.ahs.AHS;
import com.viruss.ahs.blocks.BlockItemBase;
import com.viruss.ahs.blocks.CustomBlock;
import com.viruss.ahs.blocks.RubyBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistrar {

    public static final DeferredRegister<Block> BLOCKS_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, AHS.MOD_ID);



    public static final RegistryObject<Block> Ruby_Block = BLOCKS_REGISTER.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Item> Ruby_Block_Item = ItemsRegistrar.ITEMS_REGISTER.register("ruby_block", () -> new BlockItemBase(Ruby_Block.get()));

    public static final RegistryObject<Block> Custom_Block = BLOCKS_REGISTER.register("custom_block", CustomBlock::new);
    public static final RegistryObject<Item> Custom_Block_Item = ItemsRegistrar.ITEMS_REGISTER.register("custom_block", () -> new BlockItemBase(Custom_Block.get()));
}
