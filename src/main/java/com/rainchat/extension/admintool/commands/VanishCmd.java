package com.rainchat.extension.admintool.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Subcommand;
import com.rainchat.cubecore.api.CubeCore;
import com.rainchat.cubecore.utils.general.Chat;
import com.rainchat.cubecore.utils.general.Message;
import com.rainchat.extension.admintool.configs.AdminToolLang;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CommandAlias("AspectManager")
public class VanishCmd extends BaseCommand {

    public static List<UUID> vanishedPlayers = new ArrayList<>();
    public AdminToolLang adminToolLang;

    public VanishCmd(AdminToolLang adminToolLang) {
        this.adminToolLang = adminToolLang;
    }


    @Subcommand("vanish")
    @CommandCompletion("@players @nothing")
    @CommandAlias("vanish")
    public void onCommand(Player player, String[] args) {

        if (args.length == 0) {
            if (player.hasPermission("aspect.vanish.use")) {
                if (!vanishPlayer(player)) {
                    Chat.sendTranslation(player,true, adminToolLang.VANISH_DISABLE.getMessage());
                } else {
                    Chat.sendTranslation(player,true, adminToolLang.VANISH_ENABLE.getMessage());
                }
            }
            return;
        }


        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            Chat.sendTranslation(player,true, Message.PLAYER_OFFLINE.toString().replaceAll("%player_name%", args[0]));
            return;
        }
        if (!target.hasPermission("aspect.vanish.bypass")) {
            Chat.sendTranslation(player,true, Message.NO_COMMAND_PERMISSION.toString());
            return;
        }
        if (!target.hasPermission("aspect.vanish.others")) {
            Chat.sendTranslation(player,true, Message.NO_COMMAND_PERMISSION.toString());
            return;
        }

        if (!vanishPlayer(player)) {
            Chat.sendTranslation(player,true, adminToolLang.VANISH_DISABLE_ANOTHER.getMessage());
        } else {
            Chat.sendTranslation(player,true, adminToolLang.VANISH_ENABLE_ANOTHER.getMessage());
        }

    }


    // Vanishes or unvanishes another player
    private boolean vanishPlayer(Player p) {

        // If the player is vanished, unvanished him
        if(vanishedPlayers.contains(p.getUniqueId())) {
            for (Player online : Bukkit.getOnlinePlayers()) {
                online.showPlayer(CubeCore.getAPI().getPlugin(), p);
                vanishedPlayers.remove(p.getUniqueId());
            }
            return false;
        }

        // If the player NOT vanished, vanishes him
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.hasPermission("aspect.vanish.view")) {
                online.showPlayer(CubeCore.getAPI().getPlugin(), p);
            }
            online.hidePlayer(CubeCore.getAPI().getPlugin(), p);
            vanishedPlayers.add(p.getUniqueId());
        }
        return true;
    }

}
