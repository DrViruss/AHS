package com.viruss.ahs.items;

import com.viruss.ahs.helpers.KeyboardHelper;
import com.viruss.ahs.items.bases.AbstractFluidBag;
import com.viruss.ahs.player.BloodType;
import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
    BloodType bloodType;
    boolean full;
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
            if(this.full) {
                if(this.bloodType == null)
                    this.bloodType = new BloodType(7);

                msg +="Full \n Group: "+this.bloodType.getType().name();
                if(this.bloodType.isPositive())
                    msg += "+";
                else
                    msg += "-";


                tooltip.add(new StringTextComponent(msg));
            }
            else
                tooltip.add(new StringTextComponent("Empty"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(full)
        {
            playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION,100,0,false,false));
            playerIn.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Empty_BloodBag.get().getDefaultInstance());
        }
        else
        {
            playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA,100,0,false,false));


            BloodBag item = (BloodBag) RegistryHandler.Full_BloodBag.get().getDefaultInstance().copy().getItem();
            IAttributeInstance attribute = playerIn.getAttributes().getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE);
            try {
                item.setBloodType(new BloodType((int) attribute.getValue()));
            }
            catch (Exception e)
            {
                System.out.println("attribute: "+attribute+ "\n"+"item: "+item.getName().toString());
            }
            playerIn.setHeldItem(Hand.MAIN_HAND, item.getDefaultInstance());

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
