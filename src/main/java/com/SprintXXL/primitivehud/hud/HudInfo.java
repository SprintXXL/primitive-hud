package com.SprintXXL.primitivehud.hud;

import com.SprintXXL.primitiveoregen.util.OreGenHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;

public class HudInfo {

    public final int playerX;
    public final int playerY;
    public final int playerZ;

    public final int chunkX;
    public final int chunkZ;

    public final int blockX;
    public final int blockZ;

    public final String biomeName;

    public final int fps;

    public final boolean isDepositChunk;
    public final boolean isDepositCenter;

    public HudInfo(EntityPlayer player) {

        this.playerX = player.getPosition().getX();
        this.playerY = player.getPosition().getY();
        this.playerZ = player.getPosition().getZ();

        this.chunkX = player.chunkCoordX;
        this.chunkZ = player.chunkCoordZ;

        this.blockX = MathHelper.floor(player.posX);
        this.blockZ = MathHelper.floor(player.posZ);

        this.biomeName = player.world.getBiome(player.getPosition()).getBiomeName();

        this.fps = Minecraft.getDebugFPS();

        this.isDepositChunk = OreGenHelper.isDepositChunk(chunkX, chunkZ);
        this.isDepositCenter = OreGenHelper.isDepositCenter(blockX, blockZ);
    }

    public String getDepositChunkText() {
        return isDepositChunk ? TextFormatting.GREEN + "YES" : TextFormatting.RED + "NO";
    }

    public String getDepositCenterText() {
        return isDepositCenter ? TextFormatting.GREEN + "YES" : TextFormatting.RED + "NO";
    }

    public String getCoords() {
        return playerX + ", " + playerY + ", " + playerZ;
    }

    public String getBiome() {
        return biomeName;
    }

    public String getFPS() {

        if (fps > 120) {
            return TextFormatting.GREEN + String.valueOf(fps);
        }
        else if (fps >= 60) {
            return TextFormatting.YELLOW + String.valueOf(fps);
        }
        return TextFormatting.RED + String.valueOf(fps);
    }
}
