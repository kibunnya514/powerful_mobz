package com.kingmobz.touroku;

import com.kingmobz.mobz_AI.brake_block;
import com.kingmobz.mobz_AI.chace;
import com.kingmobz.mobz_AI.set_block;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mobzking")
public class addgoals {
    @SubscribeEvent
    public static void onspwan(MobSpawnEvent.FinalizeSpawn event) {
        Mob mobuireruyatu = event.getEntity();
        if (mobuireruyatu instanceof Monster) {
            mobuireruyatu.goalSelector.addGoal(6, new set_block(mobuireruyatu));
            mobuireruyatu.goalSelector.addGoal(2, new chace(mobuireruyatu));
            mobuireruyatu.goalSelector.addGoal(8, new brake_block(mobuireruyatu));
        }
    }
}

