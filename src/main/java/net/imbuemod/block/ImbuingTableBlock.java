/*package net.imbuemod.block;

import java.util.Optional;

import net.imbuemod.Imbuing;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ImbuingTableBlock extends Block {
	private static final Text TITLE = new TranslatableText("container.imbuing_table");

	public ImbuingTableBlock(Settings settings) {
		super(settings);
	}
    
    @Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if(world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
			player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
			return ActionResult.CONSUME;
		}
	}

    public boolean activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        // Something that gives the player items should always go through the server.
        // If you need to notify the client in some way, check in the server and then send a packet to the client.
        if (!world.isClient()) {
            // For the sake of simplicity we draw the items off of the player's hands and create an inventory from that.
            // Usually you use an inventory of yours instead.
            BasicInventory inventory = new BasicInventory(player.getMainHandStack(), player.getOffHandStack());

            // Or use .getAllMatches if you want all of the matches
            Optional<Imbuing> match = world.getRecipeManager()
                .getFirstMatch(Imbuing.Type.INSTANCE, inventory, world);

            if (match.isPresent()) {
                // Give the player the item and remove from what he has. Make sure to copy the ItemStack to not ruin it!
                player.inventory.offerOrDrop(world, match.get().getOutput().copy());
                player.getMainHandStack().decrement(1);
                player.getOffHandStack().decrement(1);
            } else {
                // If it doesn't match we tell the player
                player.sendMessage(new LiteralText("No match!"), true);
            }
        }

        return true;
    }

	@Override
	public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
		return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
			return new ImbuingTableScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
		}, TITLE);
	}
}*/
