package me.jtrenaud1s.cis;

import me.jtrenaud1s.cis.api.ACustomItemStack;
import me.jtrenaud1s.cis.command.CommandCItem;
import me.jtrenaud1s.cis.event.PlayerEventListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemMain extends JavaPlugin {
    @Override
    public void onLoad() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerEventListener(this), this);
        getCommand("citem").setExecutor(new CommandCItem());
    }
}
