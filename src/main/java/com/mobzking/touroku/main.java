package com.mobzking.touroku;

import com.mobzking.Item.ore_newItem;
import com.mobzking.Player.new_player;
import com.mobzking.Player.player_debuff_process;
import com.mobzking.Player.player_tick_process;
import com.mobzking.mobz.mob_something.mob_level;
import com.mobzking.mobz.mob_something.not_damage_TNT;
import com.mobzking.mobz.mob_something.set_Item;
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
        MinecraftForge.EVENT_BUS.register(new not_damage_TNT());
        MinecraftForge.EVENT_BUS.register(new new_player());
        Item_registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
