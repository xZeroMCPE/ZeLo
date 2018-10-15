package rip.xzero.Handler;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import rip.xzero.Hologram.HoloRemover;
import rip.xzero.Score.Score;
import rip.xzero.ZeLo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovementHandler implements Listener {

    public Map<Player, Score> scoreMap = new HashMap<Player, Score>();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        player.sendMessage("Total movement: " + this.getScore(player));
        this.scoreMap.get(player).increaseScore();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        Hologram hologram = HologramsAPI.createHologram(ZeLo.getInstance(), player.getLocation().add(0, 2, 0));
        String message = ZeLo.getInstance().getConfig().getString("hologram_header");
        String betterMessage = message.replace("{PLAYER}", player.getDisplayName());

        hologram.appendTextLine(betterMessage);
        hologram.appendTextLine("You walked for a total of " + this.getScore(player));

        ZeLo.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(ZeLo.getInstance(), new HoloRemover(hologram), 0, 20);
    }

    public int getScore(Player player) {
        if (!scoreMap.containsKey(player)){
            scoreMap.put(player, new Score());
        }
        return scoreMap.get(player).getScore();
    }
}
