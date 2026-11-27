package com.pedrorok.hypertube.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Lightweight Fabric-side client configuration.
 */
public final class ClientConfig {
    private static final ClientConfig INSTANCE = new ClientConfig();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir()
            .resolve("create_hypertube-client.json");

    public final BooleanValue ALLOW_FPV_INSIDE_TUBE = new BooleanValue();

    private ClientConfig() {
        load();
    }

    public static ClientConfig get() {
        return INSTANCE;
    }

    private void load() {
        if (!Files.exists(CONFIG_PATH)) {
            saveDefault();
            return;
        }

        try {
            JsonObject json = JsonParser.parseString(Files.readString(CONFIG_PATH)).getAsJsonObject();
            ALLOW_FPV_INSIDE_TUBE.value = json.has("allowFirstPersonInsideTube")
                    && json.get("allowFirstPersonInsideTube").getAsBoolean();
        } catch (Exception exception) {
            ALLOW_FPV_INSIDE_TUBE.value = false;
        }
    }

    private void saveDefault() {
        JsonObject json = new JsonObject();
        json.addProperty("allowFirstPersonInsideTube", false);
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            Files.writeString(CONFIG_PATH, json.toString() + System.lineSeparator());
        } catch (IOException ignored) {
            // The default remains active if the config file cannot be written.
        }
    }

    public static final class BooleanValue {
        private boolean value;

        public boolean get() {
            return value;
        }
    }
}
