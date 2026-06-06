package com.SprintXXL.primitivehud.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

import java.util.List;

public class HudRenderer {

    public static void render(Minecraft mc, List<String> lines, int x, int y) {

        int padding = 4;
        int lineHeight = 10;
        float scale = 0.75F;

        int width = getMaxLineWidth(mc, lines);
        int height = lines.size() * lineHeight;

        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);

        Gui.drawRect(
                x - padding,
                y - padding,
                x + width + padding,
                y + height + padding,
                0x25000000
        );

        for (int i = 0; i < lines.size(); i++) {
            mc.fontRenderer.drawStringWithShadow(
                    lines.get(i),
                    x,
                    y + lineHeight * i,
                    0xFFFFFF
            );
        }

        GlStateManager.popMatrix();
    }

    private static int getMaxLineWidth(Minecraft mc, List<String> lines) {

        int max = 0;

        for (String line : lines) {
            max = Math.max(max, mc.fontRenderer.getStringWidth(line));
        }

        return max;
    }
}
