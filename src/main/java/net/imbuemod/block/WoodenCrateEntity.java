package net.imbuemod.block;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.imbuemod.BlockRegistry;
import net.imbuemod.WoodenCrateScreenHandler;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class WoodenCrateEntity extends LootableContainerBlockEntity implements ExtendedScreenHandlerFactory {
	private DefaultedList<ItemStack> items = DefaultedList.ofSize(size(), ItemStack.EMPTY);

	public WoodenCrateEntity() {
		super(BlockRegistry.WOODEN_CRATE_ENTITY);
	}

	@Override
	protected DefaultedList<ItemStack> getInvStackList() {
		return items;
	}

	@Override
	protected void setInvStackList(DefaultedList<ItemStack> list) {
		this.items = list;
	}

	@Override
	protected Text getContainerName() {
		return new TranslatableText(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new WoodenCrateScreenHandler(syncId, playerInventory, this);
	}

	@Override
	public int size() {
		return 5 * 3;
	}

	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
		buf.writeBlockPos(pos);
	}
}