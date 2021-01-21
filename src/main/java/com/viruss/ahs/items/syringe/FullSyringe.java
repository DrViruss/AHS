package com.viruss.ahs.items.syringe;

import com.viruss.ahs.player.BloodGroup;
import com.viruss.ahs.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class FullSyringe extends EmptySyringe {
    public Fluid fluid;

    public FullSyringe(Fluid fluid) {
        super(new Properties().maxStackSize(1));
        this.fluid = fluid;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()) {
            java.lang.String msg = "Fluid: "+this.fluid.toString();
            tooltip.add(new StringTextComponent(msg));

            if (this.fluid == Fluid.BLOOD) {
                tooltip.add(new StringTextComponent("Blood Group: " + stack.getTag().get(BloodGroup.BloodGroupTagKey).getString()));
            }
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        System.out.println(playerIn.getHeldItemMainhand().getDisplayName()+"\n With Fluid: "+this.fluid.name());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        System.out.println(playerIn.getHeldItemMainhand().getDisplayName()+"\n With Fluid: "+this.fluid.name()+"\n Target:"+target.getDisplayName());
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }



    public enum Fluid{Z_MIXTURE,ADRENALINE,MORPHINE,BLOOD}
}
