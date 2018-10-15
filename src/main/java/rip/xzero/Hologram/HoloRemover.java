package rip.xzero.Hologram;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class HoloRemover extends BukkitRunnable {

    public Hologram hologram;

    public int timer = 10;

    public HoloRemover(Hologram holo){
        this.hologram = holo;
    }

    public void run() {

        if(this.timer > 0){
            this.hologram.insertTextLine(2, ChatColor.GREEN + "Removing myself in: " + ChatColor.RED + this.timer + "s");
            try {
                this.hologram.removeLine(3);
            } catch (Exception e){

            }
            this.timer--;
        } else {
            hologram.delete();

            try {
                this.cancel();
            } catch (Exception e){
                // Do nothing
            }
        }
    }
}
