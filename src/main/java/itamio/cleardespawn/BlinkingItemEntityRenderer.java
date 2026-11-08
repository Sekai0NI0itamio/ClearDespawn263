package itamio.cleardespawn;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.world.entity.item.ItemEntity;

/**
 * Port of ClearDespawn by StrikerRockers-Mods (LGPL-3.0-only).
 * In 1.21.11 rendering uses the render-state pipeline: the blink decision is
 * captured in extractRenderState and applied in submit.
 */
public class BlinkingItemEntityRenderer extends ItemEntityRenderer {{

    private static final class BlinkingState extends ItemEntityRenderState {{
        boolean blink;
    }}

    public BlinkingItemEntityRenderer(EntityRendererProvider.Context context) {{
        super(context);
    }}

    @Override
    public ItemEntityRenderState createRenderState() {{
        return new BlinkingState();
    }}

    @Override
    public void extractRenderState(ItemEntity entity, ItemEntityRenderState state, float partialTicks) {{
        super.extractRenderState(entity, state, partialTicks);
        if (state instanceof BlinkingState blinking) {{
            blinking.blink = shouldBlink(entity);
        }}
    }}

    @Override
    public void submit(ItemEntityRenderState state, PoseStack poseStack,
                       SubmitNodeCollector collector, CameraRenderState cameraState) {{
        if (state instanceof BlinkingState blinking && blinking.blink) {{
            return;
        }}
        super.submit(state, poseStack, collector, cameraState);
    }}

    private static boolean shouldBlink(ItemEntity entity) {{
        int remainingTime = ClearDespawnClient.CONFIG.despawnTime - entity.getAge();
        if (remainingTime <= 20 * ClearDespawnClient.CONFIG.flashStartTime) {{
            if (ClearDespawnClient.CONFIG.urgentFlash) {{
                int flashFactor = Math.max(2, remainingTime / 20);
                return remainingTime % flashFactor < 0.5f * flashFactor;
            }} else {{
                return remainingTime % 20 < 10;
            }}
        }}
        return false;
    }}
}}
