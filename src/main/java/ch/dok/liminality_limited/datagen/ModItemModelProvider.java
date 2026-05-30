package ch.dok.liminality_limited.datagen;

import ch.dok.liminality_limited.item.ModItems;
import ch.dok.liminality_limited.Liminality_Limited;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Liminality_Limited.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}