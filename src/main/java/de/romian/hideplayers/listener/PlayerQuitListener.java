package de.romian.hideplayers.listener;

import de.romian.hideplayers.manager.ConfigManager;
import de.romian.hideplayers.manager.StateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private StateManager stateManager;
    private ConfigManager configManager;

    public PlayerQuitListener(StateManager stateManager, ConfigManager configManager) {
        this.stateManager = stateManager;
        this.configManager = configManager;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        // Return if "save hiding state" is set to false
        if(!configManager.getBoolean("SaveHidingState"))
            return;

        stateManager.saveHidingState(player);
    }

}
