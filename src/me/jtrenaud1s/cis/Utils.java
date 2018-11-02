package me.jtrenaud1s.cis;

import me.jtrenaud1s.cis.api.ACustomItemStack;
import me.jtrenaud1s.cis.api.NMS;
import me.jtrenaud1s.cis.model.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

    private static NMS nms;

    static {
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            if (version.equals("v1_13_R2")) {
                nms = new me.jtrenaud1s.cis.api.v1_13_R2.CNMS();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static NMS getNMS() {
        return nms;
    }

    public static ACustomItemStack getWeapon(Weapon weapon) {
        ACustomItemStack stack = getNMS().newCustomItemStack(weapon.getType());
        stack.setMetadata("weaponType", weapon.getTag());
        return stack;
    }

    private static boolean isWeapon(ACustomItemStack stack, Weapon weapon) {
        return stack.hasMetadata("weaponType") && stack.getMetadata("weaponType").equals(weapon.toString());
    }

    public static boolean isItemInHandWeapon(Player player, Weapon weapon) {
        ACustomItemStack stack = Utils.getNMS().fromCraftItemStack(player.getInventory().getItemInMainHand());
        return isWeapon(stack, weapon);
    }
}
