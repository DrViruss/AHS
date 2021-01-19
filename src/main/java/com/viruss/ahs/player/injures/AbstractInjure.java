package com.viruss.ahs.player.injures;

import java.util.ArrayList;

public class AbstractInjure implements IAbstractInjure{
    Type type;
    int duration = 0;

    public AbstractInjure(Type type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public void setDuration(int dur) {
        this.duration = dur;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AbstractInjure{" +
                "type=" + type +
                ", duration=" + duration +
                '}';
    }

    public enum Type{Broken,CutWound,PunctureWound,Laceration,Bleeding, Abrasion,Burns}
}
