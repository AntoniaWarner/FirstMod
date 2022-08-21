package net.antonia.firstmod.item;

import net.antonia.firstmod.FirstMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> OBAMIUM = ITEMS.register("obamium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.OBAMIUM)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
