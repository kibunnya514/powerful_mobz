package com.mobzking.mobz_AI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class brake_block extends Goal {
    int bomb_cool = 0;
    int street_brake_time = 0;
    private final Mob mob;
    private int Random,kamase;
    public brake_block(Mob mob) {
        this.mob = mob;
    }
    @Override
    public boolean canUse(){
        Player player = mob.level().getNearestPlayer(mob, 256);
        if (player != null && mob instanceof Monster &&
        !(mob instanceof Skeleton) &&
        !(mob instanceof Pillager) &&
        !(mob instanceof Blaze) &&
        !(mob instanceof Ghast) &&
        !(mob instanceof Creeper)){
            return true;
        }
        return false;
    }
    @Override
    public void tick(){
        //下一行ティックの重複なくす用
        if (mob.level().isClientSide()) return;
        Player player = mob.level().getNearestPlayer(mob, 256);
        double mob_y = mob.getY();
        double player_y = player.getY();
        if((mob_y-2) >= player_y){
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().below();
            level.destroyBlock(pos, false);
        }
        if(street_brake_time == 0){
            Level level = mob.level();
            BlockPos front = mob.blockPosition().relative(mob.getDirection());
            BlockPos frontTop = front.above(1);
            level.destroyBlock(front, false);
            level.destroyBlock(frontTop, false);
            street_brake_time = 10;
        }
        //爆弾設置プログラム
        Player bom_check =mob.level().getNearestPlayer(mob, 4);
        Random = mob.getRandom().nextInt(100);
        if(Random == 0){
            kamase = 1;
        }
        if(bom_check != null && bomb_cool <= 0 && kamase == 1){
        //TNT設置プログラムを書く
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().above(1);
            PrimedTnt tnt = new PrimedTnt(level, pos.getX(), pos.getY(), pos.getZ(), null);
            level.addFreshEntity(tnt);
            kamase = 0;
            bomb_cool = 200;
        }
        street_brake_time = street_brake_time-1;
        bomb_cool = bomb_cool - 1;
    }
}