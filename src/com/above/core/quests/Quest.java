package com.above.core.quests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Quest class for the creation of quests
 * 
 * @author NathanGrad
 *
 */
public class Quest {

	private static Map<UUID, Quest> playerQuests = new HashMap<UUID, Quest>();
	private Player player;
	private String title;
	private String headName;
	private String headDisplay;
	private String[] lore;
	private List<ItemStack> rewards = new ArrayList<ItemStack>();
	private List<ItemStack> tasks = new ArrayList<ItemStack>();

	/**
	 * Find out whether a player has an active quest or not
	 * 
	 * @param player
	 *            The player you want to check on
	 * @return True if they're on a quest - False if they're not
	 */
	public static boolean isQuesting(Player player) {
		return playerQuests.containsKey(player.getUniqueId());
	}

	/**
	 * Get the current quest the player is on
	 * 
	 * @param player
	 *            The player you want to check on
	 * @return Returns the quest the player is on
	 */
	public static Quest getCurrent(Player player) {
		if (isQuesting(player))
			return playerQuests.get(player.getUniqueId());
		else
			return null;
	}

	/**
	 * Set the active quest of a player
	 * 
	 * @param player
	 *            The player you want to bind a quest to
	 * @param quest
	 *            The quest the player is bound to
	 */
	public static void setQuest(Player player, Quest quest) {
		if (getCurrent(player) != null) {
			getCurrent(player).cancel();
		}
		quest.setPlayer(player);
		playerQuests.put(player.getUniqueId(), quest);
	}

	/**
	 * Set the author of the quest (Villager, Zombie etc)
	 * 
	 * @param head
	 *            The head name of the author
	 */
	public void setAuthor(String head) {
		this.headName = head;
	}

	/**
	 * Set the head name to be displayed
	 * 
	 * @param display
	 *            The string to be displayed above the head
	 */
	public void setAuthorDisplay(String display) {
		this.headDisplay = display;
	}

	/**
	 * Add one of the <b>four</b> rewards available for quests
	 * 
	 * @param reward
	 *            The reward to add
	 */
	public void addReward(ItemStack reward) {
		rewards.add(reward);
	}

	/**
	 * Add one of the <b>sixteen</b> tasks available for quest completion
	 * 
	 * @param task
	 *            The task to add
	 */
	public void addTask(ItemStack task) {
		tasks.add(task);
	}

	/**
	 * Set the lore of the quest (the book content)
	 * 
	 * @param lore
	 *            String array of lines
	 */
	public void setLore(String[] lore) {
		this.lore = lore;
	}

	/**
	 * Set the title of the quest in window
	 * 
	 * @param name
	 *            The title of the quest
	 */
	public void setTitle(String name) {
		this.title = name;
	}

	/**
	 * Cancel the quest
	 */
	public void cancel() {
		playerQuests.remove(player);
	}

	/**
	 * Complete the quest and give user the rewards
	 */
	public void complete() {
		for (ItemStack i : rewards) {
			player.getInventory().addItem(i);
		}
		playerQuests.remove(player);
	}

	/**
	 * Get the title of a quest
	 * 
	 * @return The title of the quest
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Get the player this quest is bound to
	 * 
	 * @return The player bound to this quest
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Get the head name of the author of the quest
	 * 
	 * @return The head name of the author of the quest
	 */
	public String getAuthor() {
		return this.headName;
	}

	/**
	 * Get the displayed content for the head name
	 * 
	 * @return The head name to be displayed
	 */
	public String getAuthorDisplay() {
		return this.headDisplay;
	}

	/**
	 * Get the string array of lore lines
	 * 
	 * @return String array of lore lines for quest
	 */
	public String[] getLore() {
		return this.lore;
	}

	/**
	 * Get the list of item stacks for the rewards
	 * 
	 * @return List of item stacks for rewards
	 */
	public List<ItemStack> getRewards() {
		return this.rewards;
	}

	/**
	 * Get the tasks bound to this quest
	 * 
	 * @return The item stack list of tasks to do
	 */
	public List<ItemStack> getTasks() {
		return this.tasks;
	}

	/**
	 * Set the player of the quest
	 * 
	 * @param player
	 *            The player to set the quest to
	 */
	private void setPlayer(Player player) {
		this.player = player;
	}

}
