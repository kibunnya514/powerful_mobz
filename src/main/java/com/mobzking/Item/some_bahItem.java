package com.mobzking.Item;

import com.mobzking.touroku.Item_registry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import static com.mobzking.Player_something.player_debuff_process.bleeding;

public class some_bahItem extends Item {
    public some_bahItem(Properties properties) {
        super(properties);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player) {
            //行われる処理
            //生命の何か
            System.out.print("アイテムチェック");
            if (stack.is(Item_registry.SEIMEI.get())){
                player.getPersistentData().putInt("wear", 1);
                stack = new ItemStack(Item_registry.SEIMEI_NULL.get());
                player.getInventory().add(stack);
            }else if(stack.is(Item_registry.SYOGEKI.get())){
                player.getPersistentData().putInt("wear", 2);
                stack = new ItemStack(Item_registry.SYOGEKI_NULL.get());
                player.getInventory().add(stack);
            }
            stack.shrink(1);
        }
        return stack;
    }
}
