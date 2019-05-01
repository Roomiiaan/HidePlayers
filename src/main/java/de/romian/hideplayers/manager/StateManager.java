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

        hidingStates.put(player, getHidingStateFromFile(player));
    }

    // Store current hiding state of player
    public void saveHidingState(Player player) {

        saveHidingStateToFile(player);
        hidingStates.remove(player);
    }

    // Change hiding state
    public void changeHidingState(Player player) {

        hidingStates.put(player, (hidingStates.get(player) == 1 ? 2 : 1));
    }

    // Get hiding state of player from hashmap
    public int getHidingState(Player player) { return hidingStates.get(player); }

    // Set default hiding state in hashmap for player
    public void setDefaultHidingState(Player player) {

        hidingStates.put(player, 1);
    }

    // Get hiding state of player from file
    private int getHidingStateFromFile(Player player) {

        return config.getInt(player.getUniqueId().toString());
    }

    // Save current hiding state of player in file
    private void saveHidingStateToFile(Player player) {

        config.set(player.getUniqueId().toString(), hidingStates.get(player));
        saveConfig();
    }

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

    // Method for saving yml file
    private void saveConfig() {

        try {

            config.save(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Getter for hashmap
    //public HashMap getHidingStatesMap() { return hidingStates; }

}
