package com.SprintXXL.primitivehud.hud;

import java.util.ArrayList;
import java.util.List;

public class HudLineBuilder {

    public static List<String> buildLines(HudInfo info) {
        List<String> lines = new ArrayList<>();

        lines.add("-------Info HUD-------");
        lines.add("");
        lines.add("FPS: " + info.getFPS());
        lines.add(info.getCoords());
        lines.add("");
        lines.add("Biome: " + info.getBiome());
        lines.add("");
        lines.add("Deposit Chunk: " + info.getDepositChunkText());
        lines.add("Deposit Center: " + info.getDepositCenterText());

        return lines;
    }
}
