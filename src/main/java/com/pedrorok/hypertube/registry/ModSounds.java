package com.pedrorok.hypertube.registry;

import com.pedrorok.hypertube.HypertubeMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
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
        Identifier id = new Identifier(HypertubeMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
    }
}
