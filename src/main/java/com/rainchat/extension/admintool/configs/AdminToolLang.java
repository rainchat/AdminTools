package com.rainchat.extension.admintool.configs;


import com.rainchat.cubecore.utils.files.LangMsg;
import com.rainchat.cubecore.utils.files.LangTemplate;
import com.rainchat.cubecore.utils.objects.CustomFile;
import org.bukkit.plugin.Plugin;

public class AdminToolLang extends LangTemplate {

    public LangMsg GAMEMODE_CHANGE = new LangMsg(this, "Messages.gamemode.gamemode-change", "&7Ваш игровой режим иземенен на &a%player_gamemode%");
    public LangMsg GAMEMODE_CHANGE_ANOTHER = new LangMsg(this, "Messages.gamemode.gamemode-change-another", "&7Ваш игровой режим иземенен на &a%player_gamemode%");

    //Fly
    public LangMsg FLY_ENABLE = new LangMsg(this, "Messages.fly.fly-enable", "Вы включили режим полёта.");
    public LangMsg FLY_DISABLE = new LangMsg(this, "Messages.fly.fly-disable", "Вы выключили режим полёта.");
    public LangMsg FLY_ENABLE_ANOTHER = new LangMsg(this, "Messages.fly.fly-enable", "Вы включили режим полёта игроку &e%player_name%.");
    public LangMsg FLY_DISABLE_ANOTHER = new LangMsg(this, "Messages.fly.fly-disable", "Вы выключили режим полёта игроку &e%player_name%.");

    //God
    public LangMsg GOD_ENABLE_ANOTHER = new LangMsg(this, "Messages.god.god-enable-another", "Вы включили режим бога игроку &e%player_name%");
    public LangMsg GOD_ENABLE = new LangMsg(this, "Messages.god.god-enable", "Вы включили режим бога.");
    public LangMsg GOD_DISABLE = new LangMsg(this, "Messages.god.god-disable", "Вы выключили режим бога.");
    public LangMsg GOD_DISABLE_ANOTHER = new LangMsg(this, "Messages.god.god-disable-another", "Вы выключили режим бога игроку &e%player_name%.");

    //Vanish
    public LangMsg VANISH_ENABLE = new LangMsg(this,"Messages.vanish.vanish-enable", "Вы включили невидимость.");
    public LangMsg VANISH_DISABLE = new LangMsg(this,"Messages.vanish.vanish-disable", "Вы выключили невидимость.");
    public LangMsg VANISH_ENABLE_ANOTHER = new LangMsg(this,"Messages.vanish.vanish-enable-another", "Вы включили невидимость игроку %player_name%.");
    public LangMsg VANISH_DISABLE_ANOTHER = new LangMsg(this,"Messages.vanish.vanish-disable-another", "Вы выключили невидимость игроку %player_name%.");

    public AdminToolLang(Plugin plugin, CustomFile config) {
        super(plugin, config);
    }
}
