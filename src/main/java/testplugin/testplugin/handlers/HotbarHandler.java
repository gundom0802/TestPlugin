package testplugin.testplugin.handlers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import testplugin.testplugin.util.HotbarSetUtil;


public class HotbarHandler implements Listener {

    @EventHandler
    public void onHotbarClick(InventoryClickEvent event) {
        if (HotbarSetUtil.getSet(event.getWhoClicked().getUniqueId().toString())) {
            if (event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if (event.getAction().equals(InventoryAction.PLACE_ALL)) {
                if (event.getSlot() < 9) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
