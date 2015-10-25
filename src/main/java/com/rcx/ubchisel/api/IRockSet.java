package com.rcx.ubchisel.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public interface IRockSet 
{
	public String[]	getRockNames();
	public Block 	getDefaultBlock();
	ItemStack		getBlock(String name);
}
