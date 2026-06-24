package com.kingmobz;

import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mobzking")
public class addgoals {
    @SubscribeEvent
    public static void onspwan(MobSpawnEvent.FinalizeSpawn event) {
        Mob mobuireruyatu = event.getEntity();
        mobuireruyatu.goalSelector.addGoal(6,new set_block(mobuireruyatu));
    }
}

