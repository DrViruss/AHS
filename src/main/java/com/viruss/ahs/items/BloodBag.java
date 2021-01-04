package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.AbstractFluidBag;
import com.viruss.ahs.player.BloodType;
import net.minecraft.item.Item;

public class BloodBag extends AbstractFluidBag {
    BloodType bloodType;
    public BloodBag() {
        super(new Item.Properties().maxStackSize(1));
    }

    public enum Type{A,B,AB,O}
}
