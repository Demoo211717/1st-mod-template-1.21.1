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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ALI_EMRE_GARNET))
                .displayName(Text.translatable("itemgroup.firstmod.ali_emre_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ALI_EMRE_GARNET);
                        entries.add(ModItems.RAW_ALI_EMRE_GARNET);
                    }).build());


    public static final ItemGroup ALI_EMRE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "ali_emre_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ALI_EMRE_BLOCK))
                    .displayName(Text.translatable("itemgroup.firstmod.ali_emre_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ALI_EMRE_BLOCK);
                        entries.add(ModBlocks.RAW_ALI_EMRE_BLOCK);
                    }).build());

    public static void registerModItemGroups() {
        FirstMod.LOGGER.info("Registering Mod Item Groups for " + FirstMod.MOD_ID);
    }

}
