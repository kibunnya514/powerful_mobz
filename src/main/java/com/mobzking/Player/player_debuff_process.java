package com.mobzking.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
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
            int Random = ((Monster) check_monster).getRandom().nextInt(10);
            if(Random == 0){
                Player player = (Player) event.getEntity();
                CompoundTag data = player.getPersistentData();
                data.putInt("bleeding",8);
            }
        }
    }
}
