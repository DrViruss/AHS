package com.viruss.ahs.player;

import java.util.ArrayList;

public class BloodType {
    Type type;
    boolean positive = false;

    public BloodType(Type type, boolean positive) {
        this.type = type;
        this.positive = positive;
    }

    public BloodType(int type) {
        if(type<4)
            this.positive = true;

       if(type == 0 | type == 4 )
           this.type = Type.A;
       else if(type == 1 | type == 5)
           this.type = Type.B;
       else if(type == 2 | type == 6)
           this.type = Type.AB;
       else if(type == 3 | type == 7)
           this.type = Type.O;

    }

    public Type getType() {
        return type;
    }

    public boolean isPositive() {
        return positive;
    }

    public enum Type{A,B,AB,O}

    public static ArrayList<BloodType> getSuitableGroups(BloodType type)
    {
        ArrayList<BloodType> result = new ArrayList<>();

        switch (type.type)
        {
            case A:
                if (type.positive) {
                    result.add(new BloodType(Type.A, true));
                    result.add(new BloodType(Type.A, false));
                    result.add(new BloodType(Type.O, true));
                    result.add(new BloodType(Type.O, false));
                }
                else
                {
                    result.add(new BloodType(Type.A, false));
                    result.add(new BloodType(Type.O, false));
                }
            case B:
                if (type.positive) {
                    result.add(new BloodType(Type.B, true));
                    result.add(new BloodType(Type.B, false));
                    result.add(new BloodType(Type.O, true));
                    result.add(new BloodType(Type.O, false));
                }
                else
                {
                    result.add(new BloodType(Type.B, false));
                    result.add(new BloodType(Type.O, false));
                }

            case AB:
                if (type.positive) {
                    for(Type typeE : Type.values()) {
                        result.add(new BloodType(typeE, true));
                        result.add(new BloodType(typeE, false));
                    }

                }
                else
                {
                    for(Type typeE : Type.values())
                        result.add(new BloodType(typeE, false));
                }

            case O:
                if (type.positive) {
                    result.add(new BloodType(Type.O, true));
                    result.add(new BloodType(Type.O, false));
                }
                else
                {
                    result.add(new BloodType(Type.O, false));
                }
        }
        return result;
    }

    @Override
    public String toString() {
        String result= this.getType().name();

        if(this.isPositive())
            result += "+";
        else
            result += "-";

        return result;
    }
}
