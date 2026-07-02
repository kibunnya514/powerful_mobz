package com.mobzking.Player;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class new_player{
    @SubscribeEvent
    public static void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
        if (!event.isWasDeath()) return;

        var oldPlayer = event.getOriginal();
        var newPlayer = event.getEntity();

        var oldData = oldPlayer.getPersistentData();
        var newData = newPlayer.getPersistentData();

        // 例：自分で保存してた値を引き継ぐ
        newData.putInt("newlife", oldData.getInt("newlife"));
    }
    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        var attr = player.getAttribute(Attributes.MAX_HEALTH);
        int life_count = player.getPersistentData().getInt("newlife");
        System.out.print(life_count);
        if (attr != null) {
            attr.setBaseValue(attr.getBaseValue() + life_count);
        }
    }

}