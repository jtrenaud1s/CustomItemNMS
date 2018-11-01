package me.jtrenaud1s.cis.event;

import me.jtrenaud1s.cis.CustomItemMain;
import me.jtrenaud1s.cis.Utils;
import me.jtrenaud1s.cis.api.ACustomItemStack;
import net.minecraft.server.v1_13_R2.ItemStack;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class PlayerEventListener implements Listener {

    private CustomItemMain plugin;

    public PlayerEventListener(CustomItemMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAttackEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            ACustomItemStack stack = Utils.getNMS().fromCraftItemStack(attacker.getInventory().getItemInMainHand());
            if(stack.hasMetadata("weaponType")) {
                if(stack.getMetadata("weaponType").equals("deathstick")){
                    Location l = attacker.getEyeLocation().clone();
                    l.setPitch(0F);
                    Vector v = l.getDirection().normalize().multiply(10 * 0.41999998688697815D);
                    event.getEntity().setVelocity(v);
                }
            }
        }
    }
}
