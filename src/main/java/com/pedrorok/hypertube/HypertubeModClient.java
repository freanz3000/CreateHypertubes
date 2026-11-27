package com.pedrorok.hypertube;

import com.pedrorok.hypertube.client.renderer.EntranceBlockEntityRenderer;
import com.pedrorok.hypertube.registry.ModBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

/**
 * Client-only Fabric initialization for Create Hypertube.
 */
public final class HypertubeModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(
                ModBlockEntities.HYPERTUBE_ENTRANCE.get(),
                EntranceBlockEntityRenderer::new
        );
    }
}
