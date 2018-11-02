package me.jtrenaud1s.cis.model;

import org.bukkit.Material;

public enum Weapon {
    DEATH_STICK("deathstick", Material.BLAZE_ROD),
    ICE_STAFF("icestaff", Material.DIAMOND_HOE);

    private String tag;
    private Material type;

    Weapon(String tag, Material type){
        this.tag = tag;
        this.type = type;
    }

    public String toString() {
        return tag;
    }

    public String getTag() {
        return tag;
    }

    public Material getType() {
        return type;
    }

    public static boolean isWeapon(String s) {
        return fromString(s) != null;
    }

    public static Weapon fromString(String s) {
        for(Weapon w : Weapon.values()){
            if(w.tag.equalsIgnoreCase(s)) {
                return w;
            }
        }
        return null;
    }
}
