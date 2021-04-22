package net.imbuemod;

import net.imbuemod.block.FabricBlock;
import net.imbuemod.block.WoodenCrate;
import net.imbuemod.block.WoodenCrateEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static final Block FABRIC_BLOCK = new FabricBlock();
	public static final Block WOODEN_CRATE = new WoodenCrate(AbstractBlock.Settings.copy(Blocks.OAK_WOOD));
	public static final BlockEntityType<WoodenCrateEntity> WOODEN_CRATE_ENTITY = BlockEntityType.Builder.create(WoodenCrateEntity::new, WOODEN_CRATE).build(null);

	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier(ImbueMod.MOD_ID, "fabric_block"), FABRIC_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(ImbueMod.CRATE_ID), WOODEN_CRATE);
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ImbueMod.CRATE_ID), WOODEN_CRATE_ENTITY);
	}
}