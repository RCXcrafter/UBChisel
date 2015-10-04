package com.rcx.ubchisel.nei;

import net.minecraft.item.ItemStack;

import com.rcx.ubchisel.UBChiselItems;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIUBChiselConfig implements IConfigureNEI
{

    @Override
    public void loadConfig()
    {
        API.hideItem(new ItemStack(UBChiselItems.TAB_ITEM));
    }

    @Override
    public String getName()
    {
        return "UBChisel NEI";
    }

    @Override
    public String getVersion()
    {
        return "0.1.0";
    }

}
