package com.SprintXXL.primitivehud.hud;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber
public class HudOverlayHandler {

    @SubscribeEvent
    public static void onRenderOverlay(RenderGameOverlayEvent.Text event) {

        Minecraft mc = Minecraft.getMinecraft();

        if (mc.player == null || mc.world == null) {
            return;
        }

        HudInfo info = new HudInfo(mc.player);

        List<String> lines = HudLineBuilder.buildLines(info);

        HudRenderer.render(mc, lines, 5, 5);
    }
}
