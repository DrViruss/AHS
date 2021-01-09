package com.viruss.ahs.player.capabilities.TEST;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TestCaProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(ITestCap.class)
    public static final Capability<ITestCap> TEST_BLOCKPOS_CAP = null;

    private LazyOptional<ITestCap> instance = LazyOptional.of(TEST_BLOCKPOS_CAP::getDefaultInstance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == TEST_BLOCKPOS_CAP ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return TEST_BLOCKPOS_CAP.getStorage().writeNBT(TEST_BLOCKPOS_CAP, this.instance.orElseThrow(()->new IllegalArgumentException()), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        TEST_BLOCKPOS_CAP.getStorage().readNBT(TEST_BLOCKPOS_CAP,this.instance.orElseThrow(()->new IllegalArgumentException()), null,nbt);
    }

    public static class TestCapStorage implements Capability.IStorage<ITestCap> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<ITestCap> capability, ITestCap instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            return NBTUtil.writeBlockPos(instance.getPos());
        }

        @Override
        public void readNBT(Capability<ITestCap> capability, ITestCap instance, Direction side, INBT nbt) {
            instance.setPos(NBTUtil.readBlockPos((CompoundNBT) nbt));
        }
    }

    public static class TestCap implements ITestCap {

        private BlockPos pos;

        public TestCap(){
            pos = BlockPos.ZERO;
        }

        @Override
        public BlockPos getPos() {
            return pos;
        }

        @Override
        public void setPos(BlockPos pos) {
            this.pos = pos;
        }
    }


}
