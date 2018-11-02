package me.jtrenaud1s.cis;

import me.jtrenaud1s.cis.command.CommandCItem;
import me.jtrenaud1s.cis.event.PlayerEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemMain extends JavaPlugin {
    private static CustomItemMain instance;
    @Override
    public void onLoad() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerEventListener(), this);
        getCommand("citem").setExecutor(new CommandCItem());
    }

    public static CustomItemMain getInstance() {
        if(instance == null)
            instance = new CustomItemMain();
        return instance;
    }
}
