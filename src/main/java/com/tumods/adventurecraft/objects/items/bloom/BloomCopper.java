package com.tumods.adventurecraft.objects.items.bloom;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BloomCopper extends Item {
    private final String name = "bloom_copper";

    public BloomCopper() {
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }

}
