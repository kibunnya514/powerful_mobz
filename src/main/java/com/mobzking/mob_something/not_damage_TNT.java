package com.mobzking.mob_something;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
public class not_damage_TNT {

    @Mod.EventBusSubscriber(modid = "mobzking")
    public class HurtEvent {
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event) {
            if(event.getEntity() instanceof Monster mob && event.getSource().is(DamageTypes.EXPLOSION)){
                event.setCanceled(true);
            }
        }
    }
}
