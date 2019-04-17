package de.romian.hideplayers.manager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class StateManager {

    // Define local variables
    private File folder = new File("plugins//HidePlayers");
    private File file = new File("plugins//HidePlayers//states.yml");
    private YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    private HashMap<Player, Integer> hidingStates = new HashMap<>();

    // Initialize StateManager
    public void init() {

        createFile();
    }

    // Load saved hiding state of player from file
    public void loadHidingState(Player player) {

    }

    public int getHidingState(Player player) {

        return hidingStates.get(player);
    }

    // Getter for hashmap
    public HashMap getHidingStatesMap() { return hidingStates; }

    // Method for creating yml file
    private void createFile() {

        // Return if folder exists
        if(folder.exists())
            return;

        // Create file if not exists
        if(!file.exists()) {

            try {

                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
