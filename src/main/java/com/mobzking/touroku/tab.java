package com.mobzking.touroku;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mobzking", bus = Mod.EventBusSubscriber.Bus.MOD)
public class tab{
    @SubscribeEvent
    public static void addToTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Item_registry.REPAIR.get());
            event.accept(Item_registry.SEIMEI.get());
            event.accept(Item_registry.SEIMEI_NULL.get());
            event.accept(Item_registry.SYOGEKI_NULL.get());
            event.accept(Item_registry.SYOGEKI.get());
            event.accept(Item_registry.NEWLIFE.get());
            event.accept(Item_registry.LOOT_BACK.get());
            event.accept(Item_registry.MID_KIT.get());
            event.accept(Item_registry.BAND_AGE.get());

        }
    }
}