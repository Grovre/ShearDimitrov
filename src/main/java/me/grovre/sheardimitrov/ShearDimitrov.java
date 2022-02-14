package me.grovre.sheardimitrov;

import me.grovre.sheardimitrov.listeners.OnPlayerShear;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShearDimitrov extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new OnPlayerShear(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
