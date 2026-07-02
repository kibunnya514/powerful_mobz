package com.mobzking.Item;
import com.mobzking.touroku.Item_registry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
public class lootback extends Item {
    public lootback(Properties properties) {
        super(properties);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 100;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player) {
            int random = entity.getRandom().nextInt(2);
            if (random == 0) {
                stack = new ItemStack(Item_registry.SYOGEKI.get());
                player.getInventory().add(stack);
            }else if (random == 1) {
                stack = new ItemStack(Item_registry.SEIMEI.get());
                player.getInventory().add(stack);
            }
            stack.shrink(1);
        }
        return stack;
    }
}

