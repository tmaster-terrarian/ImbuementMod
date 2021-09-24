package net.imbuemod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

// kudos to NinjaPhenix#0904 on discord for the help
public class TestScreenHandler extends ScreenHandler implements PositionedScreenHandler {
	private final BlockPos pos;

    protected static Inventory inventory;

    protected static ScreenHandlerType<?> handlerType;

    private static final int SLOT_SIZE = 18;
    private static final int NAME_FOREHEAD_HEIGHT = 17;
    private static final int SCREEN_HORIZONTAL_PADDING = 7;

    public TestScreenHandler(int syncId, Inventory inventory, PacketByteBuf buf) {
        super(handlerType, syncId);
		this.pos = buf.readBlockPos();
        TestScreenHandler.handlerType = getType();
        final int slotWidth = 5;
        final int slotHeight = 3;
        checkSize(inventory, slotWidth * slotHeight);
        final int visualWidth = SCREEN_HORIZONTAL_PADDING + 9 * SLOT_SIZE + SCREEN_HORIZONTAL_PADDING;
        final int slotStartX = visualWidth / 2 - slotWidth * SLOT_SIZE / 2;
        final int slotStartY = NAME_FOREHEAD_HEIGHT + 1;
        final SimpleInventory crateInventory = new SimpleInventory(slotWidth * slotHeight);
        // Add chest inventory slots;
        for (int x = 0; x < slotWidth; x++) {
            for (int y = 0; y < slotHeight; y++) {
                addSlot(new Slot(crateInventory, x + y * slotWidth, slotStartX + 1 + x * SLOT_SIZE, slotStartY + y * SLOT_SIZE - 1));
            }
        }
        // Add inventory slots for player's inventory (9x3 bit)
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 3; y++) {
                addSlot(new Slot(inventory, y * 9 + x + 9, SCREEN_HORIZONTAL_PADDING + 1 + (18 * x), slotStartY + y * 18 + 12 + 54));
            }
        }
        // Add inventory slots for hotbar
        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(inventory, i, SCREEN_HORIZONTAL_PADDING + 1 + 18 * i, slotStartY + 124));
        }
    }

    public TestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(handlerType, syncId);
		this.pos = BlockPos.ORIGIN;
	}

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

	@Override
	public ScreenHandlerType<?> getType() {
		return ImbueMod.TEST_SCREEN_HANDLER;
	}

    @Override
    public BlockPos getPos() {
        return pos;
    }
}
