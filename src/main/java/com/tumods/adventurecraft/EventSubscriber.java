package com.tumods.adventurecraft;

import com.tumods.adventurecraft.init.ModBlocks;
import com.tumods.adventurecraft.init.ModMaterials;
import com.tumods.adventurecraft.objects.blocks.food.CropBlueberry;
import com.tumods.adventurecraft.objects.blocks.metals.BlockCopper;
import com.tumods.adventurecraft.objects.items.bloom.BloomCopper;
import com.tumods.adventurecraft.objects.items.bloom.BloomTin;
import com.tumods.adventurecraft.objects.items.food.ProduceBlueberry;
import com.tumods.adventurecraft.objects.items.ingots.IngotCopper;
import com.tumods.adventurecraft.objects.items.ingots.IngotNeodymium;
import com.tumods.adventurecraft.objects.items.ingots.IngotSilver;
import com.tumods.adventurecraft.objects.items.ingots.IngotTin;
import com.tumods.adventurecraft.objects.items.tools.ToolHatchet;
import com.tumods.adventurecraft.objects.items.tools.ToolHoshick;
import com.tumods.adventurecraft.objects.items.tools.ToolKnife;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Adventurecraft.MODID)
public class EventSubscriber {
    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        final Block[] blocks = {
                // Metals
                new BlockCopper(),
                // Crops
                new CropBlueberry()
        };

        event.getRegistry().registerAll(blocks);
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        final Item[] items = {
                // Ingots
                new IngotCopper(),
                new IngotNeodymium(),
                new IngotSilver(),
                new IngotTin(),
                // Bloom
                new BloomCopper(),
                new BloomTin(),
                // Tools
                new ToolKnife("knife_flint", ModMaterials.TOOL_FLINT),
                new ToolHatchet("hatchet_flint", ModMaterials.TOOL_FLINT, 4.0f, -3.1f),
                new ToolHoshick("hoshick_flint", ModMaterials.TOOL_FLINT),
                // Food
                new ProduceBlueberry(1, 3, false)
        };

        final Item[] itemBlocks = {
                // Metals
                new ItemBlock(ModBlocks.BLOCK_COPPER).setRegistryName(ModBlocks.BLOCK_COPPER.getRegistryName()),
                // Crops
                new ItemBlock(ModBlocks.CROP_BLUEBERRY).setRegistryName(ModBlocks.CROP_BLUEBERRY.getRegistryName())
        };

        event.getRegistry().registerAll(items);
        event.getRegistry().registerAll(itemBlocks);
    }
}
