package ch.dok.liminality_limited.item;

import ch.dok.liminality_limited.Liminality_Limited;
import ch.dok.liminality_limited.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Liminality_Limited.MODID);

    public static final DeferredItem<SpawnEggItem> THE_DOKTOR_SPAWN_EGG = ITEMS.register("the_doktor_spawn_egg",
            () -> new SpawnEggItem(ModEntities.THE_DOKTOR.get(), 0x0084E3, 0x8900D6, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}