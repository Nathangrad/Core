package com.above.core.quests;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.above.core.utils.InventoryHelper;
import com.above.core.utils.ItemHelper;

/**
 * QuestWindow class for displaying quests in a clean GUI
 * 
 * @author NathanGrad
 *
 */
public class QuestWindow {

	public static Byte[] borders = new Byte[] { 12, 19, 20, 21, 30, 39 };
	public static Byte[] tasks = new Byte[] { 13, 14, 15, 16, 22, 23, 24, 25, 31, 32, 33, 34, 40, 41, 42, 43 };
	public static ItemStack blackPane = ItemHelper
			.setName(ItemHelper.getItem(Material.STAINED_GLASS_PANE, (byte) 1, (short) 15), "");
	public static List<Inventory> invList = new ArrayList<Inventory>();

	/**
	 * Create an inventory for the quest
	 * 
	 * @param quest
	 *            The quest you want to create an inventory for
	 * @return The created inventory for the player to open
	 */
	public static Inventory createWindow(Quest quest) {
		Inventory inventory = InventoryHelper.createInventory(quest.getTitle());
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(quest.getAuthor());
		meta.setDisplayName(quest.getAuthorDisplay());
		skull.setItemMeta(meta);
		ItemStack book = new ItemStack(Material.BOOK, 1);
		ItemMeta bookMeta = book.getItemMeta();
		bookMeta.setDisplayName(quest.getTitle());
		List<String> lore = new ArrayList<String>();
		for (String s : quest.getLore()) {
			lore.add(s);
		}
		bookMeta.setLore(lore);
		book.setItemMeta(bookMeta);
		inventory.setItem(10, skull);
		inventory.setItem(11, book);
		for (byte b : borders) {
			inventory.setItem(b, blackPane);
		}
		try {
			inventory.setItem(28, quest.getRewards().get(0));
			inventory.setItem(29, quest.getRewards().get(1));
			inventory.setItem(37, quest.getRewards().get(2));
			inventory.setItem(38, quest.getRewards().get(3));
		} catch (IndexOutOfBoundsException ioobe) {
		}
		for (byte b = 0; b < 16; b++) {
			try {
				inventory.setItem(tasks[b], quest.getTasks().get(b));
			} catch (IndexOutOfBoundsException ioobe) {
			}
		}
		invList.add(inventory);
		return inventory;
	}

}