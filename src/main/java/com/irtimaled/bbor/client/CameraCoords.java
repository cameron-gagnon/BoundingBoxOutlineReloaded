package com.irtimaled.bbor.client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;

public class CameraCoords {
    private static Vec3d getCameraPos() {
        return Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
    }

    public static double getX() {
        return getCameraPos().x;
    }

    public static double getY() {
        return getCameraPos().y;
    }

    public static double getZ() {
        return getCameraPos().z;
    }
}
