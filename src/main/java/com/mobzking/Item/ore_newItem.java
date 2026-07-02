package com.mobzking.Item;

import com.mobzking.touroku.Item_registry;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = "mobzking", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ore_newItem {
    @SubscribeEvent
    public static void ore_newItem(LootTableLoadEvent event) {
        System.out.print("チョワヨ");
        String name = event.getName().toString();
        // 鉱石系だけ対象
        if (name.contains("ore")) {
            int i = (int)(Math.random() * 250) + 1;
            if (i == 1) {
                System.out.println("スピキをイジメヌんで");
                LootPool pool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(Item_registry.NEWLIFE.get()))
                        .setRolls(ConstantValue.exactly(1))
                        .build();

                event.getTable().addPool(pool);
            }
        }
    }
}
