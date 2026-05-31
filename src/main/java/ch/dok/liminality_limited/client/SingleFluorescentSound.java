package ch.dok.liminality_limited.client;

import ch.dok.liminality_limited.sound.ModSounds;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;

public class SingleFluorescentSound extends AbstractTickableSoundInstance {

    public SingleFluorescentSound(double x, double y, double z, float volume) {
        super(ModSounds.ELECTRIC_HUM.get(), SoundSource.BLOCKS, RandomSource.create());
        this.x = x;
        this.y = y;
        this.z = z;
        this.looping = true;
        this.delay = 0;
        this.volume = volume;
        this.pitch = 1.0f;
        this.attenuation = SoundInstance.Attenuation.LINEAR;
    }

    @Override
    public void tick() {
    }

    public void updatePosition(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void updateVolume(float volume) {
        this.volume = volume;
    }
}