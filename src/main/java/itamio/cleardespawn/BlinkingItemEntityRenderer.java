package itamio.cleardespawn;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;

/**
 * Port of ClearDespawn by StrikerRockers-Mods (MIT): override render()
 * (classic pipeline in 1.21.1) and skip rendering while the item
 * should blink before despawn.
 */
public class BlinkingItemEntityRenderer extends ItemEntityRenderer {
    public BlinkingItemEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(ItemEntity entity, float yaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        int remainingTime = ClearDespawnClient.CONFIG.despawnTime - entity.getAge();
        if (remainingTime <= 20 * ClearDespawnClient.CONFIG.flashStartTime) {
            if (ClearDespawnClient.CONFIG.urgentFlash) {
                int flashFactor = Math.max(2, remainingTime / 20);
                if (remainingTime % flashFactor < 0.5f * flashFactor) {
                    return;
                }
            } else if (remainingTime % 20 < 10) {
                return;
            }
        }
        super.render(entity, yaw, partialTicks, poseStack, buffer, packedLight);
    }
}
