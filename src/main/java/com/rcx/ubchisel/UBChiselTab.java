package com.rcx.ubchisel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UBChiselTab extends CreativeTabs
{

    public UBChiselTab()
    {
        super("ubchisel.tab");
    }

    @Override
    public Item getTabIconItem()
    {
        return UBChiselItems.TAB_ITEM;
    }

}
