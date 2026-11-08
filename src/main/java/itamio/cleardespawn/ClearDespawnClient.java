package itamio.cleardespawn;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * Unofficial NeoForge port of ClearDespawn by StrikerRockers-Mods (LGPL-3.0-only).
 * See NOTICE for credit and licensing.
 */
@Mod("cleardespawn")
public class ClearDespawnClient {
    public static final ModConfig CONFIG = ModConfig.load();

    public ClearDespawnClient(IEventBus eventBus) {
    }
}
