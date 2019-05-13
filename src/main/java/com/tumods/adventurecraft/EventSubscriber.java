package com.tumods.adventurecraft;

import com.tumods.adventurecraft.init.ModBlocks;
import com.tumods.adventurecraft.init.ModItems;
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
                ModBlocks.BLOCK_COPPER,
                // Crops
                ModBlocks.CROP_BLUEBERRY,
                ModBlocks.CROP_RASPBERRY,
                ModBlocks.CROP_RYE
        };

        event.getRegistry().registerAll(blocks);
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        final Item[] items = {
                // Ingots
                ModItems.INGOT_COPPER,
                ModItems.INGOT_NEODYMIUM,
                ModItems.INGOT_SILVER,
                ModItems.INGOT_TIN,
                // Bloom
                ModItems.BLOOM_COPPER,
                ModItems.BLOOM_TIN,
                // Tools
                ModItems.KNIFE_FLINT,
                ModItems.HATCHET_FLINT,
                ModItems.HOSHICK_FLINT,
                // Food
                ModItems.PRODUCE_BLUEBERRY,
                ModItems.PRODUCE_RASPBERRY,
                ModItems.PRODUCE_RYE
        };

        final Item[] itemBlocks = {
                // Metals
                new ItemBlock(ModBlocks.BLOCK_COPPER).setRegistryName(ModBlocks.BLOCK_COPPER.getRegistryName()),
                // Crops
                new ItemBlock(ModBlocks.CROP_BLUEBERRY).setRegistryName(ModBlocks.CROP_BLUEBERRY.getRegistryName()),
                new ItemBlock(ModBlocks.CROP_RASPBERRY).setRegistryName(ModBlocks.CROP_RASPBERRY.getRegistryName()),
                new ItemBlock(ModBlocks.CROP_RYE).setRegistryName(ModBlocks.CROP_RYE.getRegistryName())
        };

        event.getRegistry().registerAll(items);
        event.getRegistry().registerAll(itemBlocks);
    }
}
