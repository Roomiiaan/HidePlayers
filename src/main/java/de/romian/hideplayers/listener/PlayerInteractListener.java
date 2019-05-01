package de.romian.hideplayers.listener;

import de.romian.hideplayers.manager.ItemManager;
import de.romian.hideplayers.manager.StateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    // Define local variables
    private ItemManager itemManager;
    private StateManager stateManager;

    // Initialize local variables
    public PlayerInteractListener(ItemManager itemManager, StateManager stateManager) {
        this.itemManager = itemManager;
        this.stateManager = stateManager;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        // Define important variables
        Player player = event.getPlayer();
        ItemStack itemInHandStack = player.getInventory().getItemInMainHand();

        if(event.getClickedBlock() == null) return;
        if(itemInHandStack == null) return;

        if(itemInHandStack == itemManager.getHideItem() || itemInHandStack == itemManager.getShowStack()) {

            itemManager.changeItem(player);
            stateManager.changeHidingState(player);

        }

    }

}
