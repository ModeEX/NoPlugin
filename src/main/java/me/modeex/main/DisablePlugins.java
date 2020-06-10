package me.modeex.main;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class DisablePlugins implements Listener {

    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onCommandUse(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();

        List<String> Commands = Arrays.asList("plugins", "pl", "about", "versions", "ver", "minecraft:pl", "minecraft:plugins",
                "minecraft:version", "minecraft:ver", "minecraft:about", "?", "bukkit:pl", "bukkit:plugins", "bukkit:ver",
                "bukkit:version", "bukkit:about", "bukkit:?");

        Commands.forEach(all -> {
            if(event.getMessage().toLowerCase().equalsIgnoreCase("/" + all.toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        config.getString("messages.noperm")));
                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
            }
            if(player.hasPermission("noplugin.*")){
                return;
            }
        });
    }
}