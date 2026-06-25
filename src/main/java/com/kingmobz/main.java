package com.kingmobz;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("mobzking")
public class main {
    public main() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new set_Item());
        MinecraftForge.EVENT_BUS.register(new addgoals());
        MinecraftForge.EVENT_BUS.register(new mob_stateschange());
    }
}
