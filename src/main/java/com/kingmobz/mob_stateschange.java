package com.kingmobz;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = "mobzking")
public class mob_stateschange {
    @SubscribeEvent
    public static void mobchange(MobSpawnEvent.FinalizeSpawn event) {
        double health = 20;
        double attack = 4;
        LivingEntity mob = event.getEntity();
        if(mob instanceof Monster){
            //ステータス変更
            double level = mob.getRandom().nextInt(20) + 1;
            Component name = mob.getName();
            mob.setCustomName(Component.literal("LV" +(int)level + " " + mob.getName().getString()));
            level = level * 0.1;
            //HP
            mob.getAttribute(Attributes.MAX_HEALTH)
                    .setBaseValue(health*level);
            mob.setHealth((float) (health*level));
            //索敵
            mob.getAttribute(Attributes.FOLLOW_RANGE)
                    .setBaseValue(256.0D);
            //攻撃
            mob.getAttribute(Attributes.ATTACK_DAMAGE)
                    .setBaseValue(attack*level);
        }
    }
}
