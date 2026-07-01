package com.mobzking.Player;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

@Mod.EventBusSubscriber(modid = "mobzking")
public class bleeding_effect {

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        //未来の俺へ、プレイヤーNBTにbleedingの変数、切り替えておいてね。よろしく
        Player player = event.player;
        //下二行は１ティック４回処理を消すプログラム
        if (event.phase != TickEvent.Phase.END) return;
        if (!player.level().isClientSide()) return;
        if (player_debuff_process.bleeding > 0){
            Vector3f bloodColor = new Vector3f(1.0f, 0.1f, 0.1f);
            DustParticleOptions blood = new DustParticleOptions(bloodColor, 1.0f);
                player.level().addParticle(
                        blood,
                        player.getX()+(Math.random() * 2 - 1)/4,
                        player.getY()+0.5,
                        player.getZ()+(Math.random() * 2 - 1)/4,
                        (Math.random() - 0.5) * 0.1,
                        -0.1,
                        (Math.random() - 0.5) * 0.1
                );
            }
        }
    }