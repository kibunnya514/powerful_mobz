package com.mobzking.Player_something;

import com.mobzking.touroku.Item_registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import static com.mobzking.Player_something.player_debuff_process.bleeding;

@Mod.EventBusSubscriber(modid = "mobzking")
public class player_tick_process {
    public static int healing = 0;
    private int bahslot = 0;

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
    }

    @SubscribeEvent
    public static void Player_tick(TickEvent.PlayerTickEvent event) {
        //下の３行は１ティックに重複処理されないようにするため。
        Player player = event.player;
        if (event.phase != TickEvent.Phase.END) return;
        if (event.player.level().isClientSide()) return;
        //出血中は毎秒ダメージを受ける
        if (bleeding > 0 && player.tickCount % 40 == 0) {
            System.out.print(bleeding);
            player.hurt(player.damageSources().generic(), 1.0F);
            bleeding = bleeding - 1;
        }
        //回復アイテム処理
        if (healing > 0 && player.tickCount % 20 == 0) {
            player.heal(2.0F); // ハート1個分回復
            healing = healing - 1;
        }
        //バフアイテム処理各種
        //再生の何か
        int check = player.getPersistentData().getInt("wear");
        boolean which = player.getInventory().contains(new ItemStack(Item_registry.SEIMEI_NULL.get()));
         if(check == 1 && which == true){
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1));
        }
    }
}
