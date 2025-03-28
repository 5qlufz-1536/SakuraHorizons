package net.saluf.sakurahorizons.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.saluf.sakurahorizons.registry.ModItems;

public class RiceCropBlock extends CropBlock {

    public static final IntProperty AGE = CropBlock.AGE;

    public RiceCropBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(this.getAgeProperty(), 0));
    }

    @Override
    public ItemConvertible getSeedsItem() {
        return ModItems.RICE_CROP_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int age = this.getAge(state) + this.getGrowthAmount(world);
        int maxAge = this.getMaxAge();
        if (age > maxAge) {
            age = maxAge;
        }
        world.setBlockState(pos, this.withAge(age), 2);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}
