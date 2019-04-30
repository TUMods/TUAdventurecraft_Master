package com.tumods.adventurecraft.objects.items.tools;

import com.tumods.adventurecraft.Adventurecraft;
import com.tumods.adventurecraft.util.ChatColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ToolHoshick extends ItemPickaxe {
    public ToolHoshick(String name, ToolMaterial material) {
        super(material);
        setCreativeTab(Adventurecraft.ADVENTURECRAFT_TAB);
        setRegistryName(name);
        setUnlocalizedName(Adventurecraft.MODID + "." + name);
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
            tooltip.add("");
            tooltip.add(ChatColor.GOLD.valueOf() + "Left Click " + ChatColor.GRAY.valueOf() + "to dig or mine");
            tooltip.add(ChatColor.GOLD.valueOf() + "Right Click " + ChatColor.GRAY.valueOf() + "to till the soil");
            tooltip.add(ChatColor.GOLD.valueOf() + "Shift + Right Click " + ChatColor.GRAY.valueOf() + "to dig a path");
        } else {
            tooltip.add("Hold " + ChatColor.DARK_AQUA.valueOf() + "Shift" + ChatColor.GRAY.valueOf() + " for more information");
        }
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        Material material = blockIn.getMaterial();
        Block block = blockIn.getBlock();

        if (material == Material.ROCK || material == Material.GROUND || material == Material.SAND || material == Material.SNOW
            || material == Material.CLAY || block == Blocks.SNOW_LAYER) {
            return true;
        }

        return false;
    }

    // Till the soil
    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);

        if (!worldIn.isRemote) {
            worldIn.setBlockState(pos, state, 11);
            stack.damageItem(1, player);
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        boolean doPathDig = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(itemstack, player, worldIn, pos);
            if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up())) {
                if (block == Blocks.GRASS || block == Blocks.GRASS_PATH) {
                    if (!doPathDig)
                        this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                    else
                        this.setBlock(itemstack, player, worldIn, pos, Blocks.GRASS_PATH.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }

                if (block == Blocks.DIRT) {
                    switch (iblockstate.getValue(BlockDirt.VARIANT)) {
                        case DIRT:
                            if (!doPathDig)
                                this.setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                            else
                                this.setBlock(itemstack, player, worldIn, pos, Blocks.GRASS_PATH.getDefaultState());
                            return EnumActionResult.SUCCESS;
                        case COARSE_DIRT:
                            this.setBlock(itemstack, player, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                            return EnumActionResult.SUCCESS;
                    }
                }
            }

            return EnumActionResult.PASS;
        }
    }
}
