package me.jtrenaud1s.cis.api;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class ACustomItemStack extends ItemStack implements CustomNBT {
    protected ACustomItemStack() {
        super();
    }

    protected ACustomItemStack(Material type) {
        super(type);
    }

    protected ACustomItemStack(Material type, int amount) {
        super(type, amount);
    }

    protected ACustomItemStack(ItemStack stack) throws IllegalArgumentException {
        super(stack);
    }

    protected ACustomItemStack(ACustomItemStack stack) {
        super(stack);
    }
}
