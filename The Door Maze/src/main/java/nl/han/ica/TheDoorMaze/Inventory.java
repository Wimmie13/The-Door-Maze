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

	public Inventory(TheDoorMaze world) {
		this.world = world;
		this.isOpen = false;
		this.dashboardX = (world.getWidth() / 3) / 2;
		this.dashboardY = (world.getHeight() / 3) / 2;
		this.dashboardWidth = (world.getWidth() / 3) * 2;
		this.dashboardHeight = (world.getHeight() / 3) * 2;
	}

	public void addItem(String name) {
		this.items.add(new Item(name));
	}

	public String getItem() {
		for (Item b : items) {
			return b.getName();
		}
		return "niks";
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
		final int marginTop = 20;
		final int marginText = 20;
		g.fill(200);
		g.rect(0, 0, this.dashboardWidth, this.dashboardHeight, 5);
		g.textSize(20);
		g.fill(255, 0, 0);
		g.text("Quest items", 10, marginTop);
		g.fill(0);
		g.textSize(16);
		for(int i = 0; i < items.size(); i++){
			g.text(items.get(i).getName(), 10, marginTop + marginText * (i + 1));
		}
	}

	public void createDashboard() {
		dashboard = new Dashboard(this.dashboardX, this.dashboardY, this.dashboardWidth, this.dashboardHeight);

		dashboard.addGameObject(this);

		world.addDashboard(dashboard);
	}
	
	public void removeDashboard(){
		world.deleteDashboard(dashboard);
	}
}
