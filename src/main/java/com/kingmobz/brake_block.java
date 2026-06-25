package com.kingmobz;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
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
        if (player != null){
            System.out.print("ここはOK");
            return true;
        }
        System.out.print("動いてなーい");
        return false;
    }
    @Override
    public void tick(){
        Player player = mob.level().getNearestPlayer(mob, 256);
        double mob_y = mob.getY();
        double player_y = player.getY();
        if((mob_y-2) >= player_y){
            System.out.print("ちゃんと動いてる？");
            Level level = mob.level();
            BlockPos pos = mob.blockPosition().below();;
            level.destroyBlock(pos, false);
        }
        Level level = mob.level();
        BlockPos front = mob.blockPosition().relative(mob.getDirection());
        BlockPos frontTop = front.above();
        level.destroyBlock(front, false);
        level.destroyBlock(frontTop, false);
    }
}