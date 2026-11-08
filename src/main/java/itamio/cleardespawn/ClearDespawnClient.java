package itamio.cleardespawn;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Unofficial Forge port of ClearDespawn by StrikerRockers-Mods (LGPL-3.0-only).
 * See NOTICE for credit and licensing.
 */
@Mod("cleardespawn")
public class ClearDespawnClient {
    public static final ModConfig CONFIG = ModConfig.load();

    public ClearDespawnClient() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerRenderers);
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.register(EntityType.ITEM, BlinkingItemEntityRenderer::new);
    }
}
