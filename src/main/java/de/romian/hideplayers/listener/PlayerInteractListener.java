package de.romian.hideplayers.listener;

import de.romian.hideplayers.manager.ItemManager;
import de.romian.hideplayers.manager.StateManager;
import de.romian.hideplayers.manager.VisibleManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    // Define local variables
    private ItemManager itemManager;
    private StateManager stateManager;
    private VisibleManager visibleManager;

    // Initialize local variables
    public PlayerInteractListener(ItemManager itemManager, StateManager stateManager, VisibleManager visibleManager) {
        this.itemManager = itemManager;
        this.stateManager = stateManager;
        this.visibleManager = visibleManager;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        // Define important variables
        Player player = event.getPlayer();
        ItemStack itemInHandStack = player.getInventory().getItemInMainHand();

        // Return if no item in hand
        if(itemInHandStack == null) return;

        // If player do right click
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            if (itemInHandStack == itemManager.getHideItem() || itemInHandStack == itemManager.getShowStack()) {

                itemManager.changeItem(player);

                // Check hiding state and hide or show online players
                if (stateManager.getHidingState(player) == 1) {

                    visibleManager.hidePlayer(player);

                } else {

                    visibleManager.showPlayer(player);
                }

                stateManager.changeHidingState(player);

            }

        }

    }

}
