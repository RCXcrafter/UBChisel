package com.rcx.ubchisel.proxy;

import com.rcx.ubchisel.client.render.AllSideBlockRenderer;
import com.rcx.ubchisel.utils.RenderType;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void init()
    {
        super.init();

        RenderType.allSideBlockRenderId = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(new AllSideBlockRenderer());
    }
}
