package com.rcx.ubchisel.api;

import java.lang.reflect.Method;

public class UBChiselApi
{
	private static Class<?> blockList;
    private static Method getSet;
    private static Method getDefaultSets;
    private static String[] setNames = { "igneous", "metamorphic", "sedimentary" };

    public static IRockSet getRockSet(String setName)
    {
    	IRockSet rockSet = null;

        if (blockList == null)
        {
            try
            {
                String blockListClass = "com.rcx.ubchisel.BlockList";
                blockList = Class.forName(blockListClass);
            }
            catch (Exception e)
            {
                //MetallurgyApiLogger.warn("Error while retrieving BlockList: " + e.getLocalizedMessage());
            }
        }

        if (getSet == null)
        {
            try
            {
                getSet = blockList.getDeclaredMethod("getSet", String.class);
            }
            catch (Exception e)
            {
                //MetallurgyApiLogger.warn("Error while retrieving getSet: " + e.getLocalizedMessage());
            }
        }

        try
        {
            rockSet = (IRockSet) getSet.invoke(null, setName);
        }
        catch (Exception e)
        {
            //MetallurgyApiLogger.warn("Error while invoking getSet: " + e.getLocalizedMessage());
        }

        return rockSet;
    }

    public static String[] getSetNames()
    {
        String[] setNames = null;

        if (blockList == null)
        {
            try
            {
                String blockListClass = "com.rcx.ubchisel.BlockList";
                blockList = Class.forName(blockListClass);
            }
            catch (Exception e)
            {
                //MetallurgyApiLogger.warn("Error while retrieving BlockList: " + e.getLocalizedMessage());
            }
        }

        if (getSet == null)
        {
            try
            {
                getDefaultSets = blockList.getDeclaredMethod("getDefaultSetNames");
            }
            catch (Exception e)
            {
                //MetallurgyApiLogger.warn("Error while retrieving getDefaultSetNames: " + e.getLocalizedMessage());
            }
        }

        try
        {
            setNames = (String[]) getDefaultSets.invoke(null);
        }
        catch (Exception e)
        {
            ///MetallurgyApiLogger.warn("Error while invoking getDefaultSetNames: " + e.getLocalizedMessage());
        }

        return setNames;
    }
}
