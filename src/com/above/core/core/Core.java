package com.above.core.core;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.above.core.quests.QuestListener;
import com.above.core.utils.Messages;

/**
 * Core main class running the example Data Management system
 * 
 * @author NathanGrad
 *
 */
public class Core extends JavaPlugin {

	private Logger console = Bukkit.getServer().getLogger();

	@Override
	public void onEnable() {
		Messages.core = this;
		Bukkit.getServer().getPluginManager().registerEvents(new QuestListener(), this);
		console.info("Core successfully enabled");
	}

}
