package com.tumods.adventurecraft;

import com.tumods.adventurecraft.init.ModBlocks;
import com.tumods.adventurecraft.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Adventurecraft.MODID, value = Side.CLIENT)
public class ClientEventSubscriber {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        // ITEMS
        // Ingots
        registerModel(ModItems.INGOT_COPPER);
        registerModel(ModItems.INGOT_NEODYMIUM);
        registerModel(ModItems.INGOT_SILVER);
        registerModel(ModItems.INGOT_TIN);
        // Bloom
        registerModel(ModItems.BLOOM_COPPER);
        registerModel(ModItems.BLOOM_TIN);
        // Tools
        registerModel(ModItems.KNIFE_FLINT);
        registerModel(ModItems.HATCHET_FLINT);
        registerModel(ModItems.HOSHICK_FLINT);
        // Produce
        registerModel(ModItems.PRODUCE_BLUEBERRY);

        // BLOCKS
        // Metals
        registerModel(Item.getItemFromBlock(ModBlocks.BLOCK_COPPER));
        // Crops
        registerModel(Item.getItemFromBlock(ModBlocks.CROP_BLUEBERRY));
    }

    private static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
