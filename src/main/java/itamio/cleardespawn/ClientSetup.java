package itamio.cleardespawn;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Client-only entity renderer registration.
 */
@EventBusSubscriber(modid = "cleardespawn", value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Look the item entity type up by registry id (works across
        // 1.21.11 and 26.3 where the constant layout differs).
        EntityType<?> itemType = BuiltInRegistries.ENTITY_TYPE
                .getValue(Identifier.fromNamespaceAndPath("minecraft", "item"));
        if (itemType != null) {
            @SuppressWarnings("unchecked")
            EntityType<ItemEntity> typed = (EntityType<ItemEntity>) itemType;
            event.registerEntityRenderer(typed, BlinkingItemEntityRenderer::new);
        }
    }
}
