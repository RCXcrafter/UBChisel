package com.rcx.ubchisel;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class UBChiselItems
{
    public static Item TAB_ITEM;

    public static void init()
    {
        TAB_ITEM = new Item().setTextureName("ubchisel:tabicon").setUnlocalizedName("ubchisel.tab.item");

        GameRegistry.registerItem(TAB_ITEM, "tabitem");

    }
}
