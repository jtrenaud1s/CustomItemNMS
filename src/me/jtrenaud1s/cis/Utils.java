package me.jtrenaud1s.cis;

import me.jtrenaud1s.cis.api.NMS;
import org.bukkit.Bukkit;

public class Utils {

    private static NMS nms;

    static {
        if(nms == null){
            String version;

            try {
                version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
                if (version.equals("v1_13_R2")) {
                    nms = new me.jtrenaud1s.cis.api.v1_13_R2.CNMS();
                }
            } catch (ArrayIndexOutOfBoundsException whatVersionAreYouUsingException) { }
        }
    }

    public static NMS getNMS() {
        return nms;
    }
}
