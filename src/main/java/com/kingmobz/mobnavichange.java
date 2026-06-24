package com.kingmobz;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class mobnavichange{

    @Inject(method = "createNavigation", at = @At("HEAD"), cancellable = true)
    private void changeNav(Level level, CallbackInfoReturnable<PathNavigation> cir) {
        if ((Object)this instanceof Monster mob) {
            cir.setReturnValue(new FlyingPathNavigation((Mob) (Object) this, level));
        }
    }
}
