package com.pedrorok.hypertube.registry;

import com.pedrorok.hypertube.HypertubeMod;
import com.pedrorok.hypertube.managers.placement.BezierConnection;
import com.pedrorok.hypertube.managers.placement.SimpleConnection;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

/**
 * Fabric/vanilla data component registration.
 */
public final class ModDataComponent {

    public static final DataComponentType<SimpleConnection> TUBE_CONNECTING_FROM = register(
            "tube_connecting_from",
            DataComponentType.<SimpleConnection>builder()
                    .persistent(SimpleConnection.CODEC)
                    .networkSynchronized(SimpleConnection.STREAM_CODEC)
                    .build()
    );

    public static final DataComponentType<BezierConnection> BEZIER_CONNECTION = register(
            "bezier_connection",
            DataComponentType.<BezierConnection>builder()
                    .persistent(BezierConnection.CODEC)
                    .networkSynchronized(BezierConnection.STREAM_CODEC)
                    .build()
    );

    private static <T> DataComponentType<T> register(String name, DataComponentType<T> type) {
        return Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                Identifier.fromNamespaceAndPath(HypertubeMod.MOD_ID, name),
                type
        );
    }

    public static void register() {
        // Static fields register the components when this class is initialized.
    }
}
