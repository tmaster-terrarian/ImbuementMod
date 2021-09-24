package net.imbuemod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class FabricBlock extends Block {

    public FabricBlock() {
        super(FabricBlockSettings.of(Material.WOOL).breakByHand(false).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.WOOL).strength(1, 0.2F));
    }
}
