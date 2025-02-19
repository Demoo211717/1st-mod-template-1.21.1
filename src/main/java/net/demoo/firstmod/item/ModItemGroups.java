package net.demoo.firstmod.item;

import net.demoo.firstmod.FirstMod;
import net.demoo.firstmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ALI_EMRE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "ali_emre_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SULFUR_GARNET))
                .displayName(Text.translatable("itemgroup.firstmod.sulfur_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SULFUR_GARNET);
                        entries.add(ModItems.RAW_SULFUR_GARNET);
                    }).build());


    public static final ItemGroup ALI_EMRE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "sulfur_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SULFUR_BLOCK))
                    .displayName(Text.translatable("itemgroup.firstmod.sulfur_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SULFUR_BLOCK);
                        entries.add(ModBlocks.RAW_SULFUR_BLOCK);
                    }).build());

    public static void registerModItemGroups() {
        FirstMod.LOGGER.info("Registering Mod Item Groups for " + FirstMod.MOD_ID);
    }

}
