package de.romian.hideplayers;

import de.romian.hideplayers.manager.ConfigManager;
import de.romian.hideplayers.manager.ItemManager;
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

        // Initialize local variables
        prefix = configManager.getTranslatedString("Prefix") + " ";
        enablingMessage = configManager.getTranslatedString("ConsoleEnablingMessage");

        Bukkit.getConsoleSender().sendMessage(prefix + enablingMessage);

    }

    public static HidePlayers getInstance() {
        return instance;
    }
}
