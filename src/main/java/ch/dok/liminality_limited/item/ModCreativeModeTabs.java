package ch.dok.liminality_limited.item;

import ch.dok.liminality_limited.Liminality_Limited;
import ch.dok.liminality_limited.block.ModBlocks;
import ch.dok.liminality_limited.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Liminality_Limited.MODID);

    public static final Supplier<CreativeModeTab> LIMINALITY_LIMITED_TAB = CREATIVE_MODE_TAB.register("liminality_limited_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WALLPAPER_BLOCK.get()))
                    .title(Component.translatable("creativetab.liminality_limited"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.WALLPAPER_BLOCK);
                        output.accept(ModBlocks.WALLPAPER_BLOCK_STRIP);
                        output.accept(ModBlocks.BACKROOMS_FLOOR);
                        output.accept(ModBlocks.FLUORESCENT_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
