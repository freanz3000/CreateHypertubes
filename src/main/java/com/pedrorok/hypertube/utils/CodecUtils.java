package com.pedrorok.hypertube.utils;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rok, Pedro Lucas nmm. Created on 25/04/2025
 * @project Create Hypertube
 */
public class CodecUtils {

    public static final StreamCodec<ByteBuf, Vec3> VEC3 = new StreamCodec<>() {
        @Override
        public @NotNull Vec3 decode(ByteBuf buffer) {
            return new Vec3(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        }

        @Override
        public void encode(ByteBuf buffer, Vec3 value) {
            buffer.writeDouble(value.x);
            buffer.writeDouble(value.y);
            buffer.writeDouble(value.z);
        }
    };

    public static final StreamCodec<ByteBuf, List<Vec3>> VEC3_LIST = new StreamCodec<>() {
        @Override
        public List<Vec3> decode(ByteBuf byteBuf) {
            int size = byteBuf.readInt();
            if (size < 0 || size > 1_000_000) {
                throw new IllegalArgumentException("Invalid Vec3 list size: " + size);
            }
            List<Vec3> vec3s = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                vec3s.add(VEC3.decode(byteBuf));
            }
            return vec3s;
        }

        @Override
        public void encode(ByteBuf buffer, List<Vec3> vec3s) {
            buffer.writeInt(vec3s.size());
            for (Vec3 vec3 : vec3s) {
                VEC3.encode(buffer, vec3);
            }
        }
    };
}
