package net.imbuemod;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    
	public static final Item WOODEN_CRATE_ITEM = new BlockItem(BlockRegistry.WOODEN_CRATE, new Item.Settings().group(ImbueMod.IMBUEMENT_MOD_ITEM_GROUP));

    public static void register() {
		Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "fabric_block"), new BlockItem(BlockRegistry.FABRIC_BLOCK, new Item.Settings().group(ImbueMod.IMBUEMENT_MOD_ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(ImbueMod.CRATE_ID), WOODEN_CRATE_ITEM);
    }
}