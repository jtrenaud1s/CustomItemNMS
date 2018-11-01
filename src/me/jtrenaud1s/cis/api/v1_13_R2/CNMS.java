package me.jtrenaud1s.cis.api.v1_13_R2;

import me.jtrenaud1s.cis.api.ACustomItemStack;
import me.jtrenaud1s.cis.api.NMS;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public class CNMS implements NMS {

    @Override
    public ACustomItemStack newCustomItemStack() {
        return new CustomItemStack();
    }

    @Override
    public ACustomItemStack newCustomItemStack(Material type) {
        return new CustomItemStack(type);
    }

    @Override
    public ACustomItemStack newCustomItemStack(Material type, int amount) {
        return new CustomItemStack(type, amount);
    }

    @Override
    public ACustomItemStack newCustomItemStack(ItemStack stack) throws IllegalArgumentException {
        return new CustomItemStack(stack);
    }

    @Override
    public ACustomItemStack newCustomItemStack(CustomItemStack stack) {
        return new CustomItemStack(stack);
    }

    @Override
    public ACustomItemStack fromCraftItemStack(ItemStack stack) {
        return new CustomItemStack(stack);
    }
}
