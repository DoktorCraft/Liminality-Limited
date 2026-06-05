package ch.dok.liminality_limited.client;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(
        modid = "liminality_limited",
        bus = EventBusSubscriber.Bus.GAME,
        value = Dist.CLIENT
)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        FluorescentBlockSoundHandler.tick();
    }
}