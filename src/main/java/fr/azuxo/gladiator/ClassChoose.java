package fr.azuxo.gladiator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

import static fr.azuxo.gladiator.Gladiator.boards;

public class ClassChoose implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


        if(sender instanceof Player){
            Player pl = (Player) sender;

            if(args.length == 0){
                pl.sendMessage("§cYou can't use this command without arguments !");
                return true;
            } else if(args[0].equalsIgnoreCase("get")){
                Gladiator.fighter_class.put(pl, args[1]);
                boards.get(pl).setLine(2, "§eClasse : " + Gladiator.fighter_class.get(pl));
                pl.sendMessage("§aClass correctly updated !");
                return true;
            } else if(args[0].equalsIgnoreCase("see")){
                pl.sendMessage("§aYour current class is : " + Gladiator.fighter_class.get(pl));
                return true;
            }
        }
        return false;
    }
}
