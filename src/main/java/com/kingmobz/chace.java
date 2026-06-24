package com.kingmobz;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;


public class chace extends Goal {

    private final Mob mob;

    public chace(Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {

        return true;//ここに実行するか否かの条件を記入する。
    }

    @Override
    public void tick() {
        Player player = mob.level().getNearestPlayer(mob, 256);//追跡距離
        if (player != null) {
            if (mob instanceof ZombifiedPiglin || mob instanceof Zombie || mob instanceof Creeper || mob instanceof WitherSkeleton || mob instanceof PiglinBrute || mob instanceof Vindicator || mob instanceof Drowned) {
                double player_x = player.getX();
                double player_y = player.getY();
                double player_z = player.getZ();
                mob.getMoveControl().setWantedPosition(player_x, player_y, player_z, 1.5);
            }
        }
    }
}