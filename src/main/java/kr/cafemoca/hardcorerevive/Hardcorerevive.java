package kr.cafemoca.hardcorerevive;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Hardcorerevive extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {

		ItemStack revive = new ItemStack(Material.DRAGON_BREATH, 1);
		ItemMeta im = revive.getItemMeta();

		ArrayList<String> lore = new ArrayList<String>();

		im.setDisplayName("§r§d§l[ 부활의 포션 ]");
		lore.add("§r들고 Shift + F로 접속한 사람중 한명을 살림");

		im.setLore(lore);
		revive.setItemMeta(im);


		Bukkit.getPluginManager().registerEvents(this, this);



		ShapedRecipe reviveItem = new ShapedRecipe(revive);

		reviveItem.shape("PDB","GSH"," W ");

		reviveItem.setIngredient('P', Material.PRISMARINE_SHARD);
		reviveItem.setIngredient('D', Material.DIAMOND);
		reviveItem.setIngredient('B', Material.BAMBOO);
		reviveItem.setIngredient('G', Material.GOLDEN_APPLE);
		reviveItem.setIngredient('S', Material.HEART_OF_THE_SEA);
		reviveItem.setIngredient('H', Material.HONEY_BLOCK);
		reviveItem.setIngredient('W', Material.GLASS_BOTTLE);

		Bukkit.addRecipe(reviveItem);

	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onUseRevive(PlayerSwapHandItemsEvent event) {
		if (event.getPlayer().isSneaking()) {
			if (event.getOffHandItem() != null || event.getOffHandItem().getItemMeta().getDisplayName().equalsIgnoreCase("§r§d§l[ 부활의 포션 ]")) {
				event.getPlayer().sendMessage("asdf");
			}
		}
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
