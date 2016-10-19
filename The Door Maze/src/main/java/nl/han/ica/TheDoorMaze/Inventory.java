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
	
	public String getItem(){
		for (Item b : items) {
		    return b.getName();
		}
		return "niks";
	}
}
