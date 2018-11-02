package me.jtrenaud1s.cis.command;

import me.jtrenaud1s.cis.Utils;
import me.jtrenaud1s.cis.model.Weapon;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if (strings.length == 0) {
                Weapon[] weapons = Weapon.values();
                if (weapons.length == 0) {
                    p.sendMessage(ChatColor.RED + "There are no items to choose from! GET CODING!!");
                    return true;
                }
                StringBuilder sb = new StringBuilder(weapons[0].toString());

                for (int i = 1; i < weapons.length; i++) {
                    sb.append(", ").append(weapons[i].toString());
                }
                sb.append(".");
                p.sendMessage(ChatColor.YELLOW + "You must specify the item: " + ChatColor.GREEN + sb.toString());
                return true;
            } else {
                if(!Weapon.isWeapon(strings[0])){
                    p.sendMessage(ChatColor.RED + "That item doesn't exist!");
                    return true;
                }
                Weapon w = Weapon.fromString(strings[0]);
                if (w != null) {
                    p.getInventory().addItem(Utils.getWeapon(w));
                }
            }
            return true;
        }
        return false;
    }
}
