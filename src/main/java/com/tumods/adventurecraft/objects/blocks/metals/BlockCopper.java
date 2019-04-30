package com.tumods.adventurecraft.objects.blocks.metals;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCopper extends Block {
    private final String name = "block_copper";

    public BlockCopper() {
        super(Material.IRON);
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setSoundType(SoundType.METAL);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }
}
