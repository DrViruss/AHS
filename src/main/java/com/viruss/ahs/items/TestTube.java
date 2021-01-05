package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.ItemBase;
import net.minecraft.item.Item;

public class TestTube extends ItemBase {
    TubeType type;

    //TODO: Complete this!
    public TestTube() {
        super(new Item.Properties().maxStackSize(16));
    }
    public static enum TubeType{EMPTY,SALIVA,VACCINE}
}
