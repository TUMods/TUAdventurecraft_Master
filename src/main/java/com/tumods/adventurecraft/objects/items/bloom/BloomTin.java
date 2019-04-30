package com.tumods.adventurecraft.objects.items.bloom;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.item.Item;

public class BloomTin extends Item {
    private final String name = "bloom_tin";

    public BloomTin() {
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }
}
