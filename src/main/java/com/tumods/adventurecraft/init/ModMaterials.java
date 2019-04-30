package com.tumods.adventurecraft.init;

import com.tumods.adventurecraft.Adventurecraft;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
    public static final Item.ToolMaterial TOOL_FLINT = EnumHelper.addToolMaterial(Adventurecraft.MODID + ":tool_flint", 1, 20, 1.5F, 1.0F, 5);
}
