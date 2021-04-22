package net.imbuemod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class SmallGlowshroom extends Block {
    
    public SmallGlowshroom() {
        super(FabricBlockSettings.of(Material.PLANT).breakByHand(true).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.FUNGUS).strength(0.2F, 0.2F));
    }
}
