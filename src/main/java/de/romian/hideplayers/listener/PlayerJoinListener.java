package de.romian.hideplayers.listener;

import de.romian.hideplayers.manager.ConfigManager;
import de.romian.hideplayers.manager.ItemManager;
import de.romian.hideplayers.manager.StateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    // Define local variables
    private ConfigManager configManager;
    private ItemManager itemManager;
    private StateManager stateManager;
    private int itemSlot = 0;

    // Initialize local variables
    public PlayerJoinListener(ConfigManager configManager, ItemManager itemManager, StateManager stateManager) {
        this.configManager = configManager;
        this.itemManager = itemManager;
        this.stateManager = stateManager;

        itemSlot = configManager.getInt("ItemSlot") + 1;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Return if "give item on join" is set to false
        if(!configManager.getBoolean("GiveItemOnJoin"))
            return;

        stateManager.loadHidingState(player);

        player.getInventory().setItem(itemSlot, (stateManager.getHidingState(player) == 1 ? itemManager.getHideItem() : itemManager.getShowStack()));
    }

}
