package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.ItemBase;
import net.minecraft.item.Item;


//TODO: Complete this!
public class MedKit extends ItemBase {
    boolean isCreative;

    public MedKit(boolean isCreative) {
        super(new Item.Properties().maxStackSize(1));
        this.isCreative = isCreative;
    }
}
