package com.pedrorok.hypertube;

import com.pedrorok.hypertube.registry.*;
import com.zurrtum.create.foundation.data.CreateRegistrate;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rok, Pedro Lucas nmm. Created on 17/04/2025
 * @project Create Hypertube
 */
public class HypertubeMod implements ModInitializer {
    public static final String MOD_ID = "create_hypertube";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    @Override
    public void onInitialize() {
        ModPartialModels.init();
        ModBlocks.register();
        ModBlockEntities.register();
        ModCreativeTab.register();
        ModDataComponent.register();
        ModSounds.register();
    }

    public static CreateRegistrate get() {
        return REGISTRATE;
    }
}
