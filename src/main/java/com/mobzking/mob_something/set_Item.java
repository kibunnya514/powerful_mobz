package com.mobzking.mob_something;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(
        modid = "mobzking"
)
public class set_Item {
    @SubscribeEvent
    public static void onSpawn(MobSpawnEvent.FinalizeSpawn event) {
        LivingEntity mobitem_set = event.getEntity();
        //ちびゾンビを湧かなくする
        if (event.getEntity() instanceof Zombie zombie){
            if (zombie.isBaby()) {
                zombie.setBaby(false);
            }
            Level time_day = mobitem_set.level();
            int sokoage = 0;
            long day = time_day.getLevelData().getGameTime() / 24000L;
            long mob_armoradd = day;//序盤は今日装備の確率
            if (mob_armoradd >= 100) {
                sokoage = (int) (mob_armoradd - 100) / 5 + 5;//時間経過で革装備などの低ランク装備が出にくくなる
            }
            int sord = 0;
            sord = mobitem_set.getRandom().nextInt(5);
            if (sord == 0) {
                int wh = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
                if (wh < 0) {
                    wh = wh + mobitem_set.getRandom().nextInt(55 + (int) mob_armoradd);
                }
                if (wh >= 95) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
                } else if (wh >= 80) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
                } else if (wh >= 50) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
                } else if (wh >= 20) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
                } else if (wh >= 0) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
                }
            }

            if (sord == 1) {
                int wh = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
                if (wh < 0) {
                    wh = wh + mobitem_set.getRandom().nextInt(55 + (int) mob_armoradd);
                }
                if (wh >= 95) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_AXE));
                } else if (wh >= 80) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_AXE));
                } else if (wh >= 50) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
                } else if (wh >= 20) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
                } else if (wh >= 0) {
                    mobitem_set.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
                }
            }

            int head = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
            if (head < 0) {
                head = head + mobitem_set.getRandom().nextInt(55 + (int) mob_armoradd);
                ;
            }
            if (head >= 90) {
                mobitem_set.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
            } else if (head >= 70) {
                mobitem_set.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
            } else if (head >= 50) {
                mobitem_set.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
            } else if (head >= 25) {
                mobitem_set.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.CHAINMAIL_HELMET));
            } else if (head >= 15) {
                mobitem_set.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
            } else if (head >= 10) {
                mobitem_set.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
            }

            int chest = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
            if (chest < 0) {
                chest = chest + mobitem_set.getRandom().nextInt(55 + (int) mob_armoradd);
                ;
            }
            if (chest >= 90) {
                mobitem_set.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
            } else if (chest >= 70) {
                mobitem_set.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
            } else if (chest >= 50) {
                mobitem_set.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
            } else if (chest >= 25) {
                mobitem_set.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
            } else if (chest >= 15) {
                mobitem_set.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
            } else if (chest >= 10) {
                mobitem_set.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
            }

            int legs = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
            if (legs < 0) {
                legs = legs + mobitem_set.getRandom().nextInt(55 + (int) mob_armoradd);
                ;
            }
            if (legs >= 90) {
                mobitem_set.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
            } else if (legs >= 70) {
                mobitem_set.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
            } else if (legs >= 50) {
                mobitem_set.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
            } else if (legs >= 25) {
                mobitem_set.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_LEGGINGS));
            } else if (legs >= 15) {
                mobitem_set.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
            } else if (legs >= 10) {
                mobitem_set.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
            }

            int feet = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
            if (feet < 0) {
                feet = feet + mobitem_set.getRandom().nextInt(55 + (int) mob_armoradd);
                ;
            }
            if (feet >= 90) {
                mobitem_set.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
            } else if (feet >= 70) {
                mobitem_set.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
            } else if (feet >= 50) {
                mobitem_set.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
            } else if (feet >= 25) {
                mobitem_set.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));
            } else if (feet >= 15) {
                mobitem_set.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
            } else if (feet >= 10) {
                mobitem_set.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
            }

            ItemStack mainhand_en = mobitem_set.getItemBySlot(EquipmentSlot.MAINHAND);
            ItemStack helmet_en = mobitem_set.getItemBySlot(EquipmentSlot.HEAD);
            ItemStack chest_en = mobitem_set.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack legs_en = mobitem_set.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack feet_en = mobitem_set.getItemBySlot(EquipmentSlot.FEET);
            int which = mobitem_set.getRandom().nextInt(100 + (int) mob_armoradd) - 70 + sokoage;
            int number = 0;
            int TF = 0;
            TF = mobitem_set.getRandom().nextInt(3);
            int level;
            if (TF == 0 && !mainhand_en.isEmpty()) {
                number = mobitem_set.getRandom().nextInt(8) + 1;

                for (int i = 0; i < number; ++i) {
                    which = mobitem_set.getRandom().nextInt(100) + 1;
                    if (which >= 70) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        mainhand_en.enchant(Enchantments.SHARPNESS, level);
                    } else if (which >= 50) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        mainhand_en.enchant(Enchantments.FIRE_ASPECT, level);
                    } else if (which >= 40) {
                        mainhand_en.enchant(Enchantments.UNBREAKING, 1);
                    } else if (which >= 25) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        mainhand_en.enchant(Enchantments.MENDING, level);
                    } else if (which >= 15) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        mainhand_en.enchant(Enchantments.KNOCKBACK, level);
                    } else if (which >= 0) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        mainhand_en.enchant(Enchantments.FIRE_ASPECT, level);
                    }
                }
            }

            TF = mobitem_set.getRandom().nextInt(3);
            if (TF == 0 && !helmet_en.isEmpty()) {
                number = mobitem_set.getRandom().nextInt(8) + 1;

                for (int i = 0; i < number; ++i) {
                    which = mobitem_set.getRandom().nextInt(100) + 1;
                    if (which >= 70) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        helmet_en.enchant(Enchantments.ALL_DAMAGE_PROTECTION, level);
                    } else if (which >= 50) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        helmet_en.enchant(Enchantments.UNBREAKING, level);
                    } else if (which >= 40) {
                        helmet_en.enchant(Enchantments.MENDING, 1);
                    } else if (which >= 25) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        helmet_en.enchant(Enchantments.PROJECTILE_PROTECTION, level);
                    } else if (which >= 5) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        helmet_en.enchant(Enchantments.FIRE_PROTECTION, level);
                    } else if (which >= 0) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        helmet_en.enchant(Enchantments.THORNS, level);
                    }
                }
            }

            TF = mobitem_set.getRandom().nextInt(3);
            if (TF == 0 && !chest_en.isEmpty()) {
                number = mobitem_set.getRandom().nextInt(8) + 1;

                for (int i = 0; i < number; ++i) {
                    which = mobitem_set.getRandom().nextInt(100) + 1;
                    if (which >= 70) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        chest_en.enchant(Enchantments.ALL_DAMAGE_PROTECTION, level);
                    } else if (which >= 50) {
                        level = mobitem_set.getRandom().nextInt(8) + 1;
                        chest_en.enchant(Enchantments.UNBREAKING, level);
                    } else if (which >= 40) {
                        chest_en.enchant(Enchantments.MENDING, 1);
                    } else if (which >= 25) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        chest_en.enchant(Enchantments.PROJECTILE_PROTECTION, level);
                    } else if (which >= 5) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        chest_en.enchant(Enchantments.FIRE_PROTECTION, level);
                    } else if (which >= 0) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        chest_en.enchant(Enchantments.THORNS, level);
                    }
                }
            }

            TF = mobitem_set.getRandom().nextInt(3);
            if (TF == 0 && !legs_en.isEmpty()) {
                number = mobitem_set.getRandom().nextInt(8) + 1;

                for (int i = 0; i < number; ++i) {
                    which = mobitem_set.getRandom().nextInt(100) + 1;
                    if (which >= 70) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        legs_en.enchant(Enchantments.ALL_DAMAGE_PROTECTION, level);
                    } else if (which >= 50) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        legs_en.enchant(Enchantments.UNBREAKING, level);
                    } else if (which >= 40) {
                        legs_en.enchant(Enchantments.MENDING, 1);
                    } else if (which >= 25) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        legs_en.enchant(Enchantments.PROJECTILE_PROTECTION, level);
                    } else if (which >= 5) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        legs_en.enchant(Enchantments.FIRE_PROTECTION, level);
                    } else if (which >= 0) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        legs_en.enchant(Enchantments.THORNS, level);
                    }
                }
            }

            TF = mobitem_set.getRandom().nextInt(3);
            if (TF == 0 && !feet_en.isEmpty()) {
                number = mobitem_set.getRandom().nextInt(8) + 1;

                for (int i = 0; i < number; ++i) {
                    which = mobitem_set.getRandom().nextInt(100) + 1;
                    if (which >= 70) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        feet_en.enchant(Enchantments.ALL_DAMAGE_PROTECTION, level);
                    } else if (which >= 50) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        feet_en.enchant(Enchantments.UNBREAKING, level);
                    } else if (which >= 40) {
                        feet_en.enchant(Enchantments.MENDING, 1);
                    } else if (which >= 25) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        feet_en.enchant(Enchantments.PROJECTILE_PROTECTION, level);
                    } else if (which >= 5) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        feet_en.enchant(Enchantments.FIRE_PROTECTION, level);
                    } else if (which >= 0) {
                        level = mobitem_set.getRandom().nextInt(4) + 1;
                        feet_en.enchant(Enchantments.THORNS, level);
                    }
                }
            }
        }
    }
}
