package ch.dok.liminality_limited.client;

import ch.dok.liminality_limited.Liminality_Limited;
import ch.dok.liminality_limited.client.renderer.TheDoktorRenderer;
import ch.dok.liminality_limited.entity.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Liminality_Limited.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.THE_DOKTOR.get(), TheDoktorRenderer::new);
    }
}
