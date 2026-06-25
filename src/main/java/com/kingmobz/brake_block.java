package com.kingmobz;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

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
        Player player = mob.level().getNearestPlayer(mob, 256);
        double mob_y = mob.getY();
        double player_y = player.getY();
        if((mob_y-2) >= player_y){
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().below();;
            level.destroyBlock(pos, false);
        }
        Level level = mob.level();
        BlockPos front = mob.blockPosition().relative(mob.getDirection());
        BlockPos frontTop = front.above();
        level.destroyBlock(front, false);
        level.destroyBlock(frontTop, false);
        //爆弾設置プログラム
        int time = 0;
        Player bom_check =mob.level().getNearestPlayer(mob, 5);
        int Random = mob.getRandom().nextInt(100);
        if(bom_check != null && Random == 0 && time == 0){
        //TNT設置プログラムを書く
            BlockPos pos = mob.blockPosition().above(2);
            PrimedTnt tnt = new PrimedTnt(level, pos.getX(), pos.getY(), pos.getZ(), null);
            level.addFreshEntity(tnt);
            time = 200;
        }
        time = time-1;
    }
}