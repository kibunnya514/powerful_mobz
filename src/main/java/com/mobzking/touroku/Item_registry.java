package com.mobzking.touroku;
import com.mobzking.Item.CureItem;
import com.mobzking.Item.HealItem;
import com.mobzking.Item.some_bahItem;
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
            () -> new CureItem(new Item.Properties().stacksTo(4)));
    //プレイヤー強化アイテム（）
    public static final RegistryObject<Item> SEIMEI = ITEMS.register("seimei",
            () -> new some_bahItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SEIMEI_NULL = ITEMS.register("seimei_null",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SYOGEKI = ITEMS.register("syogeki",
            () -> new some_bahItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SYOGEKI_NULL = ITEMS.register("syogeki_null",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> REPAIR = ITEMS.register("repair",
            () -> new Item(new Item.Properties().stacksTo(1)));
}