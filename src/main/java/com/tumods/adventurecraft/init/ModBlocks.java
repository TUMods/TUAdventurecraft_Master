package com.tumods.adventurecraft.init;

import com.tumods.adventurecraft.Adventurecraft;
import com.tumods.adventurecraft.objects.blocks.food.CropBlueberry;
import com.tumods.adventurecraft.objects.blocks.food.CropRaspberry;
import com.tumods.adventurecraft.objects.blocks.food.CropRye;
import com.tumods.adventurecraft.objects.blocks.metals.BlockCopper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Adventurecraft.MODID)
public class ModBlocks {
    // Metals
    public static final BlockCopper BLOCK_COPPER = new BlockCopper();

    // Crops
    public static final CropBlueberry CROP_BLUEBERRY = new CropBlueberry();
    public static final CropRaspberry CROP_RASPBERRY = new CropRaspberry();
    public static final CropRye CROP_RYE = new CropRye();
}
