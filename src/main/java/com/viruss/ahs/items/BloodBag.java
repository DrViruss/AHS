package com.viruss.ahs.items;

import com.viruss.ahs.AHS;
import com.viruss.ahs.items.bases.AbstractFluidBag;
import com.viruss.ahs.player.BloodType;
import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import com.viruss.ahs.util.KeyboardHelper;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BloodBag extends AbstractFluidBag {
    boolean full;
    public static final java.lang.String BloodGroupTagKey = "BloodGroup";
    public BloodBag(boolean full) {
        super(new Item.Properties().maxStackSize(1));
        this.full = full;
    }


    //TODO: Set BloodGroup in Tag....mb...


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (KeyboardHelper.isHoldingShift())
        {
            java.lang.String msg = "Status: ";
            if(this.full){
                msg+="Full";}
            else
                msg+="Empty";

            tooltip.add(new StringTextComponent(msg));

            if(this.full) {
                CompoundNBT nbt = stack.getTag();
                if (nbt == null) {
                    stack.getOrCreateChildTag(BloodGroupTagKey);
                    nbt = stack.getTag();
                    nbt.putString(BloodGroupTagKey, new BloodType(7).toString());
                }

                tooltip.add(new StringTextComponent(nbt.get(BloodGroupTagKey).getString()));
            }
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isRemote)
            if(full)
            {
                playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION,100,0,false,false));
                playerIn.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Empty_BloodBag.get().getDefaultInstance());
            }
            else
            {
                playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA,200,4,false,false));
                playerIn.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Full_BloodBag.get().getDefaultInstance());

                playerIn.getHeldItemMainhand().getOrCreateChildTag(BloodGroupTagKey);
                CompoundNBT nbt = playerIn.getHeldItemMainhand().getTag();
                nbt.putString(BloodGroupTagKey, new BloodType((int) playerIn.getAttributes().getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE).getValue()).toString());
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
