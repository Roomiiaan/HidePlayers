package de.romian.hideplayers.manager;

import de.romian.hideplayers.HidePlayers;
import org.bukkit.ChatColor;

public class ConfigManager {

    // Define local variables
    private HidePlayers instance;
    private static boolean saveHidingState;

    // Initialize local variables
    public ConfigManager(HidePlayers instance) {
        this.instance = instance;
    }

    // Initialize config manager
    public void init() {

        instance.saveDefaultConfig();
        saveHidingState = getBoolean("SaveHidingState");
    }

    public String getString(String path) {
        return instance.getConfig().getString(path);
    }

    public String getTranslatedString(String path) {
        return translateString(getString(path));
    }

    public int getInt(String path) {
        return instance.getConfig().getInt(path);
    }

    public boolean getBoolean(String path) {
        return instance.getConfig().getBoolean(path);
    }

    public boolean getSaveHidingState() { return saveHidingState; }

    private String translateString(String stringToTranslate) {
        return ChatColor.translateAlternateColorCodes('&', stringToTranslate);
    }



}
