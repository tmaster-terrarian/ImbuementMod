package net.imbuemod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SmallGlowshroom extends Block {
    
    public SmallGlowshroom() {
        super(FabricBlockSettings.of(Material.PLANT).breakByHand(true).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.FUNGUS).strength(0.2F, 0.2F));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0.375f, 0f, 1f, 1f, 1f);
    }
}
