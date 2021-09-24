/*package net.imbuemod;

import com.google.gson.JsonObject;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class Imbuing implements Recipe<CraftingInventory> {
	//You can add as much inputs as you want here.
	//It is important to always use Ingredient, so you can support tags.
	private final Ingredient inputItem;
	private final Ingredient inputA;
	private final Ingredient inputB;
	private final ItemStack result;
	private final Identifier id;
 
	public Imbuing(Identifier id, ItemStack result, Ingredient inputItem, Ingredient inputA, Ingredient inputB) {
		this.id = id;
		this.inputItem = inputItem;
		this.inputA = inputA;
		this.inputB = inputB;
		this.result = result;
	}
 
	public Ingredient getInputItem() {
		return this.inputItem;
	}
 
	public Ingredient getInputA() {
		return this.inputA;
	}
    
	public Ingredient getInputB() {
		return this.inputB;
	}
 
	@Override
	public ItemStack getOutput() {
		return this.result;
	}
 
	@Override
	public Identifier getId() {
		return this.id;
	}

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        if (inventory.size() < 2) return false;
        return inputItem.test(inventory.getStack(0)) && inputA.test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
		return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ImbuingRecipeSerializer.INSTANCE;
    }

    public static class Type implements RecipeType<Imbuing> {
        // Define Imbuing.Type as a singleton by making its constructor private and exposing an instance.
        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "imbuing_table";
    }

    @Override
    public RecipeType<?> getType() {
		return Type.INSTANCE;
    }

    class ImbuingJsonFormat {
        JsonObject inputItem;
        JsonObject inputA;
        JsonObject inputB;
        String outputItem;
        int outputAmount;
    }

    
}*/
