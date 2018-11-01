package me.jtrenaud1s.cis.api;


import me.jtrenaud1s.cis.api.v1_13_R2.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface NMS {
    ACustomItemStack newCustomItemStack();

    ACustomItemStack newCustomItemStack(Material type);

    ACustomItemStack newCustomItemStack(Material type, int amount);

    ACustomItemStack newCustomItemStack(ItemStack stack) throws IllegalArgumentException;

    ACustomItemStack newCustomItemStack(CustomItemStack stack);

    ACustomItemStack fromCraftItemStack(ItemStack stack);
}
