package com.rainchat.extension.admintool.utils;


import com.rainchat.cubecore.utils.general.Chat;
import com.rainchat.cubecore.utils.general.Message;
import com.rainchat.extension.admintool.configs.AdminToolLang;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminWriter {

    public static void toggleFly(CommandSender sender, String name, AdminToolLang adminToolLang) {

        Player player = Bukkit.getPlayer(findPlayer(name));
        if (player == null) {
            Chat.sendTranslation(player, true, Message.NO_COMMAND_PERMISSION.getMessage().replaceAll("%player_name%", name));

            return;
        }

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            Chat.sendTranslation(player, true, adminToolLang.FLY_DISABLE_ANOTHER.getMessage());
        } else {
            player.setAllowFlight(true);
            Chat.sendTranslation(player, true, adminToolLang.FLY_ENABLE_ANOTHER.getMessage());
        }
    }


    private static String findPlayer(String s) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getDisplayName().toLowerCase().contains(s.toLowerCase())) return p.getName();
        }
        return "PlayerNotFound";
    }


}
