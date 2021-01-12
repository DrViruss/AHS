package com.viruss.ahs.player.capabilities;

import com.viruss.ahs.player.injures.AbstractInjure;

import java.util.ArrayList;

/**
 * CababilityInterface
 */
public interface IAbstractInjureCapability {

   ArrayList<AbstractInjure> getData();
   void setData(ArrayList<AbstractInjure> data);
}
