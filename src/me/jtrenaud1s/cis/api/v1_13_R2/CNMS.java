package me.jtrenaud1s.cis.api.v1_13_R2;

import me.jtrenaud1s.cis.api.ACustomItemStack;
import me.jtrenaud1s.cis.api.NMS;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


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
        ItemStack s = (ItemStack) stack;
        ItemMeta meta = CraftItemStack.getItemMeta(CraftItemStack.asNMSCopy(s));
        CustomItemStack cis = new CustomItemStack(s);
        cis.setItemMeta(meta);
        return cis;
    }
}
