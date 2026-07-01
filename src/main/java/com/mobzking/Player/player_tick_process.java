package com.mobzking.Player;

import com.mobzking.touroku.Item_registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mobzking")
public class player_tick_process {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;
        if (player.level().isClientSide()) return;
        var data = player.getPersistentData();
        // 出血処理
        int bleeding = data.getInt("bleeding");
        if (bleeding > 0 && player.tickCount % 80 == 0) {
            player.hurt(player.damageSources().generic(), 1.0F);
            data.putInt("bleeding", bleeding - 1);
        }
        // 回復処理
        int healing = data.getInt("healing");
        if (healing > 0 && player.tickCount % 20 == 0) {
            player.heal(2.0F);
            data.putInt("healing", healing - 1);
        }

        //リジェネとか何とか
        int check = data.getInt("wear");
        boolean whick1 = player.getInventory().hasAnyMatching(
                stack -> stack.getItem() == Item_registry.SEIMEI_NULL.get()
        );
        if (check == 1 && whick1) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,-1,1));
        }else{
            player.removeEffect(MobEffects.REGENERATION);
        }
        // 衝撃吸収とかなんとか
        boolean which2 = player.getInventory().hasAnyMatching(
                stack -> stack.getItem() == Item_registry.SYOGEKI_NULL.get()
        );
        int cooldown = data.getInt("cooldown");
        if (check == 2 && which2) {
            if (cooldown <= 0) {
                player.setAbsorptionAmount(8.0F);
                cooldown = 400;
            }
        }else {
            player.setAbsorptionAmount(0);
        }
        if (cooldown > 0) {
            cooldown--;
        }
        data.putInt("cooldown", cooldown);
    }
}