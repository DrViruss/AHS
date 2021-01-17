package com.viruss.ahs.player;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

//TODO: Make this thing ALIVE!

public class PlayerPartEntity  extends Entity {
    public final EntitySize size;
    public final PlayerPart part;
    public PlayerEntity player;

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }


    public enum PlayerPart{Head,LeftArm,RightArm,LeftLeg,RightLeg,Body}

    public PlayerPartEntity(PlayerEntity player, PlayerPart part,float width,float height) {
        super(player.getType(), player.world);
        this.size = EntitySize.flexible(width,height);
        this.recalculateSize();
        this.part = part;
        this.player = player;
        this.forceSpawn = true;
    }

    @Override
    public String toString() {
        return "PlayerPartEntity{" +
                "size=" + size +
                ", part=" + part +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
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
