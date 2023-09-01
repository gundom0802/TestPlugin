package testplugin.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import testplugin.testplugin.commands.HotBarEnable;
import testplugin.testplugin.commands.HotbarDisable;
import testplugin.testplugin.handlers.HotbarHandler;
import testplugin.testplugin.handlers.PickupHandler;
import testplugin.testplugin.util.HotbarSetUtil;

public final class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Hello World");

        getCommand("hotbarenable").setExecutor(new HotBarEnable());
        getCommand("hotbardisable").setExecutor(new HotbarDisable());

        new HotbarHandler(this);
        new PickupHandler(this);
        new HotbarSetUtil();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Goodbye World");
    }
}
