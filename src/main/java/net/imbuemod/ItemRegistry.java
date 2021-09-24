package net.imbuemod;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.imbuemod.item.DriftWood;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

	public static final ItemGroup IMBUEMENT_MOD_ITEM_GROUP = FabricItemGroupBuilder.create(
		new Identifier(ImbueMod.MOD_ID, "general"))
		.icon(() -> new ItemStack(BlockRegistry.FABRIC_BLOCK)).build();
    
	public static final Item WOODEN_CRATE_ITEM = new BlockItem(BlockRegistry.WOODEN_CRATE, new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP));

	public static final Item DRIFTWOOD_ITEM = new DriftWood(new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP));

    public static void register() {
		Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "fabric_block"), new BlockItem(BlockRegistry.FABRIC_BLOCK, new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "small_glowshroom"), new BlockItem(BlockRegistry.SMALL_GLOWSHROOM, new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "lumitop"), new BlockItem(BlockRegistry.LUMITOP, new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "glowshroom_stem"), new BlockItem(BlockRegistry.GLOWSHROOM_STEM, new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP)));
		//Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "imbuing_table"), new BlockItem(BlockRegistry.IMBUING_TABLE_BLOCK, new Item.Settings().group(IMBUEMENT_MOD_ITEM_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(ImbueMod.MOD_ID, "driftwood"), DRIFTWOOD_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ImbueMod.CRATE_ID), WOODEN_CRATE_ITEM);
    }
}