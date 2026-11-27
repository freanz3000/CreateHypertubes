package com.pedrorok.hypertube.registry;

import com.pedrorok.hypertube.HypertubeMod;
import com.zurrtum.create.Create;
import com.zurrtum.create.client.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.Identifier;

/**
 * @author Rok, Pedro Lucas nmm. Created on 03/06/2025
 * @project Create Hypertube
 */
public class ModPartialModels {

    public static PartialModel COGWHEEL_HOLE = block("hypertube_entrance/cogwheel_hole");

    private static PartialModel block(String path) {
        return PartialModel.of(Identifier.fromNamespaceAndPath(HypertubeMod.MOD_ID, "block/" + path));
    }

    public static void init() {

    }
}
