package com.SprintXXL.primitivehud.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class HudOverlayHandler {

    @SubscribeEvent
    public static void onRenderOverlay(RenderGameOverlayEvent.Text event) {

        Minecraft mc = Minecraft.getMinecraft();

        if (mc.player == null || mc.world == null) {
            return;
        }

        HudInfo info = new HudInfo(mc.player);

        int x = 5;
        int y = 5;
        int padding = 4;
        int lineHeight = 10;

        String line1 = "-------Info HUD-------";
        String line2 = info.getPlayerCoords();
        String line3 = "Biome: " + info.getBiomeText();
        String line4 = "Deposit Chunk: " + info.getDepositChunkText();
        String line5 = "Deposit Center: " + info.getDepositCenterText();

        int width = mc.fontRenderer.getStringWidth(line1);

        int height = lineHeight * 8;

        float s = 0.75F; // Scale

        GlStateManager.pushMatrix();

        GlStateManager.scale(s,s,s);

        Gui.drawRect(
                x - padding,
                y - padding,
                x + width + padding,
                y + height + padding,
                0x25000000
        );

        mc.fontRenderer.drawStringWithShadow(line1, x, y, 0xFFFFFF);
        mc.fontRenderer.drawStringWithShadow(line2, x, y + lineHeight * 2, 0xFFFFFF);
        mc.fontRenderer.drawStringWithShadow(line3, x, y + lineHeight * 4, 0xFFFFFF);
        mc.fontRenderer.drawStringWithShadow(line4, x, y + lineHeight * 6, 0xFFFFFF);
        mc.fontRenderer.drawStringWithShadow(line5, x, y + lineHeight * 7, 0xFFFFFF);

        GlStateManager.popMatrix();
    }
}
