package com.mobzking.touroku;

import com.mobzking.touroku.Item_registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mobzking")
public class main {
    public main() {
        System.out.print("MAIN MOD INIT");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ★アイテム登録（これが超重要）
        Item_registry.ITEMS.register(modEventBus);

        // イベント登録（これは今のままでOK）
        MinecraftForge.EVENT_BUS.register(this);
    }
}