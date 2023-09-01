package testplugin.testplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import testplugin.testplugin.TestPlugin;

public class PickupHandler implements Listener {
    public PickupHandler(TestPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        LivingEntity pl = event.getEntity();
        if (checkInventory(pl, event)) {
            event.setCancelled(true);
        }
    }

    public boolean checkInventory(LivingEntity pl, EntityPickupItemEvent event) {
        for (int i = 0; i < 35; i++) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
                continue;
            }
            else {
                if (((Player) pl).getInventory().getItem(i).getType() == Material.AIR) {
                    return false;
                }
                else {
                    if (event.getItem().getItemStack().getType() == ((Player) pl).getInventory().getItem(i).getType()) {
                        if (((Player) pl).getInventory().getItem(i).getMaxStackSize() > 1 && ((Player) pl).getInventory().getItem(i).getAmount() < 64) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
