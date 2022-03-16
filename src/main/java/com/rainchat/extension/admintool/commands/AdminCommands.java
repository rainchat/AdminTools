package com.rainchat.extension.admintool.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import com.rainchat.cubecore.utils.general.Chat;
import com.rainchat.extension.admintool.configs.AdminToolLang;
import com.rainchat.extension.admintool.listeners.GodMode;
import com.rainchat.extension.admintool.utils.AdminWriter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@CommandAlias("AspectManager")
public class AdminCommands extends BaseCommand {

    private final Plugin plugin;
    public AdminToolLang adminToolLang;


    public AdminCommands(Plugin plugin, AdminToolLang adminToolLang) {
        this.adminToolLang = adminToolLang;
        this.plugin = plugin;
    }


    @Subcommand("fly")
    @CommandAlias("fly")
    @CommandPermission("aspect.fly")
    public void onFly(Player player) {
        AdminWriter.toggleFly(player, player.getName(), adminToolLang);
    }

    @Subcommand("fly")
    @CommandAlias("fly")
    @CommandCompletion("@players @nothing")
    @CommandPermission("aspect.fly.others")
    public void onFly(Player player, String name) {
        AdminWriter.toggleFly(player, name, adminToolLang);
    }

    @Subcommand("god")
    @CommandAlias("god")
    @CommandPermission("aspect.god")
    public void onGod(Player player) {
        boolean b = GodMode.GODS.contains(player);

        if (b) {
            GodMode.GODS.remove(player);
            Chat.sendTranslation(player,true, adminToolLang.GOD_DISABLE.getMessage());
        } else {
            GodMode.GODS.add(player);
            Chat.sendTranslation(player,true, adminToolLang.GOD_ENABLE.getMessage());
        }
    }

    @Subcommand("god")
    @CommandCompletion("@players @nothing")
    @CommandAlias("god")
    @CommandPermission("aspect.god.others")
    public void onGod(Player player, String playerName, String[] args) {
        Player player1 = Bukkit.getPlayer(playerName);


        if (player1 == null) {
            return;
        }

        boolean b =  GodMode.GODS.contains(player1);;

        if (b) {
            GodMode.GODS.remove(player1);
            Chat.sendTranslation(player,true, adminToolLang.FLY_DISABLE_ANOTHER.getMessage());
        } else {
            GodMode.GODS.remove(player1);
            Chat.sendTranslation(player,true, adminToolLang.GOD_ENABLE_ANOTHER.getMessage());
        }
    }

}
