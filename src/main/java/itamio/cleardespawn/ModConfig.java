package itamio.cleardespawn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger("ClearDespawn263");

    // Ticks are 1/20s in Minecraft. Matches original ClearDespawn defaults.
    public int flashStartTime = 20;
    public int despawnTime = 6000;
    public boolean urgentFlash = true;

    private void clamp() {
        flashStartTime = Math.max(0, Math.min(300, flashStartTime));
        despawnTime = Math.max(0, Math.min(36000, despawnTime));
    }

    public static ModConfig load() {
        Path dir = FMLPaths.GAMEDIR.get().resolve("config");
        Path file = dir.resolve("itamio_cleardespawn.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ModConfig config = new ModConfig();
        if (Files.exists(file)) {
            try (Reader reader = Files.newBufferedReader(file)) {
                ModConfig loaded = gson.fromJson(reader, ModConfig.class);
                if (loaded != null) {
                    config = loaded;
                }
            } catch (IOException | RuntimeException e) {
                LOGGER.warn("Failed to load ClearDespawn config, using defaults", e);
            }
        }
        config.clamp();
        try {
            Files.createDirectories(dir);
            try (Writer writer = Files.newBufferedWriter(file)) {
                gson.toJson(config, writer);
            }
        } catch (IOException e) {
            LOGGER.warn("Failed to write ClearDespawn config", e);
        }
        return config;
    }
}
