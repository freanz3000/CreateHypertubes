package com.pedrorok.hypertube.registry;

import com.pedrorok.hypertube.HypertubeMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;

/**
 * Fabric/vanilla creative tab registration.
 */
public final class ModCreativeTab {
    public static CreativeModeTab TUBE_TAB;

    private ModCreativeTab() {
    }

    public static void register() {
        if (TUBE_TAB != null) {
            return;
        }

        TUBE_TAB = Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                Identifier.fromNamespaceAndPath(HypertubeMod.MOD_ID, "create_hypertubes"),
                CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup." + HypertubeMod.MOD_ID))
                        .icon(ModBlocks.HYPERTUBE::asStack)
                        .displayItems((parameters, output) -> {
                            output.accept(ModBlocks.HYPERTUBE.get());
                            output.accept(ModBlocks.HYPERTUBE_ENTRANCE.get());
                        })
                        .build()
        );
    }
}
