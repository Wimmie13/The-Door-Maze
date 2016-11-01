package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class Notification extends GameObject {

	TheDoorMaze world;
	private boolean isShown = false;
	private Dashboard dashboardAction;
	private float dashboardX, dashboardY, dashboardWidth, dashboardHeight;
	private String text;
	
	public Notification(TheDoorMaze world, String text){
		this.world = world;
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
	
	private void createDashboard() {
		dashboardAction = new Dashboard(this.dashboardX, this.dashboardY, this.dashboardWidth, this.dashboardHeight);
		dashboardAction.addGameObject(this);
		world.addDashboard(dashboardAction);
		this.isShown = true;
	}
	
	public void removeDashboard(){
		this.isShown = false;
		world.deleteDashboard(dashboardAction);
	}
}
