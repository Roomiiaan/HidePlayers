package de.romian.hideplayers.listener;

import de.romian.hideplayers.manager.StateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private StateManager stateManager;

    public PlayerQuitListener(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        stateManager.saveHidingState(player);
    }

}
