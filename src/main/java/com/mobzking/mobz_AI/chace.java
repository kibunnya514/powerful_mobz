package com.mobzking.mobz_AI;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;


public class chace extends Goal {

    private final Mob mob;

    public chace(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        BlockPos pos = mob.blockPosition().below();
        BlockState state = mob.level().getBlockState(pos);{
            return true;
        }
    }

    @Override
    public void tick() {
        Player player = mob.level().getNearestPlayer(mob, 256);//追跡距離
        Player nameplatecheck = mob.level().getNearestPlayer(mob, 4);//モブのネームプレートがどの程度見えるか
        if (player != null) {
            if (mob instanceof ZombifiedPiglin || mob instanceof Zombie || mob instanceof Creeper || mob instanceof WitherSkeleton || mob instanceof PiglinBrute || mob instanceof Vindicator || mob instanceof Drowned ||mob instanceof Spider) {
                double player_x = player.getX();
                double player_y = player.getY();
                double player_z = player.getZ();
                mob.getMoveControl().setWantedPosition(player_x, player_y, player_z, 1.6);
            }
        }
        if(nameplatecheck != null){
            mob.setCustomNameVisible(true);
        }else{
            mob.setCustomNameVisible(false);
        }
    }
}