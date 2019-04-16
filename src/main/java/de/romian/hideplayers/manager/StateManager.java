package de.romian.hideplayers.manager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class StateManager {

    // Define local variables
    private File folder = new File("plugins//HidePlayers");
    private File file = new File("plugins//HidePlayers//states.yml");
    private YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

}
