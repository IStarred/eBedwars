package com.yecraft.shop;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemFlag;

import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;

public class FoodShop extends Gui{
	public FoodShop(Player player){
		super (player, "food_shop", "Їжа", 54);
	}
	
	@Override
	public void onOpen(InventoryOpenEvent inventory){
		allShopIcons();
		
		Icon bread = new Icon(Material.BREAD).setAmount(2);
		Icon chicken = new Icon(Material.COOKED_CHICKEN).setAmount(2);
		Icon pork = new Icon(Material.COOKED_PORKCHOP).setAmount(2);
		Icon cake = new Icon(Material.CAKE);
		Icon goldenApple = new Icon(Material.GOLDEN_APPLE);
		
		addItem(29, bread);
		addItem(30, chicken);
		addItem(31, pork);
		addItem(32, cake);
		addItem(33, goldenApple);
	}
	
	public void allShopIcons(){
		fillRow(new Icon(Material.ORANGE_STAINED_GLASS_PANE).setName(""), 2);
		LinkedList<Icon> icons = (LinkedList<Icon>) List.of(
		new Icon(Material.SANDSTONE).setName("Блоки").onClick(e -> {
			new BlocksShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.NETHERITE_CHESTPLATE).setName("Броня").onClick(e -> {
			new ArmorShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.GOLDEN_PICKAXE).setName("Кайла").onClick(e -> {
			new PickaxeShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.IRON_SWORD).setName("Мечі").onClick(e -> {
			new SwordShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.BOW).setName("Луки").onClick(e -> {
			new BowShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.APPLE).setName("Їжа").enchant(Enchantment.ARROW_DAMAGE, 1).hideFlags(ItemFlag.HIDE_ENCHANTS).onClick(e ->
		{
			new FoodShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.TNT).setName("Додаткові предмети").onClick(e -> {
			new ToolsShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.POTION).setName("Зілля").onClick(e -> {
			new PotionShop((Player) e.getWhoClicked()).open();
		}),
		new Icon(Material.BEACON).setName("Покращення").onClick(e -> {
			new UpgradeShop((Player) e.getWhoClicked()).open();
		}));
		for (Icon icon : icons){
			int i = 0;
			addItem(i, icon);
			i++;
		}
	}
}