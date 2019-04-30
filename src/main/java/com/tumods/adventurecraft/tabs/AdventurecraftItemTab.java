package com.tumods.adventurecraft.tabs;

import com.tumods.adventurecraft.Adventurecraft;
import com.tumods.adventurecraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdventurecraftItemTab extends CreativeTabs {
    public AdventurecraftItemTab() {
        super(Adventurecraft.MODID);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.INGOT_COPPER);
    }
}
