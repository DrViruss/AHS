package com.viruss.ahs.items;

import com.viruss.ahs.items.bases.ItemBase;

//TODO: Complete this!
public class Syringe extends ItemBase {
    public Fluid fluid;

    public Syringe() {
        super(new Properties().maxStackSize(16));
    }

    public enum Fluid{EMPTY,Z_MIXTURE,ADRENALINE,MORPHINE}
}
