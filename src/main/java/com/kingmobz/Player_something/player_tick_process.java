package com.kingmobz.Player_something;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import static com.kingmobz.Player_something.player_debuff_process.bleeding;

@Mod.EventBusSubscriber(modid = "mobzking")
public class player_tick_process {
    public static int flashTime = 0;

    @SubscribeEvent
    public static void Player_tick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        //下の２行は１ティックに重複処理されないようにするため。
        if (event.phase != TickEvent.Phase.END) return;
        if (event.player.level().isClientSide()) return;
        //出血中は毎秒ダメージを受ける
        if (bleeding > 0 && player.tickCount % 40 == 0) {
            System.out.print(bleeding);
            player.hurt(player.damageSources().generic(), 1.0F);
            bleeding = bleeding - 1;
        }
    }
}
