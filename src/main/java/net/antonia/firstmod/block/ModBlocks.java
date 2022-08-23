package net.antonia.firstmod.block;

import net.antonia.firstmod.FirstMod;
import net.antonia.firstmod.block.custom.JumpyBlock;
import net.antonia.firstmod.block.custom.ObamiumLampBlock;
import net.antonia.firstmod.block.custom.ObamiumWheatBlock;
import net.antonia.firstmod.item.ModCreativeModeTab;
import net.antonia.firstmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> OBAMIUM_BLOCK = registerBlock("obamium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.OBAMIUM);
    public static final RegistryObject<Block> OBAMIUM_ORE = registerBlock("obamium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.OBAMIUM);
    public static final RegistryObject<Block> DEEPSLATE_OBAMIUM_ORE = registerBlock("deepslate_obamium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.OBAMIUM);
    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.POWDER_SNOW)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.OBAMIUM);
    public static final RegistryObject<Block> OBAMIUM_LAMP = registerBlock("obamium_lamp",
            () -> new ObamiumLampBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(ObamiumLampBlock.LIT) ? 15 : 0)),
            ModCreativeModeTab.OBAMIUM);
    public static final RegistryObject<Block> OBAMIUM_WHEAT = BLOCKS.register("obamium_wheat",
            () -> new ObamiumWheatBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .strength(1f).requiresCorrectToolForDrops()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
