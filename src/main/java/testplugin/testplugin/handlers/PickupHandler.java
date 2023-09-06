package testplugin.testplugin.handlers;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import testplugin.testplugin.util.HotbarSetUtil;

public class PickupHandler implements Listener {

    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player pl = (Player)entity;
        ItemStack item = pl.getInventory().getItem(0);
        if (HotbarSetUtil.getSet(pl.getUniqueId().toString())) {
            for (int i = 9; i < 36; i++) {
                item = pl.getInventory().getItem(i);
                if (item == null) {
                    event.getItem().remove();
                    pl.getInventory().setItem(i,event.getItem().getItemStack());
                    event.setCancelled(true);
                    return;
                }
                if (item.getMaxStackSize() > 1 && item.getAmount() < 64) {
                    return;
                }
            }
        }
        event.setCancelled(true);
    }
}