package com.tumods.adventurecraft.objects.blocks.food;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;

public class CropRye extends BlockCrops implements IGrowable {
    public static final PropertyInteger RYE_AGE = PropertyInteger.create("age", 0, 7);

    private static final AxisAlignedBB[] RYE_AABB = new AxisAlignedBB[] {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), // STAGE 0
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),  // STAGE 1
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), // STAGE 2
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),   // STAGE 3
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), // STAGE 4
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D),  // STAGE 5
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), // STAGE 6
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)    // STAGE 7
    };

    private final String name = "crop_rye";

    public CropRye() {
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }


}
