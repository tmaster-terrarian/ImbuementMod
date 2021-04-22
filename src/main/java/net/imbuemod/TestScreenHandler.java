package net.imbuemod;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;

public class TestScreenHandler extends GenericContainerScreenHandler implements PositionedScreenHandler {
    private final BlockPos pos;

    public TestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory,
            Inventory inventory, int rows, PacketByteBuf buf) {
        super(type, syncId, playerInventory, inventory, 3);
        this.pos = buf.readBlockPos();
    }
    public TestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory,
            Inventory inventory, int rows) {
        super(type, syncId, playerInventory, inventory, 3);
        this.pos = BlockPos.ORIGIN;
    }
    @Override
	public BlockPos getPos() {
		return pos;
	}
}
