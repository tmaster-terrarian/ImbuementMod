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

public class GlowshroomStem extends Block {
    
    public GlowshroomStem() {
        super(FabricBlockSettings.of(Material.PLANT).breakByHand(true).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.FUNGUS).strength(0, 0));
    }

    private static final VoxelShape SHAPE = VoxelShapes.union(
    Block.createCuboidShape(4, 0, 4, 12, 16, 12)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
