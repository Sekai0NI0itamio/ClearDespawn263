package itamio.cleardespawn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.world.entity.EntityType;

public class ClearDespawnClient implements ClientModInitializer {
    public static final ModConfig CONFIG = ModConfig.load();

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityType.ITEM, BlinkingItemEntityRenderer::new);
    }
}
