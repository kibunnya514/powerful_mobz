package com.kingmobz.mobz_AI;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class piglinangry {
    public piglinangry() {
    }

    @SubscribeEvent
    public static void angry(MobSpawnEvent.FinalizeSpawn event) {
        Mob var2 = event.getEntity();
        if (var2 instanceof PathfinderMob mob) {
            if (mob instanceof Piglin || mob instanceof ZombifiedPiglin) {
                mob.goalSelector.addGoal(3, new NearestAttackableTargetGoal(mob, Player.class, true));
                mob.setAggressive(true);
            }
        }

    }
}
