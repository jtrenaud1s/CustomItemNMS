package me.jtrenaud1s.cis.event;

import me.jtrenaud1s.cis.CustomItemMain;
import me.jtrenaud1s.cis.Utils;
import me.jtrenaud1s.cis.api.ACustomItemStack;
import me.jtrenaud1s.cis.model.IceCube;
import me.jtrenaud1s.cis.model.Weapon;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class PlayerEventListener implements Listener {

    private List<Projectile> snowballs = new ArrayList<>();
    private List<IceCube> iceCubes = new ArrayList<>();

    @EventHandler
    public void onAttackEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            if(Utils.isItemInHandWeapon(attacker, Weapon.DEATH_STICK)){
                Location l = attacker.getEyeLocation().clone();
                l.setPitch(0F);
                Vector v = l.getDirection().normalize().multiply(10 * 0.41999998688697815D);
                event.getEntity().setVelocity(v);
            }
        }
    }

    @EventHandler
    public void onRightClickWithItem(PlayerInteractEvent event) {
        Player attacker = event.getPlayer();
        if(Utils.isItemInHandWeapon(attacker, Weapon.ICE_STAFF)) {
            Snowball s = attacker.launchProjectile(Snowball.class);
            Location l = attacker.getEyeLocation().clone();
            Vector v = l.getDirection().normalize().multiply(5);
            s.setVelocity(v);
            snowballs.add(s);
        }
    }

    @EventHandler
    public void onSnowballHitPlayer(ProjectileHitEvent event) {
        Entity entity = event.getHitEntity();
        if(snowballs.contains(event.getEntity())){
            if(entity == null){
                snowballs.remove(event.getEntity());
                return;
            }
            IceCube cube = new IceCube(entity);
            iceCubes.add(cube);
            cube.generateIce();
        }
    }

    @EventHandler
    public void onBreakIceBlock(BlockBreakEvent event) {
        Block b = event.getBlock();
        for(IceCube cube : iceCubes) {
            if(cube.isIceBlock(b)) {
                cube.destroy();
                iceCubes.remove(cube);
                return;
            }
        }
    }
}
