package com.kingmobz.touroku;

import com.kingmobz.Player_something.bleeding_effect;
import com.kingmobz.Player_something.player_debuff_process;
import com.kingmobz.Player_something.player_tick_process;
import com.kingmobz.mob_something.mob_stateschange;
import com.kingmobz.mob_something.set_Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("mobzking")
public class main {
    public main() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new set_Item());
        MinecraftForge.EVENT_BUS.register(new addgoals());
        MinecraftForge.EVENT_BUS.register(new mob_stateschange());
        MinecraftForge.EVENT_BUS.register(new player_tick_process());
        MinecraftForge.EVENT_BUS.register(new player_debuff_process());
        MinecraftForge.EVENT_BUS.register(new bleeding_effect());
    }
}
