package net.demoo.firstmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.demoo.firstmod.FirstMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MinecartItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
        new Block(AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_SULFUR_BLOCK = registerBlock("raw_sulfur_block",
        new Block(AbstractBlock.Settings.create().strength(3f)
            .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block SULFUR_DEEPSLATE_ORE = registerBlock("sulfur_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FirstMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering Mod Blocks for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries) -> {
            entries.add(SULFUR_BLOCK);
            entries.add(RAW_SULFUR_BLOCK);

            entries.add(SULFUR_ORE);
            entries.add(SULFUR_DEEPSLATE_ORE);
        });
    }

}
