package com.rcx.ubchisel.item;

import java.util.Locale;

import com.rcx.ubchisel.UBChisel;
import com.rcx.ubchisel.block.BlockNormalVariation;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockNormalVariation extends ItemBlock
{

    public ItemBlockNormalVariation(Block block)
    {
        super(block);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return ((BlockNormalVariation) field_150939_a).getUnlocalizedName(stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {

        if (stack == null || stack.getItem() == null) return super.getItemStackDisplayName(stack);

        String fullUnlocalizedName = getUnlocalizedName(stack);

        if (StatCollector.canTranslate(fullUnlocalizedName)) return (StatCollector.translateToLocal(fullUnlocalizedName) + ".name").trim();

        BlockNormalVariation variantBlock = (BlockNormalVariation) Block.getBlockFromItem(stack.getItem());

        String unlocalizedVariant = "variation." + UBChisel.MODID.toLowerCase(Locale.US);
        unlocalizedVariant += "." + variantBlock.getVariationName().toLowerCase(Locale.US).replace(" ", ".");

        String unlocalizedRockName = "rock." + UBChisel.MODID.toLowerCase(Locale.US);
        unlocalizedRockName += "." + variantBlock.getRockName(stack).toLowerCase(Locale.US).replace(" ", ".");

        if (!StatCollector.canTranslate(unlocalizedVariant) || !StatCollector.canTranslate(unlocalizedRockName)) return super.getItemStackDisplayName(stack);

        String rockName = StatCollector.translateToLocal(unlocalizedRockName).trim();

        return StatCollector.translateToLocalFormatted(unlocalizedVariant, rockName).trim();

    }
}
