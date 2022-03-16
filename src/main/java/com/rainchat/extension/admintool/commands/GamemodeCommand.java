package com.rainchat.extension.admintool.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.rainchat.cubecore.utils.general.Chat;
import com.rainchat.cubecore.utils.general.Message;
import com.rainchat.extension.admintool.configs.AdminToolLang;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;


public class GamemodeCommand extends BaseCommand {


    public AdminToolLang adminToolLang;

    public GamemodeCommand(AdminToolLang adminToolLang) {
        this.adminToolLang = adminToolLang;
    }

    @CommandCompletion("@gamemode @players")
    @CommandAlias("gamemode|gm")
    @Syntax("<тип> [игрок]")
    @CommandPermission("aspect.command.gamemode")
    public void onCommand(Player player, String type, @Optional Player target) {
        if (player != target && player.hasPermission("aspect.gamemode.other")) {
            setGamemode(target,type, true);
            Chat.sendTranslation(player, true, adminToolLang.GAMEMODE_CHANGE_ANOTHER.getMessage());
        } else if (!player.hasPermission("aspect.gamemode.other")) {
            Chat.sendTranslation(player, true, Message.NO_COMMAND_PERMISSION.getMessage());
        } else {
            setGamemode(target,type, false);
        }
    }

    @CommandAlias("gms")
    @CommandPermission("aspect.command.gamemode.survival")
    public void onSurvival(Player player) {
        setGamemode(player,"0", true);
    }

    @CommandAlias("gmc")
    @CommandPermission("aspect.command.gamemode.creative")
    public void onCreative(Player player) {
        setGamemode(player,"1", true);
    }

    @CommandAlias("gma")
    @CommandPermission("aspect.command.gamemode.adventure")
    public void onAdventure(Player player) {
        setGamemode(player,"2", true);
    }

    @CommandAlias("gmsp")
    @CommandPermission("aspect.command.gamemode.spectator")
    public void onSpectator(Player player) {
        setGamemode(player,"3", true);
    }

    public void setGamemode(Player player, String type, boolean permission) {
        if ((type.equalsIgnoreCase("0") || type.equalsIgnoreCase("Survival")) &&
                (permission || player.hasPermission("aspect.command.gamemode.survival"))) {
            player.setGameMode(GameMode.SURVIVAL);
        } else  if ((type.equalsIgnoreCase("1") || type.equalsIgnoreCase("Creative"))
                && (permission || player.hasPermission("aspect.command.gamemode.creative"))) {
            player.setGameMode(GameMode.CREATIVE);
        } else if ((type.equalsIgnoreCase("2") || type.equalsIgnoreCase("Adventure")) &&
                (permission || player.hasPermission("aspect.command.gamemode.adventure"))) {
            player.setGameMode(GameMode.ADVENTURE);
        } else  if ((type.equalsIgnoreCase("3") || type.equalsIgnoreCase("Spectator")) &&
                (permission || player.hasPermission("aspect.command.gamemode.spectator"))) {
            player.setGameMode(GameMode.SPECTATOR);
        }
        Chat.sendTranslation(player, true, adminToolLang.GAMEMODE_CHANGE.getMessage());
    }

}
