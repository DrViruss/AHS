package com.viruss.ahs.player.capabilities;

import com.viruss.ahs.player.injures.AbstractInjure;

import java.util.ArrayList;

/**
 * CababilityInterface
 */
public interface IAbstractInjureCapability {

   ArrayList<AbstractInjure> getData();
   void setData(ArrayList<AbstractInjure> data);

   default AbstractInjure getOrCreate(ArrayList<AbstractInjure> arr, AbstractInjure.Type type) {
      for(AbstractInjure injure : arr)
         if(injure.getType() == type)
            return injure;
      arr.add(new AbstractInjure(type,0));
      return arr.get(arr.size()-1);
   }
}
