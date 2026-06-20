package ch.dok.liminality_limited.client.model;

import ch.dok.liminality_limited.entity.custom.TheDoktorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TheDoktorModel extends GeoModel<TheDoktorEntity> {

    @Override
    public ResourceLocation getModelResource(TheDoktorEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("liminality_limited", "geo/the_doktor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TheDoktorEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("liminality_limited", "textures/entity/the_doktor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TheDoktorEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("liminality_limited", "animations/the_doktor.animation.json");
    }
}
