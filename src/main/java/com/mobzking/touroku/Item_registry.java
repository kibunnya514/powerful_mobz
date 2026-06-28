package com.mobzking.touroku;
import com.mobzking.Item.CureItem;
import com.mobzking.Item.HealItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class Item_registry {
    //回復アイテム
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"mobzking");
    public static final RegistryObject<Item> MID_KIT = ITEMS.register("midkit",
            () -> new HealItem(new Item.Properties().durability(3)));
    //出血直しアイテム
    public static final RegistryObject<Item> BAND_AGE = ITEMS.register("bandage",
            () -> new CureItem(new Item.Properties().durability(1).stacksTo(4)));
}
