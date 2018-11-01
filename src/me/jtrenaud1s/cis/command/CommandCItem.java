package me.jtrenaud1s.cis.command;

import me.jtrenaud1s.cis.Utils;
import me.jtrenaud1s.cis.api.ACustomItemStack;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            ACustomItemStack stack = Utils.getNMS().newCustomItemStack(Material.STICK);
            stack.setMetadata("weaponType", "deathstick");
            p.getInventory().addItem(stack);
        }
        return false;
    }
}
