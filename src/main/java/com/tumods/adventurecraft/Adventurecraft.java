package com.tumods.adventurecraft;

import com.tumods.adventurecraft.proxy.IProxy;
import com.tumods.adventurecraft.tabs.AdventurecraftItemTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Adventurecraft.MODID, name = Adventurecraft.NAME, version = Adventurecraft.VERSION, acceptedMinecraftVersions = Adventurecraft.MINECRAFT_VERSION)
public class Adventurecraft {
    public static final String MODID = "tuadventurecraft";
    public static final String NAME = "TU Adventurecraft";
    public static final String VERSION = "1.0.0";
    public static final String MINECRAFT_VERSION = "[1.12.2]";

    public static final Logger LOGGER = LogManager.getLogger(Adventurecraft.MODID);

    public static final String CLIENT = "com.tumods.adventurecraft.proxy.ClientProxy";
    public static final String SERVER = "com.tumods.adventurecraft.proxy.ServerProxy";

    public static final CreativeTabs ADVENTURECRAFT_TAB = new AdventurecraftItemTab();

    @SidedProxy(clientSide = Adventurecraft.CLIENT, serverSide = Adventurecraft.SERVER)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
