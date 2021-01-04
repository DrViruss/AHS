package com.viruss.ahs.items.bases;

import java.util.List;

import javax.annotation.Nullable;

import com.viruss.ahs.AHS;
import com.viruss.ahs.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CustomItem extends Item
{

	public CustomItem() 
	{
		super(new Item.Properties().group(AHS.AHS_Tab));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if (KeyboardHelper.isHoldingShift()) 
		{
			tooltip.add(new StringTextComponent("Test Information"));
		} 
		else 
		{
			tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " Shift " + "\u00A77" + "for more information!"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, (10*20), 255));
		worldIn.setRainStrength(1.0f);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		player.dropItem(stack, true);
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	
	
}
