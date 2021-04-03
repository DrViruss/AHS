package com.viruss.ahs.player;

import com.viruss.ahs.TEST.PPE_Mother;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

//TODO: Make this thing ALIVE!

public class PlayerPartEntity  extends Entity {
    Entity parent;
    PartType type;

    public PlayerPartEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.parent = worldIn.getClosestPlayer(this,2);
        //try to spawn brother
    }

    public PlayerPartEntity(EntityType<?> entityTypeIn, World worldIn, Entity parent, PartType type) {
        super(entityTypeIn, worldIn);
        this.parent = parent;
        this.type = type;
    }

    /*~~~~~~~~~~~~~~~DW_TEST~~~~~~~~~~~~~~~~~~~~~~*/

    @Override
    public void tick() {
        collideWithNearbyEntities();
        if(this.parent == null) {
            this.setParent(this.world.getClosestPlayer(this, 2));
            System.out.println("NULL");
        }
        else {
            if(!this.parent.isAlive()) {
                this.onKillCommand();
                this.remove();
            }

//            this.setPosition(this.getParent().getPosX(),this.getParent().getPosY(),this.getParent().getPosZ());

            //No! Now you are my poppet!
            LOGGER.trace("OLD pos:\n"+"x:"+this.getPosX()+"\ny:"+this.getPosY()+"\nz:"+this.getPosZ());
            this.setPosition(this.getPosX()+1,this.getPosY(),this.getPosZ());
            LOGGER.trace("OLD pos:\n"+"x:"+this.getPosX()+"\ny:"+this.getPosY()+"\nz:"+this.getPosZ());

            this.getParent().setPosition(this.getPosX(),this.getPosY(),this.getPosZ());
        }

        PPE_Mother.bb = this.getBoundingBox();
        super.tick();
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
//        if(source.getTrueSource() instanceof PlayerEntity)
        System.out.println("PPE gets damage from "+source.getTrueSource().getName().toString());
        this.parent.attackEntityFrom(source,amount);

        return super.attackEntityFrom(source, amount);
    }



    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    @Override
    public boolean isEntityEqual(Entity entity) {
        return this == entity || this.getParent() == entity;
    }
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    public void collideWithNearbyEntities() {
        List<Entity> entities = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getBoundingBox().expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        Entity parent = this.getParent();
        if(parent != null){
            entities.stream().filter(entity -> entity != parent && !(entity instanceof PlayerPartEntity) && entity.canBePushed()).forEach(entity -> entity.applyEntityCollision(parent));

        }
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return super.getBoundingBox();
    }

    @Override
    protected void doWaterSplashEffect() {

    }

    @Override
    public Entity getEntity() {
        return this;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source == DamageSource.FALL || source == DamageSource.DROWN || source == DamageSource.FALLING_BLOCK || source == DamageSource.LAVA || source.isFireDamage() || super.isInvulnerableTo(source);
    }






        /*GetSet*/


    public Entity getParent() {
        return parent;
    }

    public void setParent(Entity parent) {
        this.parent = parent;
    }

    public PartType getPartType() {
        return type;
    }

    public void setPartType(PartType type) {
        this.type = type;
    }

    @Override
    protected void registerData() {

    }




            /*Misc*/


    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }

    @Override
    public String toString() {
        return "PlayerPartEntity{" +
                "parent=" + parent +
                ", type=" + type +
                '}';
    }

    public enum PartType{Head,LeftArm,RightArm,LeftLeg,RightLeg,Body}
}
