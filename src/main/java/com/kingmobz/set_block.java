package com.kingmobz;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

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
        int time = 0;
        Player player = mob.level().getNearestPlayer(mob, 32);
        if (player != null ) {
            int kakuritu;
            if(mob instanceof ZombifiedPiglin || mob instanceof Zombie ||mob instanceof Creeper || mob instanceof WitherSkeleton || mob instanceof PiglinBrute|| mob instanceof Vindicator || mob instanceof Drowned){
                mob.getLookControl().setLookAt(player, 30.0F, 30.0F);
                double dx = player.getX() - mob.getX();
                double dz = player.getZ() - mob.getZ();
                mob.setYRot((float)(Math.atan2(dz, dx) * (180 / Math.PI)) - 90);
            double mob_y = mob.getY();
            double player_y = player.getY();
            if (Math.abs(mob_y - player_y) >= 1 && player != null && mob_y <= player_y && time < 0) {
                System.out.print("ジャンプ…するはず");
                kakuritu = mob.getRandom().nextInt(10);
                    mob.setDeltaMovement(
                            mob.getDeltaMovement().x,
                            0.4,
                            mob.getDeltaMovement().z
                    );

                    BlockPos posion = mob.blockPosition().below();
                    mob.level().setBlock(posion, Blocks.DEEPSLATE.defaultBlockState(), 3);
                    time = 10;
            }else if(mob_y <= player_y) {
                BlockPos posion = mob.blockPosition().below();
                mob.level().setBlock(posion, Blocks.DEEPSLATE.defaultBlockState(), 3);
                }
            }
        }
        time = time - 1;
    }
}