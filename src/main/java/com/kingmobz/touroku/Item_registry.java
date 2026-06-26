package com.kingmobz.touroku;
import com.kingmobz.Item.healItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class Item_registry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"mobzking");
    public static final RegistryObject<Item> name = ITEMS.register("midkit",
            () -> new healItem(new Item.Properties().durability(3)));
}
