package rip.xzero;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import rip.xzero.Handler.JoinHandler;
import rip.xzero.Handler.MovementHandler;
import rip.xzero.ZeConfig.ZeConfig;

public class ZeLo extends JavaPlugin {

    public static ZeLo instance;


    public static ZeLo getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        this.setup();
    }

    private void setup() {
        this.instance = this;

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new MovementHandler(), this);
        this.getServer().getPluginManager().registerEvents(new JoinHandler(), this);

        this.getServer().getLogger().info("LOADED! We're all good ;)");
    }
}
