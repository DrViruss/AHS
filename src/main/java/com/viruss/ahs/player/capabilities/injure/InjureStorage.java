package com.viruss.ahs.player.capabilities.injure;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class InjureStorage<IInjureCapability> implements Capability.IStorage<IInjureCapability> {


    @Nullable
    @Override
    public INBT writeNBT(Capability<IInjureCapability> capability, IInjureCapability instance, Direction side) {
        return null;
    }

    @Override
    public void readNBT(Capability<IInjureCapability> capability, IInjureCapability instance, Direction side, INBT nbt) {

    }
}
