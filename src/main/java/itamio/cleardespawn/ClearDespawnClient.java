package itamio.cleardespawn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;

public class ClearDespawnClient implements ClientModInitializer {
    public static final ModConfig CONFIG = ModConfig.load();

    @Override
    public void onInitializeClient() {
        // EntityType.ITEM was renamed in 26.3; look the type up by registry id instead.
        EntityType<?> itemType = BuiltInRegistries.ENTITY_TYPE
                .getValue(Identifier.fromNamespaceAndPath("minecraft", "item"));
        if (itemType != null) {
            @SuppressWarnings("unchecked")
            EntityType<ItemEntity> typed = (EntityType<ItemEntity>) itemType;
            EntityRendererRegistry.register(typed, BlinkingItemEntityRenderer::new);
        }
    }
}
