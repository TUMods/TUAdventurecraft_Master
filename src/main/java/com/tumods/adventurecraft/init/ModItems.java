package com.tumods.adventurecraft.init;

import com.tumods.adventurecraft.Adventurecraft;
import com.tumods.adventurecraft.objects.items.bloom.BloomCopper;
import com.tumods.adventurecraft.objects.items.bloom.BloomTin;
import com.tumods.adventurecraft.objects.items.food.ProduceBlueberry;
import com.tumods.adventurecraft.objects.items.food.ProduceRaspberry;
import com.tumods.adventurecraft.objects.items.food.ProduceRye;
import com.tumods.adventurecraft.objects.items.ingots.IngotCopper;
import com.tumods.adventurecraft.objects.items.ingots.IngotNeodymium;
import com.tumods.adventurecraft.objects.items.ingots.IngotSilver;
import com.tumods.adventurecraft.objects.items.ingots.IngotTin;
import com.tumods.adventurecraft.objects.items.tools.ToolHatchet;
import com.tumods.adventurecraft.objects.items.tools.ToolHoshick;
import com.tumods.adventurecraft.objects.items.tools.ToolKnife;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Adventurecraft.MODID)
public class ModItems {
    // Ingots
    public static final IngotCopper INGOT_COPPER = new IngotCopper();
    public static final IngotNeodymium INGOT_NEODYMIUM = new IngotNeodymium();
    public static final IngotSilver INGOT_SILVER = new IngotSilver();
    public static final IngotTin INGOT_TIN = new IngotTin();

    // Bloom
    public static final BloomCopper BLOOM_COPPER = new BloomCopper();
    public static final BloomTin BLOOM_TIN = new BloomTin();

    // Tools
    public static final ToolKnife KNIFE_FLINT = new ToolKnife("knife_flint", ModMaterials.TOOL_FLINT);
    public static final ToolHatchet HATCHET_FLINT = new ToolHatchet("hatchet_flint", ModMaterials.TOOL_FLINT, 4.0f, -3.1f);
    public static final ToolHoshick HOSHICK_FLINT = new ToolHoshick("hoshick_flint", ModMaterials.TOOL_FLINT);

    // Food
    public static final ProduceBlueberry PRODUCE_BLUEBERRY = new ProduceBlueberry(1, 3, false);
    public static final ProduceRaspberry PRODUCE_RASPBERRY = new ProduceRaspberry(1,3,false);
    public static final ProduceRye PRODUCE_RYE = new ProduceRye();
}
