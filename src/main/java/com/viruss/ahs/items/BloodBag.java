package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.AbstractFluidBag;
import com.viruss.ahs.player.BloodType;
import com.viruss.ahs.player.attributes.blood.IBloodAttributes;
import com.viruss.ahs.util.KeyboardHelper;
import com.viruss.ahs.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
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
import java.util.ArrayList;
import java.util.List;

public class BloodBag extends AbstractFluidBag {
    boolean full;

    public static final java.lang.String BloodGroupTagKey = "BloodGroup";

    /**
     * Create new BloodBag
     * @param full is it full?
     */
    public BloodBag(boolean full) {
        super(new Item.Properties().maxStackSize(1));
        this.full = full;
    }


    //TODO: Set BloodGroup in Tag....mb...


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()) {
            NBTCreator(stack);

            java.lang.String msg = "Status: ";
            if (this.full) {
                msg += "Full";
            } else
                msg += "Empty";

            tooltip.add(new StringTextComponent(msg));

            if (this.full) {
                tooltip.add(new StringTextComponent("Blood Group: " + stack.getTag().get(BloodGroupTagKey).getString()));
            }
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {

            BloodType playersBG = new BloodType((int) playerIn.getAttributes().getAttributeInstance(IBloodAttributes.BLOOD_TYPE_ATTRIBUTE).getValue());
            ItemStack heldItem = playerIn.getHeldItemMainhand();
            if (full) {

                NBTCreator(heldItem);

                if (isSuitableBG(playersBG,new BloodType(heldItem.getTag().getString(BloodGroupTagKey))))
                    playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 0, false, false));
                else
                    playerIn.addPotionEffect(new EffectInstance(Effects.POISON, 200, 0, false, false));

                playerIn.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Empty_BloodBag.get().getDefaultInstance());

            } else {
                playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 4, false, false));
                playerIn.setHeldItem(Hand.MAIN_HAND, RegistryHandler.Full_BloodBag.get().getDefaultInstance());
                heldItem = playerIn.getHeldItemMainhand();
                heldItem.getOrCreateTag();
                heldItem.getTag().putString(BloodGroupTagKey, playersBG.toString());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    /**
     * Checks could you receive this BloodGroup
     * @param playersBG BloodGroup of player
     * @param ReceivedBG BloodGroup which player try to use
     * @return true if you can receive this BloodGroup
     */
    private boolean isSuitableBG(BloodType playersBG, BloodType ReceivedBG) {
        ArrayList<BloodType> suitableBGList = BloodType.getSuitableGroups(playersBG);
        for (BloodType type : suitableBGList) {
            if (ReceivedBG.equals(type)) {
                return true;
            }
        }
//        AHS.LOGGER.warn("PLayersBG:" + playersBG.toString() + "\nReceivedBG" + ReceivedBG.toString());

        return false;
    }

    /**
     * Create NBT tag if ItemStack don't have BG tag
     * @param heldItem ItemStack
     */
    private void NBTCreator(ItemStack heldItem)
    {
        if (this.full ) {
            CompoundNBT nbt = heldItem.getTag();
            if (nbt == null) {
                heldItem.getOrCreateChildTag(BloodGroupTagKey);
                nbt = heldItem.getTag();
                nbt.putString(BloodGroupTagKey, "O-");
            }
        }
    }
}
