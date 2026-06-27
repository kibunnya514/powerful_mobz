package com.mobzking.mobz_AI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
public class set_block extends Goal {

    private final Mob mob;

    public set_block(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        BlockPos posion = mob.blockPosition().below();
        BlockState asimoto = mob.level().getBlockState(posion);
        return true;
    }

    @Override
    public void tick() {
        int time = 0;
        int time_jump = 0;
        Player player = mob.level().getNearestPlayer(mob, 32);
        if (player != null) {
            int kakuritu;
            if (mob instanceof ZombifiedPiglin || mob instanceof Zombie || mob instanceof Creeper || mob instanceof WitherSkeleton || mob instanceof PiglinBrute || mob instanceof Vindicator || mob instanceof Drowned) {
                //モブの見てくる方向をプレイヤーに固定
                mob.getLookControl().setLookAt(player, 30.0F, 30.0F);
                double dx = player.getX() - mob.getX();
                double dz = player.getZ() - mob.getZ();
                mob.setYRot((float) (Math.atan2(dz, dx) * (180 / Math.PI)) - 90);
                double mob_y = mob.getY();
                double player_y = player.getY();
                if (Math.abs(mob_y - player_y) >= 1 && player != null && mob_y <= player_y && time < 0) {
                    //縦積みのプログラム
                    mob.setDeltaMovement(
                            mob.getDeltaMovement().x,
                            0.4,
                            mob.getDeltaMovement().z
                    );
                    BlockPos posion = mob.blockPosition().below();
                    if (mob.level().getBlockState(mob.blockPosition().below()).isAir()||mob.level().getBlockState(mob.blockPosition().below()).is(Blocks.LAVA)) {
                        mob.level().setBlock(posion, Blocks.COBBLESTONE.defaultBlockState(), 3);
                        time = 10;
                    }
                } else if (mob_y <= player_y) {
                    //橋を架けるプログラム
                    BlockPos posion = mob.blockPosition().below();
                    if (mob.level().getBlockState(mob.blockPosition().below()).isAir()||mob.level().getBlockState(mob.blockPosition().below()).is(Blocks.LAVA)) {
                        mob.level().setBlock(posion, Blocks.COBBLESTONE.defaultBlockState(), 3);
                    }
                }
            }
            time = time - 1;
        }
        time_jump = time_jump -1;
    }
}