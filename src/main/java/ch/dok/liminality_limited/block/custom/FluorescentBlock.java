package ch.dok.liminality_limited.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CopperBulbBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FluorescentBlock extends Block {
    public static final MapCodec<CopperBulbBlock> CODEC = simpleCodec(CopperBulbBlock::new);
    public static final BooleanProperty POWERED;
    public static final BooleanProperty LIT;

    protected MapCodec<? extends CopperBulbBlock> codec() {
        return CODEC;
    }

    public FluorescentBlock(BlockBehaviour.Properties p_308970_) {
        super(p_308970_);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(LIT, false)).setValue(POWERED, false));
    }

    protected void onPlace(BlockState p_309207_, Level p_309068_, BlockPos p_309087_, BlockState p_308908_, boolean p_308906_) {
        if (p_308908_.getBlock() != p_309207_.getBlock() && p_309068_ instanceof ServerLevel serverlevel) {
            this.checkAndFlip(p_309207_, serverlevel, p_309087_);
        }
    }

    protected void neighborChanged(BlockState p_309025_, Level p_308955_, BlockPos p_309153_, Block p_308949_, BlockPos p_308887_, boolean p_309085_) {
        if (p_308955_ instanceof ServerLevel serverlevel) {
            this.checkAndFlip(p_309025_, serverlevel, p_309153_);
        }
    }

    public void checkAndFlip(BlockState state, ServerLevel level, BlockPos pos) {
        boolean flag = level.hasNeighborSignal(pos);
        if (flag != (Boolean)state.getValue(POWERED)) {
            BlockState blockstate = state;
            if (!(Boolean)state.getValue(POWERED)) {
                blockstate = (BlockState)state.cycle(LIT);
                level.playSound((Player)null, pos, (Boolean)blockstate.getValue(LIT) ? SoundEvents.COPPER_BULB_TURN_ON : SoundEvents.COPPER_BULB_TURN_OFF, SoundSource.BLOCKS);
            }
            level.setBlock(pos, (BlockState)blockstate.setValue(POWERED, flag), 3);
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_308903_) {
        p_308903_.add(new Property[]{LIT, POWERED});
    }

    static {
        POWERED = BlockStateProperties.POWERED;
        LIT = BlockStateProperties.LIT;
    }

}
