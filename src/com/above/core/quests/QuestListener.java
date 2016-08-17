package com.above.core.quests;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Listens to inventory interact and closing events for quest windows
 * 
 * @author NathanGrad
 *
 */
public class QuestListener implements Listener {

	@EventHandler
	public void onQuestCloseEvent(InventoryCloseEvent ice) {
		if (QuestWindow.invList.contains(ice.getInventory())) {
			QuestWindow.invList.remove(ice.getInventory());
		}
	}

	@EventHandler
	public void onQuestInteractEvent(InventoryClickEvent ice) {
		if (QuestWindow.invList.contains(ice.getInventory())) {
			ice.setCancelled(true);
		}
	}

}
