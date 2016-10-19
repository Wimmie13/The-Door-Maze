package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class MessageBox extends GameObject{

	TheDoorMaze world;
	private static boolean isShown = false;
	private Dashboard dashboardAction;
	private float dashboardX, dashboardY, dashboardWidth, dashboardHeight;
	private String[] text;
	
	public MessageBox(TheDoorMaze world, String NPCname, String line1, String line2){
		this.world = world;
		this.dashboardWidth = (world.getWidth() / 3) * 2;
		this.dashboardHeight = 100;
		this.dashboardX = (world.getWidth() / 3) / 2;
		this.dashboardY = world.getHeight() - this.dashboardHeight;
		this.text = new String[]{NPCname, line1, line2};
		createDashboard();
	}
	
	public MessageBox(TheDoorMaze world, String NPCname, String line1, String line2, String line3){
		this.world = world;
		this.dashboardWidth = (world.getWidth() / 3) * 2;
		this.dashboardHeight = 130;
		this.dashboardX = (world.getWidth() / 3) / 2;
		this.dashboardY = world.getHeight() - this.dashboardHeight;
		this.text = new String[]{NPCname, line1, line2, line3};
		createDashboard();
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(PGraphics g) {
		final int marginLeft = 10;
		final int marginRight = marginLeft;
		final int marginTop = 20;
		final int marginText = 20;
		g.textSize(14);
		g.fill(0);
		g.strokeWeight(10);
		g.fill(0);
		g.rect(0, 0, this.dashboardWidth, this.dashboardHeight, 5);
		g.noStroke();
		g.fill(255, 0, 0);
		g.text(text[0], marginLeft, marginTop);
		g.fill(255);
		for(int i = 1; i < text.length; i++){
			g.text(text[i], marginLeft, marginTop + marginText * i);
		}
		g.textAlign(RIGHT);
		g.text("Druk op enter om te sluiten", this.dashboardWidth - marginRight, this.dashboardHeight - marginTop);
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
	
	public boolean getIsShown() {
		return this.isShown;
	}

}
