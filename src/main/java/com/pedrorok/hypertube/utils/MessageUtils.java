package com.pedrorok.hypertube.utils;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

/**
 * @author Rok, Pedro Lucas nmm. Created on 27/05/2025
 * @project Create Hypertube
 */
public class MessageUtils {

    public static void sendActionMessage(Player player, String message) {
        player.displayClientMessage(Component.literal(message), true);
    }

    @Environment(EnvType.CLIENT)
    public static void sendClientActionMessage(String message) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            sendActionMessage(player, message);
        }
    }
}
