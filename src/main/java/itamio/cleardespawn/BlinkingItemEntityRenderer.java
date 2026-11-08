package itamio.cleardespawn;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;

public class BlinkingItemEntityRenderer extends ItemEntityRenderer {

    public BlinkingItemEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRender(ItemEntity entity, Frustum frustum, double x, double y, double z) {
        // Direct port of the ClearDespawn blink logic by StrikerRocker:
        // when an item is close to despawning, skip rendering on/off so it visibly blinks.
        int remainingTime = ClearDespawnClient.CONFIG.despawnTime - entity.getAge();
        if (remainingTime <= 20 * ClearDespawnClient.CONFIG.flashStartTime) {
            if (ClearDespawnClient.CONFIG.urgentFlash) {
                int flashFactor = Math.max(2, remainingTime / 20);
                if (remainingTime % flashFactor < 0.5f * flashFactor) {
                    return false;
                }
            } else if (remainingTime % 20 < 10) {
                return false;
            }
        }
        return super.shouldRender(entity, frustum, x, y, z);
    }
}
