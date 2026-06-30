package com.mobzking.Player_something;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = "mobzking")
public class player_debuff_process {
    public static int bleeding = 0;
    @SubscribeEvent
    public static void player_hurt(LivingHurtEvent event){

        Entity check_monster = event.getSource().getEntity();
        if(check_monster instanceof Monster){
            int Random = ((Monster) check_monster).getRandom().nextInt(1);
            if(Random == 1) {
                System.out.println("出血");
                bleeding = 10;//単位秒
            }
        }
    }
}
