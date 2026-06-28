package com.mobzking.touroku;

import com.mobzking.Player_something.bleeding_effect;
import com.mobzking.Player_something.player_debuff_process;
import com.mobzking.Player_something.player_tick_process;
import com.mobzking.mob_something.mob_level;
import com.mobzking.mob_something.set_Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mobzking")
public class main {
    public main() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new set_Item());
        MinecraftForge.EVENT_BUS.register(new addgoals());
        MinecraftForge.EVENT_BUS.register(new mob_level());
        MinecraftForge.EVENT_BUS.register(new player_tick_process());
        MinecraftForge.EVENT_BUS.register(new player_debuff_process());
        MinecraftForge.EVENT_BUS.register(new bleeding_effect());
        Item_registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
