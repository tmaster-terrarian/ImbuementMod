package net.imbuemod;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import static net.minecraft.server.command.CommandManager.*;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.command.argument.ColorArgumentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.MessageType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ImbueMod implements ModInitializer {

	public static final String MOD_ID = "imbuemod";
	public static final String MOD_NAME = "The Imbuement Mod";
	public static final String CRATE_ID = MOD_ID + ":" + "wooden_crate";

	public static final ScreenHandlerType<WoodenCrateScreenHandler> WOODEN_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(CRATE_ID), WoodenCrateScreenHandler::new);
	public static final ScreenHandlerType<TestScreenHandler> TEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "test_sc_handler"), TestScreenHandler::new);

	public static Enchantment FREEZING_ENCHANTMENT;

	void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("xyzzy")
		.executes(ctx -> {
			ServerCommandSource source = ctx.getSource();
			source.getMinecraftServer().getPlayerManager().broadcastChatMessage(new LiteralText("Nothing happens."), MessageType.CHAT, source.getPlayer().getUuid());
			return 1;
		}));
	}

	public static LiteralCommandNode<?> register(CommandDispatcher<ServerCommandSource> dispatcher) { // You can also return a LiteralCommandNode for use with possible redirects
		return dispatcher.register(literal("test_command")
			.then(literal("foo")
				.executes(ctx -> giveDebug(ctx)))
			.then(literal("bar")
				.then(argument("color", ColorArgumentType.color())
					.then(argument("message", StringArgumentType.greedyString())
						.executes(ctx -> broadcast(ctx.getSource(), ColorArgumentType.getColor(ctx, "color"), StringArgumentType.getString(ctx, "message")))))));
	}

	public static int broadcast(ServerCommandSource source, Formatting formatting, String message) throws CommandSyntaxException {
		final Text text = new LiteralText(message).formatted(formatting);

		source.getMinecraftServer().getPlayerManager().broadcastChatMessage(text, MessageType.CHAT, source.getPlayer().getUuid());
		return Command.SINGLE_SUCCESS; // Success
	}

	public static int giveDebug(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
		final ServerCommandSource source = ctx.getSource();

		final PlayerEntity self = source.getPlayer();

		if(source.hasPermissionLevel(4)) {
			self.inventory.insertStack(new ItemStack(Items.COMMAND_BLOCK));
			self.inventory.insertStack(new ItemStack(Items.STRUCTURE_BLOCK));
			self.inventory.insertStack(new ItemStack(Items.BARRIER));
			self.inventory.insertStack(new ItemStack(Items.DEBUG_STICK));
		}
		else {
			throw new SimpleCommandExceptionType(new TranslatableText("exception.insufficient_perms")).create();
		}
		return 1;
	}

	@Override
	public void onInitialize() {
		ItemRegistry.register();
		BlockRegistry.register();
		FREEZING_ENCHANTMENT = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MOD_ID, "freezing"),
            new FreezingEnchantment(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND})
        );
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("test_command")
				.then(literal("foo")
					.executes(ctx -> giveDebug(ctx)))
					.then(literal("bar")
						.then(argument("color", ColorArgumentType.color())
							.then(argument("message", StringArgumentType.greedyString())
								.executes(ctx -> broadcast(ctx.getSource(), ColorArgumentType.getColor(ctx, "color"), StringArgumentType.getString(ctx, "message")))))));
			dispatcher.register(literal("xyzzy")
			.executes(ctx -> {
				ServerCommandSource source = ctx.getSource();
				source.getMinecraftServer().getPlayerManager().broadcastChatMessage(new LiteralText("Nothing happens."), MessageType.CHAT, source.getPlayer().getUuid());
				return 1;
			}));
        });
	}
}