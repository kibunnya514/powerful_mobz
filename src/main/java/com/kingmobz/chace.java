package com.kingmobz;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;


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
       //ここに実際に行う行動を記入する。
    }
}