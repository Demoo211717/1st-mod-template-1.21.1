package net.demoo.firstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS
            );
    private static final Map<Block, Block> CHISEL_MAP_SNEAKING =
            Map.of(
                    Blocks.STONE_BRICKS, Blocks.STONE,
                    Blocks.END_STONE_BRICKS, Blocks.END_STONE
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        PlayerEntity player = context.getPlayer();

        boolean isSneaking = player != null && player.getPose() == EntityPose.CROUCHING;
        Map<Block, Block> chiselMap = isSneaking ? CHISEL_MAP_SNEAKING : CHISEL_MAP;

        if (chiselMap.containsKey(clickedBlock)) {
            if (!world.isClient) {
                world.setBlockState(context.getBlockPos(), chiselMap.get(clickedBlock).getDefaultState());

                context.getStack().damage(1,((ServerWorld) world), ((ServerPlayerEntity) context .getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }

        return ActionResult.SUCCESS;
    }
}
