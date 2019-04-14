package de.romian.hideplayers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HidePlayers extends JavaPlugin {

    private HidePlayers instance;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getConsoleSender().sendMessage("Plugin aktiviert!");
    }
}
