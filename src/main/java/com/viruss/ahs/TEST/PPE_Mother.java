package com.viruss.ahs.TEST;

import com.viruss.ahs.player.PlayerPartEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;


public class PPE_Mother extends Entity {
    Entity son;
    int step=0;
    public static AxisAlignedBB bb;

    @Override
    public void tick() {
    if(son == null)
        this.setSon(world.getLoadedEntitiesWithinAABB(PlayerPartEntity.class,bb).get(0));
        else
        {
            if(step ==90)
                step =0;

            if(step >= 0 && step <30)
            {
                step++;
                this.setPosition(this.getPosX()+1,this.getPosY(),this.getPosZ());
            }
            else if(step >=30 && step < 60)
            {
                step--;
            }
            else if(step >= 60 && step < 90)
            {
                step++;
                this.setPosition(this.getPosX()-1,this.getPosY(),this.getPosZ());
            }
            this.son.setPosition(this.getPosX(),this.getPosY(),this.getPosZ());
        }
    }

    public PPE_Mother(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Override
    protected void registerData() {

    }


    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void setSon(Entity son) {
        this.son = son;
    }
}
