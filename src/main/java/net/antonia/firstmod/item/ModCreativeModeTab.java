package net.antonia.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab OBAMIUM = new CreativeModeTab("obamiumtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OBAMIUM.get());
        }
    };
}
