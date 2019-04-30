package com.tumods.adventurecraft.objects.items.ingots;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.item.Item;

public class IngotNeodymium extends Item {
    private final String name = "ingot_neodymium";

    public IngotNeodymium() {
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }
}
