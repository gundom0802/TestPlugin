package testplugin.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import testplugin.testplugin.util.HotbarSetUtil;

public class HotbarDisable implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if(!(sender instanceof ConsoleCommandSender || sender instanceof Player)) {
            sender.sendMessage("Only humans can run this command");
            return true;

        }
        if (args.length != 1) {
            return false;
        }

        Player pl = Bukkit.getPlayer(args[0]);
        if (pl == null) {
            sender.sendMessage("This player does not exist");
            return true;
        }


        if (!(HotbarSetUtil.getSet(pl.getUniqueId().toString()))) {
            Bukkit.getLogger().info(args[0] + "already has hotbarlock disabled");
        }
        else {
            HotbarSetUtil.removeSet(pl.getUniqueId().toString());
            Bukkit.getLogger().info("Hotbarlock disabled for " + args[0]);
        }
        return true;

    }
}
