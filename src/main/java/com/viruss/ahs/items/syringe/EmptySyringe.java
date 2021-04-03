package com.viruss.ahs.items.syringe;

import com.viruss.ahs.items.bases.ItemBase;
import com.viruss.ahs.player.BloodGroup;
import com.viruss.ahs.player.damage.DamageSources;
import com.viruss.ahs.util.ItemsRegistrar;
import com.viruss.ahs.util.PlayerHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class EmptySyringe extends ItemBase {

    public EmptySyringe() {
            super(new Properties().maxStackSize(16));
    }

    public EmptySyringe( Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        if (!playerIn.world.isRemote) {
            if(target instanceof ZombieEntity)
                PlayerHelper.replaceItem(playerIn,hand,1,ItemsRegistrar.Infected_Syringe.get(),1);
            else if(target instanceof PlayerEntity)
                PlayerHelper.replaceItem(playerIn,hand,1,ItemsRegistrar.Blood_Syringe.get(),1, BloodGroup.BloodGroupTagKey,PlayerHelper.getBloodGroup(target).toString());
            target.attackEntityFrom(DamageSources.EXPERIMENT,0.5f);
        }

        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}
