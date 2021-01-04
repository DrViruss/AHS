package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.ItemBase;
import net.minecraft.item.Item;

public class Bandage extends ItemBase {
    boolean type; //true = normal   |   false = elastic

    public Bandage() {
        super(new Item.Properties().maxStackSize(16));
    }
}
