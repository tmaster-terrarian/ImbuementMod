package net.imbuemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ImbueMod implements ModInitializer {

	public static final String MOD_ID = "imbuemod";
	public static final String MOD_NAME = "The Imbuement Mod";
	public static final String CRATE_ID = MOD_ID + ":" + "wooden_crate";

	public static final ItemGroup IMBUEMENT_MOD_ITEM_GROUP = FabricItemGroupBuilder.create(
		new Identifier(MOD_ID, "general"))
		.icon(() -> new ItemStack(BlockRegistry.FABRIC_BLOCK)).build();

	public static final ScreenHandlerType<WoodenCrateScreenHandler> WOODEN_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(CRATE_ID), WoodenCrateScreenHandler::new);

	public static Enchantment FREEZING_ENCHANTMENT;

	@Override
	public void onInitialize() {
		BlockRegistry.register();
		FREEZING_ENCHANTMENT = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "freezing"),
            new FreezingEnchantment(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND})
        );
	}
}