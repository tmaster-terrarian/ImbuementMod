package net.imbuemod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Lumitop extends Block {

    public Lumitop() {
        super(FabricBlockSettings.of(Material.PLANT).breakByHand(true).sounds(BlockSoundGroup.FUNGUS).strength(0, 0));
    }

    private static final VoxelShape SHAPE = VoxelShapes.union(
    Block.createCuboidShape(7, 0, 7, 9, 4, 9),
    Block.createCuboidShape(4, 4, 4, 12, 8, 12)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
