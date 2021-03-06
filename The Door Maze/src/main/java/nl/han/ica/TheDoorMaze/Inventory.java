package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class Inventory extends GameObject {
	private ArrayList<Item> items = new ArrayList<Item>();
	private boolean isOpen;
	private final TheDoorMaze world;
	private Dashboard dashboard;
	private float dashboardX, dashboardY, dashboardWidth, dashboardHeight;
	private ArrayList<Item> missies = new ArrayList<Item>();

	public Inventory(TheDoorMaze world, int width, int height) {
		this.world = world;
		this.isOpen = false;
		this.dashboardX = (width / 3) / 2;
		this.dashboardY = (height / 3) / 2;
		this.dashboardWidth = (width / 3) * 2;
		this.dashboardHeight = (height / 3) * 2;
	}

	public void addItem(String name) {
		this.items.add(new Item(name));
		Map.notify = new Notification(this.world, name + " is verplaatst naar je inventory.");
	}
	
	public String getItem(String itemName){
		for (Item b : items) {
			if (b.getName() == itemName){
				return b.getName();
			}
		}
		return "dit item zit niet in je inventory";
	}
	
	public boolean itemInInventory(String itemName){
		for (Item b : items) {
			if (b.getName().substring(b.getName().indexOf('#') + 1).equals(itemName)){
				return true;
			}
		}
		return false;
	}

	public void delItem(String itemName){
		for(int i = 0; i < items.size(); i++){
			if (items.get(i).getName() == itemName){
				items.remove(i);
			}
		}
	}
	
	public boolean getItemBoolean(String itemName){
		for (Item b : items) {
			if (b.getName() == itemName){
		    return true;
			}
		}
		return false;
	}
	
	public boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen() {
		this.isOpen = !this.isOpen;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(PGraphics g) {
		final int marginHeader = 40;
		final int marginTop = 25;
		final int marginText = 20;
		final int marginLeft = 10;
		g.stroke(255);
		g.strokeWeight(10);
		g.fill(0);
		g.rect(0, 0, this.dashboardWidth, this.dashboardHeight, 5);
		
		g.fill(255);
		g.textAlign(CENTER);
		g.textSize(32);
		g.text("Inventory", this.dashboardWidth/2, marginHeader);

		g.textAlign(LEFT);
		g.noStroke();
		g.textSize(20);
		g.fill(255, 0, 0);
		g.text("Quest items", marginLeft, marginTop + marginHeader);
		g.text("Actieve missie's", this.dashboardWidth/2 + marginLeft, marginTop + marginHeader);
		g.fill(255);
		g.textSize(16);
		for(int i = 0; i < items.size(); i++){
			g.text(items.get(i).getName(), marginLeft, marginHeader + marginTop + marginText * (i + 1));
		}
		for(int i = 0; i < missies.size(); i++){
			g.text(missies.get(i).getName(), this.dashboardWidth/2 + marginLeft,  marginHeader + marginTop + marginText * (i + 1));
		}
	}

	public void createDashboard() {
		this.isOpen = true;
		dashboard = new Dashboard(this.dashboardX, this.dashboardY, this.dashboardWidth, this.dashboardHeight);
		dashboard.addGameObject(this);
		world.addDashboard(dashboard);
	}
	
	public void removeDashboard(){
		this.isOpen = false;
		world.deleteDashboard(dashboard);
	}
	
	public void addMission(String name) {
		this.missies.add(new Item(name));
	}
	
	public void delMission(String name) {
		for(int i = 0; i < missies.size(); i++){
			if (missies.get(i).getName() == name){
				missies.remove(i);
			}
		}
	}
}
