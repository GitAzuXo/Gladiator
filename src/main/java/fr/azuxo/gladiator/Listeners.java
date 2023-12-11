package fr.azuxo.gladiator;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("§7(§a+§7) " + e.getPlayer().getName());
        Player pl = e.getPlayer();
        ScoreboardSign sb = new ScoreboardSign(pl, "§6Gladiators");
        sb.create();
        sb.setLine(3,"§0");
        sb.setLine(2, "§eClasse : " + Gladiator.fighter_class.get(pl));
        sb.setLine(1,"§0");
        sb.setLine(0,"§eCompte : " + pl.getName());
        Gladiator.boards.put(pl,sb);
        pl.getInventory().clear();
        pl.setFoodLevel(20);
        pl.setHealth(20);
        pl.setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(!Gladiator.game){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e){
        if(!Gladiator.game){
            e.setCancelled(true);
        }
    }
}
