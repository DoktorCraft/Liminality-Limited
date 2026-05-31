package ch.dok.liminality_limited.client;

import ch.dok.liminality_limited.block.custom.FluorescentBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class FluorescentBlockSoundHandler {

    private static SingleFluorescentSound activeSound = null;

    public static void tick() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) {
            stopAll();
            return;
        }

        BlockPos playerPos = mc.player.blockPosition();
        int range = 16;

        List<BlockPos> litBlocks = new ArrayList<>();
        for (BlockPos pos : BlockPos.betweenClosed(
                playerPos.offset(-range, -range, -range),
                playerPos.offset(range, range, range))) {

            BlockState state = mc.level.getBlockState(pos);
            if (state.getBlock() instanceof FluorescentBlock
                    && state.getValue(FluorescentBlock.LIT)) {
                litBlocks.add(pos.immutable());
            }
        }

        if (litBlocks.isEmpty()) {
            stopAll();
            return;
        }

        double avgX = litBlocks.stream().mapToInt(BlockPos::getX).average().orElse(playerPos.getX()) + 0.5;
        double avgY = litBlocks.stream().mapToInt(BlockPos::getY).average().orElse(playerPos.getY()) + 0.5;
        double avgZ = litBlocks.stream().mapToInt(BlockPos::getZ).average().orElse(playerPos.getZ()) + 0.5;

        float volume = (float) Math.min(1.0, 0.3 + Math.log10(litBlocks.size()) * 0.35);

        if (activeSound == null || !mc.getSoundManager().isActive(activeSound)) {
            activeSound = new SingleFluorescentSound(avgX, avgY, avgZ, volume);
            mc.getSoundManager().play(activeSound);
        } else {
            activeSound.updatePosition(avgX, avgY, avgZ);
            activeSound.updateVolume(volume);
        }
    }

    public static void stopAll() {
        if (activeSound != null) {
            Minecraft.getInstance().getSoundManager().stop(activeSound);
            activeSound = null;
        }
    }
}