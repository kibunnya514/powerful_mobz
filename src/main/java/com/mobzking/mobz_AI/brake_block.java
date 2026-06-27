package com.mobzking.mobz_AI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class brake_block extends Goal {

    private final Mob mob;

    public brake_block(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        Player player = mob.level().getNearestPlayer(mob, 256);
        if (player != null && mob instanceof Monster) {
            return true;
        }
        return false;
    }
    @Override
    public void tick(){
        int brake_time = 0;
        int street_brake_time = 0;
        Player player = mob.level().getNearestPlayer(mob, 256);
        double mob_y = mob.getY();
        double player_y = player.getY();
        if((mob_y-2) >= player_y){
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().below();;
            level.destroyBlock(pos, false);
        }
        if(mob_y <= player_y && brake_time == 0){
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().above(1);
            level.destroyBlock(pos, false);
            brake_time = 0;//上方向のブロック破壊のクールダウン
        }
        if(street_brake_time == 0){
            Level level = mob.level();
            BlockPos front = mob.blockPosition().relative(mob.getDirection());
            BlockPos frontTop = front.above(2);
            level.destroyBlock(front, false);
            level.destroyBlock(frontTop, false);
            street_brake_time = 5;
        }
        //爆弾設置プログラム
        int time = 20;
        Player bom_check =mob.level().getNearestPlayer(mob, 5);
        int Random = mob.getRandom().nextInt(500);
        if(bom_check != null && Random == 0 && time == 0){
        //TNT設置プログラムを書く
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().above(2);
            PrimedTnt tnt = new PrimedTnt(level, pos.getX(), pos.getY(), pos.getZ(), null);
            level.addFreshEntity(tnt);
            time = 200;
        }
        time = time-1;
        brake_time = brake_time-1;
        street_brake_time = street_brake_time-1;
    }
}