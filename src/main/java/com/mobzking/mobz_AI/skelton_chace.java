package com.mobzking.mobz_AI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class skelton_chace extends Goal {
    int bomb_cool = 0;
    int brake_time = 0;
    int street_brake_time = 0;
    private final Mob mob;
    private int cooldown = 0;
        public skelton_chace(Mob mob) {
        this.mob = mob;
    }
    @Override
    public boolean canUse() {
        Player look_player = mob.level().getNearestPlayer(mob, 256);
        if (look_player != null && (mob instanceof Skeleton ||
                                    mob instanceof Pillager ||
                                    mob instanceof Stray)){
            return true;
        }
        return false;
    }
    @Override
    public void tick() {
        //下一行ティックの重複なくす用
        if (mob.level().isClientSide()) return;
        //プレイヤー追いかけプログラム、１６マス内にプレイヤーが来たらストップ。
        Player look_player = mob.level().getNearestPlayer(mob, 256);
        Player ranaway_player = mob.level().getNearestPlayer(mob, 16);
        if(ranaway_player == null && look_player != null){
            if (mob.tickCount % 20 == 0) {
            mob.getNavigation().moveTo(look_player, 1.2D);
        }
        }else{
            mob.getNavigation().stop();
        }
        //プレイヤーが超接近してきたら後ろにノックバックする
        Player player_knocback = mob.level().getNearestPlayer(mob, 2);
        if (player_knocback != null && cooldown <= 0){
            double dx = player_knocback.getX() - mob.getX();
            double dz = player_knocback.getZ() - mob.getZ();
            mob.knockback(0.8F, dx, dz);
            cooldown = 100;
        }
        cooldown--;
    }
}
