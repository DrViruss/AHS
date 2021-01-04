package com.viruss.ahs.items.bases;

import com.viruss.ahs.AHS;

import net.minecraft.item.Item;

public class ItemBase extends Item
{

	public ItemBase() 
	{
		super(new Item.Properties().group(AHS.AHS_Tab));
	}
	public ItemBase(Item.Properties properties){super(properties.group(AHS.AHS_Tab));}

}
