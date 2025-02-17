package net.demoo.firstmod.item;

import net.demoo.firstmod.FirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ALI_EMRE_GARNET = registerItem("ali_emre_garnet", new Item(new Item.Settings()));
    public static final Item RAW_ALI_EMRE_GARNET = registerItem("raw_ali_emre_garnet", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((entries) -> {
            entries.add(ALI_EMRE_GARNET);
            entries.add(RAW_ALI_EMRE_GARNET);
        });
    }
}
