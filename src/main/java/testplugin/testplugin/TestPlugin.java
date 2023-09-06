package testplugin.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import testplugin.testplugin.commands.HotBarEnable;
import testplugin.testplugin.commands.HotbarDisable;
import testplugin.testplugin.handlers.HotbarHandler;
import testplugin.testplugin.handlers.PickupHandler;

public final class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {

        getCommand("hotbarenable").setExecutor(new HotBarEnable());
        getCommand("hotbardisable").setExecutor(new HotbarDisable());

        Bukkit.getPluginManager().registerEvents(new HotbarHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PickupHandler(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
