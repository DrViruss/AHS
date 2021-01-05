package com.viruss.ahs.items.bases;

import com.viruss.ahs.AHS;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class PillsBase extends Item {


    public PillsBase(Effect effect, int duration, float probability)
    {
        super(new Item.Properties().group(AHS.AHS_Tab).food(new Food.Builder().hunger(0).saturation(0).effect(new EffectInstance(effect, duration, 0), probability).build()));
    }
    public PillsBase(Item.Properties properties){super(properties.group(AHS.AHS_Tab));}
}
