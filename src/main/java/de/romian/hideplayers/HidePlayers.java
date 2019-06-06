package de.romian.hideplayers;

import de.romian.hideplayers.listener.PlayerInteractListener;
import de.romian.hideplayers.listener.PlayerJoinListener;
import de.romian.hideplayers.listener.PlayerQuitListener;
import de.romian.hideplayers.manager.ConfigManager;
import de.romian.hideplayers.manager.ItemManager;
import de.romian.hideplayers.manager.StateManager;
import de.romian.hideplayers.manager.VisibleManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HidePlayers extends JavaPlugin {

    // Define local variables
    private static String prefix, enablingMessage;

    private static HidePlayers instance;

    @Override
    public void onEnable() {
        instance = this;

        // Initialize config manager
        ConfigManager configManager = new ConfigManager(instance);
        configManager.init();

        // Initialize item manager
        ItemManager itemManager = new ItemManager(configManager);

        // Initialize state manager
        StateManager stateManager = new StateManager();
        stateManager.init();

        // Initialize visible manager
        VisibleManager visibleManager = new VisibleManager(stateManager);

        // Initialize local variables
        prefix = configManager.getTranslatedString("Prefix") + " ";
        enablingMessage = configManager.getTranslatedString("ConsoleEnablingMessage");

        // Add event listeners to plugin
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(configManager, itemManager, stateManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(stateManager, configManager), this);
        Bukkit.getPluginManager().registerEvents(new VisibleManager(stateManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(itemManager, stateManager, visibleManager), this);

        // Send message to console when plugin was loaded
        Bukkit.getConsoleSender().sendMessage(prefix + enablingMessage);

    }

    public static HidePlayers getInstance() {
        return instance;
    }
}
