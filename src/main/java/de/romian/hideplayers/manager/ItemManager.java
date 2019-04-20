package de.romian.hideplayers.manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemManager {

    // Define local variables
    private ConfigManager configManager;
    private ItemStack hideStack;
    private ItemStack showStack;
    private ArrayList<String> itemLore = new ArrayList<>();

    // Initialize local variables
    public ItemManager(ConfigManager configManager) {
        this.configManager = configManager;

        try {

            hideStack = new ItemStack(Material.matchMaterial(configManager.getString("HidePlayer.Item")));
            ItemMeta hideMeta = hideStack.getItemMeta();
            hideMeta.setDisplayName(configManager.getTranslatedString("HidePlayer.Displayname"));
            itemLore.add(configManager.getTranslatedString("HidePlayer.Lore"));
            hideMeta.setLore(itemLore);
            hideStack.setItemMeta(hideMeta);
            itemLore.clear();

            // Initializing show item
            showStack = new ItemStack(Material.matchMaterial(configManager.getString("ShowPlayer.Item")));
            ItemMeta showMeta = showStack.getItemMeta();
            showMeta.setDisplayName(configManager.getTranslatedString("ShowPlayer.Displayname"));
            itemLore.add(configManager.getTranslatedString("ShowPlayer.Lore"));
            showMeta.setLore(itemLore);
            showStack.setItemMeta(showMeta);
            itemLore.clear();

        } catch(Exception exception) {
            exception.printStackTrace();
        }

    }

    // Getter for hide item
    public ItemStack getHideItem() {
        return hideStack;
    }

    // Getter for show item
    public ItemStack getShowStack() {
        return showStack;
    }

    public void changeItem(Player player) {
        PlayerInventory playerInventory = player.getInventory();

        if(playerInventory.getItemInMainHand().equals(hideStack)) {
            playerInventory.setItemInMainHand(showStack);
            return;
        }

        if(playerInventory.getItemInMainHand().equals(showStack)) {
            playerInventory.setItemInMainHand(hideStack);
            return;
        }

    }

}
