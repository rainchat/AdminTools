package com.rainchat.extension.admintool.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class GodMode implements Listener {

    public static List<Player> GODS = new ArrayList<>();


    @EventHandler()
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && GODS.contains(e.getEntity())) {
            e.setCancelled(true);
            ((Player) e.getEntity()).setHealth(((Player) e.getEntity()).getMaxHealth());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        GODS.remove(e.getPlayer());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        GODS.remove(e.getPlayer());
    }

}
