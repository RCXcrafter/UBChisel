package com.rcx.ubchisel;

import java.util.Locale;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.rcx.ubchisel.api.IRockSet;
import com.rcx.ubchisel.api.RockSet;
import com.rcx.ubchisel.api.UBChiselApi;
import com.rcx.ubchisel.block.BlockNormalVariation;
import com.rcx.ubchisel.block.BlockTransparentVariation;
import com.rcx.ubchisel.item.ItemBlockNormalVariation;

import cpw.mods.fml.common.registry.GameRegistry;

public class UBChiselBlocks
{

    private static final String[] variationNormalList = { "Cracked Bricks", "Chiseled", "Checkerboard", "Chaotic Bricks", "Large Bricks", "Panel", "Large Tiles", "Small Tiles", "Ornate Panel", "Ornate", "Small Bricks", "Prismatic", "Creeper Panel", "Pillar", "Lines" };
//    private static final String[] variationTransparentList = { "Frame", "Frame Crossed", "Grate", "Mesh", "Window" };

    public static void init()
    {
        createBlocks(variationNormalList, false);
//        createBlocks(variationTransparentList, true);
    }

    private static void createBlocks(String[] variationList)
    {
        String[] setNames = UBChiselApi.getSetNames();
        for (String setName : setNames)
        {
            if (setName.equalsIgnoreCase("utility") || setName.equalsIgnoreCase("vanilla")) continue;

            IRockSet rockSet = UBChiselApi.getRockSet(setName);
            String[] rockNames = rockSet.getRockNames();

            Block defaultBlock = rockSet.getDefaultBlock();
            
            boolean firstRun = true;

            for (String variation : variationList)
            {
                BlockNormalVariation variationBlock;

                //if (transparent) 
                //	variationBlock = new BlockTransparentVariation(variation, setName);
                //else 
                	variationBlock = new BlockNormalVariation(variation, setName);

                String blockName 	= setName.toLowerCase(Locale.US).replace(" ", "_") 
                					+ "_"
                					+ variation.toLowerCase(Locale.US).replace(" ", "_");

                GameRegistry.registerBlock(variationBlock, ItemBlockNormalVariation.class, blockName);

                for (String rockName : rockNames)
                {
                    ItemStack storageBlock = rockSet.getBlock(rockName);
                    if (storageBlock == null)
                        continue;

                    variationBlock.addRock(storageBlock.getItemDamage(), rockName);

                    String groupName = rockName.toLowerCase(Locale.US).trim().replace(" ", "_") + "_block";

                    if (firstRun) 
                    	CarvingUtils.chisel.addVariation(groupName, 
                    									defaultBlock, // block
                    									storageBlock.getItemDamage(), //metadata
                    									100);// order

                    CarvingUtils.chisel.addVariation(groupName, 
                    								 variationBlock, 
                    								 storageBlock.getItemDamage(), 
                    								 101 + storageBlock.getItemDamage());

                }

                firstRun = false;
            }

        }

    }
    
    
}// class UBChiselBlocks
