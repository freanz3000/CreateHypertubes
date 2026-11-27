package com.pedrorok.hypertube.registry;

import com.pedrorok.hypertube.HypertubeMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

/**
 * @author Rok, Pedro Lucas nmm. Created on 26/05/2025
 * @project Create Hypertube
 */
public class ModSounds {

    public static final SoundEvent HYPERTUBE_SUCTION = register("suction");
    public static final SoundEvent TRAVELING = register("traveling");

    private static SoundEvent register(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(HypertubeMod.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void register() {
        // Static fields register the sounds when this class is initialized.
    }
}
