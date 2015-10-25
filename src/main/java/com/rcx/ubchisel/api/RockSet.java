package com.rcx.ubchisel.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class RockSet implements IRockSet
{
	private String mName;
	private double mMiningSpeed;
	private double mHardness;
	private double mBlastResistance;
	
	public String[]
		getRockNames()
	{
		String[] result= new String[mRockTypes.length];
		for (int cnt= 0; cnt<mRockTypes.length; cnt++)
			result[cnt]= mRockTypes[cnt].mName;
		
		return result;
	}

	public Block
		getDefaultBlock()
	{
		
	}
	
	public ItemStack
		getBlock(String rockName)
	{
		
		ItemStack result= new ItemStack(getDefaultBlock(),1,1);
				
		return result;
	}
	
    private class LocalRockType
    {
    	public String mType;
    	public String mName;
    	public double mMiningSpeed;
    	public double mHardness;
    	public double mBlastResistance;
    	
    	public LocalRockType(String type, String name, double miningSpeed, double hardness, double blastResistance)
    	{
    		mType			= type;
    		mName			= name;
    		mMiningSpeed	= miningSpeed;
    		mHardness		= hardness;
    		mBlastResistance= blastResistance;
    	}
    }
    
    private static LocalRockType[] mRockTypes=
	{
    	new LocalRockType("Igneous", "Red Granite", 150, 2.25, 40.5),
    	new LocalRockType("Igneous", "Black Granite", 140, 2.1, 39.3),
    	new LocalRockType("Igneous", "Rhyolite", 110, 1.65, 33.3),
    	new LocalRockType("Igneous", "Andesite", 120, 1.8, 36.0),
    	new LocalRockType("Igneous", "Gabbro", 80, 1.2, 21.0),
    	new LocalRockType("Igneous", "Basalt", 120, 1.8, 36.0),
    	new LocalRockType("Igneous", "Komatiite", 130, 1.95, 37.8),
    	new LocalRockType("Igneous", "Dacite", 100, 1.5, 30.0),
    	new LocalRockType("Metamorphic", "Gneiss", 110, 1.65, 33.3),
    	new LocalRockType("Metamorphic", "Eclogite", 100, 1.5, 30.0),
    	new LocalRockType("Metamorphic", "Marble", 110, 1.65, 33.3),
    	new LocalRockType("Metamorphic", "Quartzite", 130, 1.95, 37.8),
    	new LocalRockType("Metamorphic", "Blue Schist", 70, 1.05, 16.2),
    	new LocalRockType("Metamorphic", "Green Schist", 70, 1.05, 16.2),
    	new LocalRockType("Metamorphic", "Soapstone", 40, 0.6, 6.0),
    	new LocalRockType("Metamorphic", "Migmatite", 90, 1.35, 25.8),
    	new LocalRockType("Sedimentary", "Limestone", 50, 0.75, 8.7),
    	new LocalRockType("Sedimentary", "Chalk", 50, 0.75, 8.7),
    	new LocalRockType("Sedimentary", "Shale", 50, 0.75, 8.7),
    	new LocalRockType("Sedimentary", "Siltstone", 60, 0.9, 12.0),
    	new LocalRockType("Sedimentary", "Lignite", 50, 0.75, 8.7),
    	new LocalRockType("Sedimentary", "Dolomite", 50, 0.75, 8.7),
    	new LocalRockType("Sedimentary", "Greywacke", 100, 1.5, 30.0),
    	new LocalRockType("Sedimentary", "Chert", 90, 1.35, 25.8)
	};

};

