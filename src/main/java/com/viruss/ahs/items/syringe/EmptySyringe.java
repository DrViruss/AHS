package com.viruss.ahs.items.syringe;

import com.viruss.ahs.items.bases.ItemBase;

public class EmptySyringe extends ItemBase {

    public EmptySyringe() {
            super(new Properties().maxStackSize(16));
    }

    public EmptySyringe( Properties properties) {
        super(properties);
    }
}
