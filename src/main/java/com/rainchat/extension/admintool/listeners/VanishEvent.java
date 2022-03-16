package com.rainchat.extension.admintool.listeners;

import com.rainchat.cubecore.api.CubeCore;
import com.rainchat.extension.admintool.commands.VanishCmd;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VanishEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (player.hasPermission("aspect.vanish.bypass")) {
            return;
        }

        for (Player localplayer: Bukkit.getOnlinePlayers()) {
            if (VanishCmd.vanishedPlayers.contains(localplayer.getUniqueId())) {

                player.hidePlayer(CubeCore.getAPI().getPlugin(), localplayer);
            }
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (VanishCmd.vanishedPlayers.contains(e.getPlayer().getUniqueId())) {
            VanishCmd.vanishedPlayers.remove(e.getPlayer().getUniqueId());
        }

        Player player = e.getPlayer();
        for (Player localplayer: Bukkit.getOnlinePlayers()) {
            if (VanishCmd.vanishedPlayers.contains(localplayer)) {
                player.hidePlayer(CubeCore.getAPI().getPlugin(), localplayer);
            }
        }
    }

}
