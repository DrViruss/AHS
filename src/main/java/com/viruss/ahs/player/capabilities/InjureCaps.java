package com.viruss.ahs.player.capabilities;

import com.viruss.ahs.player.injures.AbstractInjure;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class InjureCaps {

    @CapabilityInject(IAbstractInjureCapability.class)
    public static final Capability<IAbstractInjureCapability> ABSTRACT_INJURE_CAPABILITY = null;


    /**
     * Capability Factory. Same for all caps
     */
    public static class InjureProvider implements ICapabilitySerializable<INBT>
    {
        private LazyOptional<IAbstractInjureCapability> ABSTRACT_INJURE_CAPABILITY_INSTANCE = LazyOptional.of(ABSTRACT_INJURE_CAPABILITY::getDefaultInstance);

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            if(cap == ABSTRACT_INJURE_CAPABILITY)
                return ABSTRACT_INJURE_CAPABILITY_INSTANCE.cast();
            else
                return LazyOptional.empty();
        }

        @Override
        public INBT serializeNBT() {
            return ABSTRACT_INJURE_CAPABILITY.getStorage().writeNBT(ABSTRACT_INJURE_CAPABILITY,this.ABSTRACT_INJURE_CAPABILITY_INSTANCE.orElseThrow(IllegalArgumentException::new),null);
        }

        @Override
        public void deserializeNBT(INBT nbt) {
            ABSTRACT_INJURE_CAPABILITY.getStorage().readNBT(ABSTRACT_INJURE_CAPABILITY,this.ABSTRACT_INJURE_CAPABILITY_INSTANCE.orElseThrow(IllegalArgumentException::new), null,nbt);
        }
    }

    /**
     * NOT A STORAGE! This is saver! Saves data in NBT and read them
     */
    public static class AbstractInjureStorage implements Capability.IStorage<IAbstractInjureCapability> {
        //fixit

        @Nullable
        @Override
        public INBT writeNBT(Capability<IAbstractInjureCapability> capability, IAbstractInjureCapability instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            ArrayList<AbstractInjure> entityInjures = instance.getData();

            nbt.putInt("size",entityInjures.size());
            System.out.println("size:" +entityInjures.size());
            for(int i=0; i<entityInjures.size();i++) {
                CompoundNBT injureData = new CompoundNBT();

                System.out.println("!WriteNBT method!\nType:" + entityInjures.get(i).getType().toString()+"\nDuration:"+entityInjures.get(i).getDuration());

                injureData.putString("type",entityInjures.get(i).getType().toString());
                injureData.putInt("duration",entityInjures.get(i).getDuration());
                nbt.put(String.valueOf(i), injureData);
            }
            return nbt;
        }

        @Override
        public void readNBT(Capability<IAbstractInjureCapability> capability, IAbstractInjureCapability instance, Direction side, INBT nbt) {
            CompoundNBT data = (CompoundNBT) nbt;
            int size = data.getInt("size");
            System.out.println("!ReadNBT method!\nSize:"+size);

                ArrayList<AbstractInjure> entityInjures = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    CompoundNBT _tmp = (CompoundNBT) data.get(String.valueOf(i));
                    String data1 = _tmp.getString("type");
                    int data2 = _tmp.getInt("duration");

                    System.out.println("!ReadNBT method!\nType:" + data1.toString()+"\nDuration:"+data2);

                    AbstractInjure injure = new AbstractInjure(AbstractInjure.Type.valueOf(data1), data2);
                    entityInjures.add(injure);
                }
                instance.setData(entityInjures);

        }
    }




    /**
     * Capability Class
     */
    public static class AbstractInjureCapability implements IAbstractInjureCapability {
        ArrayList<AbstractInjure> data = new ArrayList<>();

        @Override
        public ArrayList<AbstractInjure> getData() {
            return data;
        }

        @Override
        public void setData(ArrayList<AbstractInjure> data) {
            this.data = data;
        }

    }

}
