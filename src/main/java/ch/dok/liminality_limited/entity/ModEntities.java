package ch.dok.liminality_limited.entity;

import ch.dok.liminality_limited.Liminality_Limited;
import ch.dok.liminality_limited.entity.custom.TheDoktorEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Liminality_Limited.MODID);

    public static final Supplier<EntityType<TheDoktorEntity>> THE_DOKTOR = ENTITY_TYPES.register("the_doktor",
            () -> EntityType.Builder.<TheDoktorEntity>of(TheDoktorEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.15f)
                    .build("liminality_limited:the_doktor"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}