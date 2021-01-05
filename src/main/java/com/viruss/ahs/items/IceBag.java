package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.AbstractFluidBag;
import net.minecraft.item.Item;


//TODO: Complete this!
public class IceBag extends AbstractFluidBag {
    byte temperature;       //from -5 | to 70

    public IceBag() {
        super(new Item.Properties().maxStackSize(16));
    }
}
