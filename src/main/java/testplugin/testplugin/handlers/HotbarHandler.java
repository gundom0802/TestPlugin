package testplugin.testplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import testplugin.testplugin.TestPlugin;
import testplugin.testplugin.util.HotbarSetUtil;


public class HotbarHandler implements Listener {
    public HotbarHandler(TestPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    HotbarSetUtil hbe = new HotbarSetUtil();

    @EventHandler
    public void onHotbarClick(InventoryClickEvent event) {
        if (hbe.getSet(event.getWhoClicked().getUniqueId().toString())) {
            if (event.getClick().equals(ClickType.NUMBER_KEY) || event.getAction().equals(InventoryAction.PLACE_ALL)) {
                Bukkit.getLogger().info(String.valueOf(event.getSlot()));
                if ((event.getHotbarButton() >= 1 && event.getHotbarButton() < 8) || (event.getSlot() >= 1 && event.getSlot() < 8)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
