package com.rcx.ubchisel;

import net.minecraft.creativetab.CreativeTabs;

import com.rcx.ubchisel.proxy.IProxy;
import com.rcx.ubchisel.utils.Log;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = UBChisel.MODID, version = UBChisel.VERSION, dependencies = UBChisel.DEPS)
public class UBChisel
{
    public static final String MODID = "metallurgychisel";
    public static final String VERSION = "%version%";
    public static final String DEPS = "required-after:Metallurgy;required-after:chisel";

    @Instance(MODID)
    public static UBChisel instance;

    @SidedProxy(modId = UBChisel.MODID, clientSide = "com.rcx.ubchisel.proxy.ClientProxy", serverSide = "com.rcx.ubchisel.proxy.CommonProxy")
    public static IProxy proxy;

    public static CreativeTabs CREATIVE_TAB;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        Log.setLogger(event.getModLog());
        CREATIVE_TAB = new UBChiselTab();
        UBChiselItems.init();
        UBChiselBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }
}
