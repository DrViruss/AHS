package com.viruss.ahs.player;

import java.util.ArrayList;

public class BloodGroup {
    public static final java.lang.String BloodGroupTagKey = "BloodGroup";

    Type type;
    boolean positive = false;

    public BloodGroup(Type type, boolean positive) {
        this.type = type;
        this.positive = positive;
    }

    public BloodGroup(int type) {
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

    public BloodGroup(String type) {
        this.type = Type.valueOf(type.substring(0,type.length()-1));
        this.positive = type.charAt(type.length()-1) == '+';
    }

    public Type getType() {
        return type;
    }

    public boolean isPositive() {
        return positive;
    }

    public enum Type{A,B,AB,O}

    public static ArrayList<BloodGroup> getSuitableGroups(BloodGroup type)
    {
        ArrayList<BloodGroup> result = new ArrayList<>();
//        if(type.type == Type.A)

//        switch (type.type)
//        {
        if(type.type == Type.A)
                if (type.positive) {
                    result.add(new BloodGroup(Type.A, true));
                    result.add(new BloodGroup(Type.A, false));
                    result.add(new BloodGroup(Type.O, true));
                    result.add(new BloodGroup(Type.O, false));
                }
                else
                {
                    result.add(new BloodGroup(Type.A, false));
                    result.add(new BloodGroup(Type.O, false));
                }
        if(type.type == Type.B)
                if (type.positive) {
                    result.add(new BloodGroup(Type.B, true));
                    result.add(new BloodGroup(Type.B, false));
                    result.add(new BloodGroup(Type.O, true));
                    result.add(new BloodGroup(Type.O, false));
                }
                else
                {
                    result.add(new BloodGroup(Type.B, false));
                    result.add(new BloodGroup(Type.O, false));
                }

        if(type.type == Type.AB)
                if (type.positive) {
                    for(Type typeE : Type.values()) {
                        result.add(new BloodGroup(typeE, true));
                        result.add(new BloodGroup(typeE, false));
                    }

                }
                else
                {
                    for(Type typeE : Type.values())
                        result.add(new BloodGroup(typeE, false));
                }

        if(type.type == Type.O)
                if (type.positive) {
                    result.add(new BloodGroup(Type.O, true));
                    result.add(new BloodGroup(Type.O, false));
                }
                else
                {
                    result.add(new BloodGroup(Type.O, false));
                }
//        }
        System.out.println("\n Given group:"+type+"\n Suitable BGs:"+result.toString());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodGroup bloodGroup = (BloodGroup) o;
        return positive == bloodGroup.positive && type == bloodGroup.type;
    }

}
