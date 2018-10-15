package rip.xzero.Handler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class JoinHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        this.setScoreboard(player);
    }

    public void setScoreboard(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj =  board.registerNewObjective("ServerName", "");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("Nothing");
        player.setScoreboard(board);
    }
}
