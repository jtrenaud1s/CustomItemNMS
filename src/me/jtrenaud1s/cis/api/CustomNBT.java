package me.jtrenaud1s.cis.api;

import me.jtrenaud1s.cis.Utils;
import org.bukkit.inventory.ItemStack;

public interface CustomNBT {
    void setMetadata(String metadata, Object value);

    boolean hasMetadata(String metadata);

    Object getMetadata(String metadata);

    Object getObject(Object tag);
}
