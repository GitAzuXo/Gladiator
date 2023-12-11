package fr.azuxo.gladiator;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Gladiator extends JavaPlugin {

    static HashMap<Player, String> fighter_class = new HashMap<Player, String>();
    static HashMap<Player, ScoreboardSign> boards = new HashMap<Player, ScoreboardSign>();
    static boolean game = false;

    @Override
    public void onEnable() {
        System.out.println("(Gladiator) Plugin Enabled !");
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);
        this.getCommand("class").setExecutor(new ClassChoose());
        this.getServer().getWorld("world").setGameRuleValue("doDaylightCycle", "false");
        this.getServer().getWorld("world").setTime(6000);
    }

    @Override
    public void onDisable() {
        System.out.println("(Gladiator) Plugin Disabled !");
    }
}
