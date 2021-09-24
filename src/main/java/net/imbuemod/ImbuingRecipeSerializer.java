/*package net.imbuemod;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.imbuemod.Imbuing.ImbuingJsonFormat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ImbuingRecipeSerializer implements RecipeSerializer<Imbuing> {

    private ImbuingRecipeSerializer() {
    }

    public static final ImbuingRecipeSerializer INSTANCE = new ImbuingRecipeSerializer();

    // This will be the "type" field in the json
    public static final Identifier ID = new Identifier("imbuemod:imbuing_table");

    @Override
    // Turns json into Recipe
    public Imbuing read(Identifier id, JsonObject json) {
        ImbuingJsonFormat recipeJson = new Gson().fromJson(json, ImbuingJsonFormat.class);
        // Validate all fields are there
if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }
        // We'll allow to not specify the output, and default it to 1.
        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

        Ingredient inputItem = Ingredient.fromJson(recipeJson.inputItem);
        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
            // Validate the inputted item actually exists
            .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

        return new Imbuing(id, output, inputItem, inputA, inputB);
    }

    @Override
    public void write(PacketByteBuf packetData, Imbuing recipe) {
        recipe.getInputItem().write(packetData);
        recipe.getInputA().write(packetData);
        recipe.getInputB().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override
    public Imbuing read(Identifier recipeId, PacketByteBuf packetData) {
        // Make sure the read in the same order you have written!
        Ingredient inputItem = Ingredient.fromPacket(packetData);
        Ingredient inputA = Ingredient.fromPacket(packetData);
        Ingredient inputB = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new Imbuing(recipeId, output, inputItem, inputA, inputB);
    }
}*/
