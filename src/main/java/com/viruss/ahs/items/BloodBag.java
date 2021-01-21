package com.viruss.ahs.items;

import com.viruss.ahs.player.BloodGroup;
import com.viruss.ahs.items.bases.AbstractFluidBag;
import com.viruss.ahs.util.ItemsRegistrar;
import com.viruss.ahs.util.KeyboardHelper;
import com.viruss.ahs.util.PlayerHelper;
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

    /**
     * Create new BloodBag
     * @param full is it full?
     */
    public BloodBag(boolean full) {
        super(new Item.Properties().maxStackSize(1));
        this.full = full;
    }

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
                tooltip.add(new StringTextComponent("Blood Group: " + stack.getTag().get(BloodGroup.BloodGroupTagKey).getString()));
            }
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {

            BloodGroup playersBG = PlayerHelper.getBloodGroup(playerIn);
            ItemStack heldItem = playerIn.getHeldItem(handIn);
            if (full) {

                NBTCreator(heldItem);

                if (isSuitableBG(playersBG,getCurrentBG(heldItem))) {
                    playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 0, false, false));
                    PlayerHelper.increaseBloodAmount(playerIn,30);
                }
                else
                    playerIn.addPotionEffect(new EffectInstance(Effects.POISON, 200, 0, false, false));

                PlayerHelper.replaceItem(playerIn,handIn,1,ItemsRegistrar.Empty_BloodBag.get(),1);

            } else {
                playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 4, false, false));
                PlayerHelper.replaceItem(playerIn,handIn,1,ItemsRegistrar.Full_BloodBag.get(),1,BloodGroup.BloodGroupTagKey,playersBG.toString());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    private BloodGroup getCurrentBG(ItemStack heldItem) {
        return new BloodGroup(heldItem.getTag().getString(BloodGroup.BloodGroupTagKey));
    }

    /**
     * Checks could you receive this BloodGroup
     * @param playersBG BloodGroup of player
     * @param ReceivedBG BloodGroup which player try to use
     * @return true if you can receive this BloodGroup
     */
    private boolean isSuitableBG(BloodGroup playersBG, BloodGroup ReceivedBG) {
        ArrayList<BloodGroup> suitableBGList = BloodGroup.getSuitableGroups(playersBG);
        for (BloodGroup type : suitableBGList) {
            if (ReceivedBG.equals(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Create NBT tag if ItemStack don't have BG tag
     * @param heldItem ItemStack
     */
    private void NBTCreator(ItemStack heldItem) {
        if (this.full ) {
            CompoundNBT nbt = heldItem.getTag();
            if (nbt == null) {
                heldItem.getOrCreateChildTag(BloodGroup.BloodGroupTagKey);
                nbt = heldItem.getTag();
                nbt.putString(BloodGroup.BloodGroupTagKey, "O-");
            }
        }
    }
}
