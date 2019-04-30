package com.tumods.adventurecraft.objects.items.tools;

import com.tumods.adventurecraft.Adventurecraft;
import com.tumods.adventurecraft.util.ChatColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ToolHatchet extends ItemAxe {
    public ToolHatchet(String name, ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
    }

    public ToolHatchet(String name, ToolMaterial material) {
        this(name, material, 7.0f, -3.1f);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        // Add information about durability when shift is pressed
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            int maxHealth = getMaxDamage(stack);
            int currentHealth = maxHealth - (int)(this.getDurabilityForDisplay(stack) * maxHealth);
            double healthPercent = (currentHealth / (double)maxHealth);

            String colorFormat = (healthPercent > 0.5) ? ChatColor.DARK_GREEN.valueOf() : ((healthPercent > 0.25) ? ChatColor.YELLOW.valueOf() : ChatColor.DARK_RED.valueOf());

            tooltip.add("Durability: " + colorFormat + currentHealth + ChatColor.GRAY.valueOf() + "/" + maxHealth);
        } else {
            tooltip.add("Hold " + ChatColor.DARK_AQUA.valueOf() + "Shift" + ChatColor.GRAY.valueOf() + " for more information");
        }
    }
}
