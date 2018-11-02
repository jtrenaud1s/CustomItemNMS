package me.jtrenaud1s.cis.model;

import me.jtrenaud1s.cis.CustomItemMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class IceCube {
    private Location location;
    private Map<Block, Material> blocks;
    private BukkitTask sound;

    public IceCube(Entity p) {
        this.location = p.getLocation().clone();
        p.teleport(new Location(location.getWorld(),
                location.getBlockX() + .5,
                location.getBlockY(),
                location.getBlockZ() + .5,
                location.getYaw(),
                location.getPitch()));
        blocks = new HashMap<>();
    }

    public void generateIce() {
        Location feet = location.getBlock().getLocation();
        Location eye = location.getBlock().getRelative(0, 1, 0).getLocation();
        for(int i = 0; i < 3; i++) {
            for(int j = -1; j < 2; j++){
                for(int k = -1; k < 2; k++){
                    Location current = feet.getBlock().getRelative(j, i, k).getLocation();
                    if(!current.equals(feet) && !current.equals(eye) && !current.getBlock().getType().equals(Material.ICE)){
                        blocks.put(current.getBlock(), current.getBlock().getType());
                        current.getBlock().setType(Material.ICE);
                    }
                }
            }
        }
         sound = Bukkit.getServer().getScheduler().runTaskTimer(CustomItemMain.getInstance(), () -> {
             for(Player p : Bukkit.getOnlinePlayers()) {
                 p.playSound(location, Sound.BLOCK_GLASS_BREAK, 1, 10);
             }
         }, 0L, 20L);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CustomItemMain.getInstance(), () -> {
            if(blocks.size() > 0){
                destroy();
                sound.cancel();
            }
        }, 81);

    }

    public void destroy() {
        for(Block b : blocks.keySet()) {
            b.setType(blocks.get(b));
        }
        blocks.clear();
        sound.cancel();
    }

    public boolean isIceBlock(Block b) {
        return blocks.containsKey(b);
    }
}
