package io.github.kydzombie.spyglass;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

public class Spyglass {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @Entrypoint.Logger
    public static final Logger LOGGER = Null.get();

    public static Item spyglass;

    @EventListener
    private void registerItems(ItemRegistryEvent event) {
        spyglass = new TemplateItem(NAMESPACE.id("spyglass")).setTranslationKey(NAMESPACE.id("spyglass")).setMaxCount(1);
    }
}
