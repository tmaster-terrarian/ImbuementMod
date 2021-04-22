package net.imbuemod;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;

public class WoodenCrateScreenHandler extends Generic3x3ContainerScreenHandler implements PositionedScreenHandler {
	private final BlockPos pos;

	public WoodenCrateScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
		super(syncId, playerInventory);
		this.pos = buf.readBlockPos();

	}
	public WoodenCrateScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(syncId, playerInventory, inventory);
		this.pos = BlockPos.ORIGIN;
		
	}
	@Override
	public BlockPos getPos() {
		return pos;
	}
	@Override
	public ScreenHandlerType<?> getType() {
		return ImbueMod.WOODEN_CRATE_SCREEN_HANDLER;
	}
}