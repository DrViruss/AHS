package com.viruss.ahs.player.damage;

import net.minecraft.util.DamageSource;

//TODO: ADD NEW DAMAGE SOURCES
public class DamageSources {
    public static final DamageSource OUT_OF_BLOOD = new DamageSource("outOfBlood").setDamageBypassesArmor().setDamageIsAbsolute();
    public static final DamageSource EXPERIMENT = new DamageSource("Experiment").setDamageBypassesArmor().setDamageIsAbsolute();
    
}
