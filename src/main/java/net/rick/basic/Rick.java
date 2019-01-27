package net.rick.basic;

import net.dv8tion.jda.core.JDA;

public interface Rick {
    void onEnable();

    JDA getJDA();
}