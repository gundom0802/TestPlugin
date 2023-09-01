package testplugin.testplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import testplugin.testplugin.util.HotbarSetUtil;

public class HotbarDisable implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command");
            return true;

        }

        Player pl = (Player) sender;
        HotbarSetUtil hbe = new HotbarSetUtil();

        if (!(hbe.getSet(pl.getUniqueId().toString()))) {
            pl.sendMessage("You already have hotbarlock disabled");
        }
        else {
            hbe.removeSet(pl.getUniqueId().toString());
            pl.sendMessage("Hotbarlock disabled");
        }
        return true;

    }
}
