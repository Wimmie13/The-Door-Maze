package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public class Inventory {

	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Inventory(){
	}
	
	public void addItem(String name){
		this.items.add(new Item(name));
	}
	
	public String getItem(String itemName){
		for (Item b : items) {
			if (b.getName() == itemName){
		    return b.getName();
			}
		}
		return "dit item zit niet in je inventory";
	}
}
