package com.viruss.ahs.items.syringe;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FullSyringe extends EmptySyringe {
    public Fluid fluid;

    public FullSyringe(Fluid fluid) {
        super(new Properties().maxStackSize(1));
        this.fluid = fluid;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        System.out.println(playerIn.getHeldItemMainhand().getDisplayName()+"\n With Fluid: "+this.fluid.name());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        System.out.println(playerIn.getHeldItemMainhand().getDisplayName()+"\n With Fluid: "+this.fluid.name()+"\n Target:"+target.getDisplayName());
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }

    public enum Fluid{Z_MIXTURE,ADRENALINE,MORPHINE}
}
