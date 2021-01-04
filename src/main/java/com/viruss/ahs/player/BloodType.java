package com.viruss.ahs.player;

public class BloodType {
    Type type;
    boolean positive;

    public BloodType(Type type, boolean positive) {
        this.type = type;
        this.positive = positive;
    }

    public enum Type{A,B,AB,O}
}
