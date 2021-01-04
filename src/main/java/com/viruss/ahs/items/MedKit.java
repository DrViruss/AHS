package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.ItemBase;
import net.minecraft.item.Item;

public class MedKit extends ItemBase {
    boolean type; //true = normal   |   false = creative

    public MedKit() {
        super(new Item.Properties().maxStackSize(1));
    }
}
