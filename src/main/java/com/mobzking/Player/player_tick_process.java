package com.mobzking.Player;

import com.mobzking.touroku.Item_registry;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

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
            ServerLevel level = (ServerLevel) player.level();
            var rand = player.getRandom();

            double x = player.getX();
            double y = player.getY() + 1.0;
            double z = player.getZ();

            //（赤ダスト）
            for (int i = 0; i < 15; i++) {
                double ox = (rand.nextDouble() - 0.5) * 0.6;
                double oy = rand.nextDouble() * 0.8;
                double oz = (rand.nextDouble() - 0.5) * 0.6;
                level.sendParticles(
                        new DustParticleOptions(new Vector3f(0.8F, 0.0F, 0.0F), 1.1F),
                        x + ox,
                        y + oy,
                        z + oz,
                        1,
                        0,
                        0,
                        0,
                        0.02
                );
            }
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
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 0));
            } else {
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
            } else {
                player.setAbsorptionAmount(0);
            }
            if (cooldown > 0) {
                cooldown--;
            }
            data.putInt("cooldown", cooldown);
    }
}