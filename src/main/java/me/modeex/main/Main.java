package me.modeex.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;

        getServer().getPluginManager().registerEvents(new DisablePlugins(), this);

        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("noplugin")) {
            if(!sender.hasPermission("noplugin.*")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        getConfig().getString("messages.noperm")));
                return true;
            }
            if(args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        getConfig().getString("messages.usage")));
                return true;
            }
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            getConfig().getString("messages.reload")));
                    reloadConfig();
                }
            }
        }
        return false;
    }
}