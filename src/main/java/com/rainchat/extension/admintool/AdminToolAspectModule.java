package com.rainchat.extension.admintool;


import com.rainchat.cubecore.managers.ConfigSettings;
import com.rainchat.cubecore.utils.loader.CoreExtension;
import com.rainchat.extension.admintool.commands.AdminCommands;
import com.rainchat.extension.admintool.commands.GamemodeCommand;
import com.rainchat.extension.admintool.commands.VanishCmd;
import com.rainchat.extension.admintool.configs.AdminToolLang;
import com.rainchat.extension.admintool.listeners.GodMode;
import com.rainchat.extension.admintool.listeners.VanishEvent;


public class AdminToolAspectModule extends CoreExtension {


    private AdminToolLang adminToolLang;


    @Override
    public void onEnable() {


            adminToolLang = new AdminToolLang(getApi().getPlugin(), getCustomFile(ConfigSettings.LANGUAGE+".yml", "/lang", "/lang"));
        adminToolLang.setup();

        registerCommand(new VanishCmd(adminToolLang));
        registerCommand(new AdminCommands(getApi().getPlugin(), adminToolLang));
        registerCommand(new GamemodeCommand(adminToolLang));

        registerListener(new GodMode());
        registerListener(new VanishEvent());

    }

    public AdminToolLang getAdminToolLang() {
        return adminToolLang;
    }

    @Override
    public void onDiscard() {

    }
}
