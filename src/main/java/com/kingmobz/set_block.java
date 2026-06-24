package com.kingmobz;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class set_block extends Goal {

    private final Mob mob;

    public set_block(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        BlockPos posion = mob.blockPosition().below();
        BlockState asimoto = mob.level().getBlockState(posion);
        if (asimoto.isAir()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void tick() {
        Player player = mob.level().getNearestPlayer(mob, 32);
        if (player != null) {
            double mob_y = mob.getY();
            double player_y = player.getY();
            if (Math.abs(mob_y - player_y) >= 2 && player != null && (mob_y-1) <= player_y) {
                System.out.print("ジャンプ…するはず");
                mob.setDeltaMovement(
                        mob.getDeltaMovement().x,
                        0.4,
                        mob.getDeltaMovement().z
                );
                BlockPos posion = mob.blockPosition().below();
                mob.level().setBlock(posion, Blocks.DEEPSLATE.defaultBlockState(), 3);
            }else if(mob_y <= player_y) {
                System.out.println("diff = " + Math.abs(mob.getY() - player.getY()));
                BlockPos posion = mob.blockPosition().below();
                mob.level().setBlock(posion, Blocks.DEEPSLATE.defaultBlockState(), 3);
            }
        }
    }
}