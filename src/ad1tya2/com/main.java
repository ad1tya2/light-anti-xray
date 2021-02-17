package ad1tya2.com;

import ad1tya2.com.events.breakevent;
import ad1tya2.com.utilities.sqlite;

import org.bukkit.ChatColor;

import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "Test enabled!");
        getServer().getPluginManager().registerEvents(new breakevent(), this);


        sqlite.main("CREATE TABLE IF NOT EXISTS data(uuid VAR CHAR,time INTEGER, intensity INTEGER);");
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "Test plugin Disabled :(!");
    }
}

