package ch.dok.liminality_limited.client;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class LiminalSkyEffects extends DimensionSpecialEffects {

    public LiminalSkyEffects() {
        super(
                Float.NaN,
                false,
                SkyType.NONE,
                false,
                false
        );
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 biomeFogColor, float brightness) {
        return new Vec3(0.05, 0.05, 0.08);
    }

    @Override
    public boolean isFoggyAt(int x, int z) {
        return true;
    }
}