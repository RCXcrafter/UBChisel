package com.rcx.ubchisel.block;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import com.rcx.ubchisel.UBChisel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockNormalVariation extends Block
{

    HashMap<Integer, IIcon> icons = new HashMap<Integer, IIcon>();
    HashMap<Integer, String> rockNames = new HashMap<Integer, String>();
    String variationName;
    String setName;
    String defaultTexture = UBChisel.MODID + ":" + "default";

    public BlockNormalVariation(String variationName, String rockSet)
    {
        super(Material.iron);
        setHardness(1.0F);
        setResistance(1.0F);
        this.variationName = variationName;
        setName = rockSet;
        this.setCreativeTab(UBChisel.CREATIVE_TAB);
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }

    public void addRock(int meta, String name)
    {
        rockNames.put(meta, name);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (Entry<Integer, String> entry : rockNames.entrySet())
        {
            list.add(new ItemStack(this, 1, entry.getKey()));
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        for (Entry<Integer, String> entry : rockNames.entrySet())
        {
            String variationTexureName = setName.toLowerCase(Locale.US).replace(" ", "_") + "/";
            variationTexureName += entry.getValue().toLowerCase(Locale.US).replace(" ", "_");
            variationTexureName += "_" + variationName.toLowerCase(Locale.US).replace(" ", "_");

            IIcon registeredIcon = register.registerIcon(UBChisel.MODID + ":" + variationTexureName);

            icons.put(entry.getKey(), registeredIcon);
        }

        blockIcon = register.registerIcon(defaultTexture);
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        IIcon metaIcon = icons.get(meta);
        if (metaIcon == null) return blockIcon;

        return metaIcon;
    }

    @Override
    public String getUnlocalizedName()
    {
        String unlocalized = "tile.unknown." + setName.toLowerCase(Locale.US).replace(" ", ".");
        unlocalized += "." + variationName.toLowerCase(Locale.US).replace(" ", ".");
        return unlocalized;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        if (stack == null || stack.getItem() == null) return getUnlocalizedName();

        int meta = stack.getItemDamage();
        String name = rockNames.get(meta);

        if (name == null) return getUnlocalizedName() + "." + meta;

        String unlocalized = "tile." + UBChisel.MODID.toLowerCase(Locale.US);
        unlocalized += "." + name.toLowerCase(Locale.US).replace(" ", ".");
        unlocalized += "." + variationName.toLowerCase(Locale.US).replace(" ", ".");

        return unlocalized;
    }

    public String getRockName(ItemStack stack)
    {
        if (stack == null || stack.getItem() == null) return null;

        int meta = stack.getItemDamage();
        String name = rockNames.get(meta);

        return name;
    }

    public String getVariationName()
    {
        return variationName;
    }
}
