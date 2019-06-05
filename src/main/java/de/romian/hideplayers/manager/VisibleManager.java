package de.romian.hideplayers.manager;

import de.romian.hideplayers.HidePlayers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VisibleManager implements Listener {

    // Define local variables
    private StateManager stateManager;

    // Initialize local variables
    public VisibleManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void hidePlayer(Player player) {

        Bukkit.getOnlinePlayers().forEach(players -> {

            player.hidePlayer(HidePlayers.getInstance(), players);

        });

    }

    public void showPlayer(Player player) {

        Bukkit.getOnlinePlayers().forEach(players -> {

            if(!player.canSee(players))
                player.showPlayer(HidePlayers.getInstance(), players);

        });

    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Bukkit.getScheduler().runTaskLater(HidePlayers.getInstance(), new Runnable() {

            @Override
            public void run() {

                // Hiding joined player for all players in state 2
                Bukkit.getOnlinePlayers().forEach(players -> {

                    if(stateManager.getHidingState(players) == 2) {

                        players.hidePlayer(HidePlayers.getInstance(), player);

                    }

                });

                // Hide all online players if state of joined player is 2
                if(stateManager.getHidingState(player) == 2)
                    hidePlayer(player);

            }
        }, 10);

    }

}
