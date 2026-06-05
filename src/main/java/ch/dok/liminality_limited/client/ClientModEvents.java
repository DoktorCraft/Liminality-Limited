package ch.dok.liminality_limited.client;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;

public class ClientModEvents {
    @SubscribeEvent
        public static void registerDimensionEffects(RegisterDimensionSpecialEffectsEvent event) {
            event.register(
                    ResourceLocation.fromNamespaceAndPath("liminality_limited", "liminal_sky"),
                    new LiminalSkyEffects()
            );
    }
}
