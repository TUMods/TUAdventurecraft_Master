package com.tumods.adventurecraft.objects.items.ingots;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.item.Item;

public class IngotCopper extends Item {
    private final String name = "ingot_copper";

    public IngotCopper() {
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }
}
