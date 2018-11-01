package me.jtrenaud1s.cis.api;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class ACustomItemStack extends ItemStack implements CustomNBT {
    public ACustomItemStack() {
        super();
    }

    public ACustomItemStack(Material type) {
        super(type);
    }

    public ACustomItemStack(Material type, int amount) {
        super(type, amount);
    }

    public ACustomItemStack(ItemStack stack) throws IllegalArgumentException {
        super(stack);
    }

    public ACustomItemStack(ACustomItemStack stack) {
        super(stack);
    }
}
