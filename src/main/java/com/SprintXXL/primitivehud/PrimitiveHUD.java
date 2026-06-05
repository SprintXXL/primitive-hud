package com.SprintXXL.primitivehud;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.SprintXXL.primitivehud.Reference.*;

@Mod(
        modid = MODID,
        name = NAME,
        version = VERSION,
        dependencies = "required-after:primitiveoregen")
public class PrimitiveHUD {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
