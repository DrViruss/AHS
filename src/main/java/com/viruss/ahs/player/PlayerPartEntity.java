package com.viruss.ahs.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;

public class PlayerPartEntity  extends Entity {
    public final EntitySize size;
    public final PlayerPart part;
    public final PlayerEntity player;


    public enum PlayerPart{Head,LeftArm,RightArm,LeftLeg,RightLeg}


    public PlayerPartEntity(PlayerEntity player, PlayerPart part,float width,float height) {
        super(player.getType(), player.world);
        this.size = EntitySize.flexible(width,height);
        this.recalculateSize();
        this.part = part;
        this.player = player;
        this.forceSpawn = true;
    }



//Default

    protected void registerData() {

    }


    protected void readAdditional(CompoundNBT compound) {

    }

    protected void writeAdditional(CompoundNBT compound) {

    }


    public IPacket<?> createSpawnPacket() { throw new UnsupportedOperationException();}
}
