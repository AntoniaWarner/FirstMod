package net.antonia.firstmod.item;

import net.antonia.firstmod.FirstMod;
import net.antonia.firstmod.block.ModBlocks;
import net.antonia.firstmod.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> OBAMIUM = ITEMS.register("obamium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.OBAMIUM)));

    public static final RegistryObject<Item> OBAMIUM_WHEAT_SEEDS = ITEMS.register("obamium_wheat_seeds",
            () -> new ItemNameBlockItem(ModBlocks.OBAMIUM_WHEAT.get(), new Item.Properties().tab(ModCreativeModeTab.OBAMIUM)));

    public static final RegistryObject<Item> OBAMIUM_WHEAT_ITEM = ITEMS.register("obamium_wheat_item",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.OBAMIUM)));

    public static final RegistryObject<Item> OBAMIUM_BREAD = ITEMS.register("obamium_bread",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.OBAMIUM).food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.OBAMIUM).stacksTo(1)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
