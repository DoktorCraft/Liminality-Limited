package ch.dok.liminality_limited.client.renderer;

import ch.dok.liminality_limited.client.model.TheDoktorModel;
import ch.dok.liminality_limited.entity.custom.TheDoktorEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TheDoktorRenderer extends GeoEntityRenderer<TheDoktorEntity> {

    public TheDoktorRenderer(EntityRendererProvider.Context context) {
        super(context, new TheDoktorModel());
    }
}
