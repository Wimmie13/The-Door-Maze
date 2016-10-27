package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class MessageBox extends GameObject{

	TheDoorMaze world;
	private boolean isShown = false;
	private Dashboard dashboardAction;
	private float dashboardX, dashboardY, dashboardWidth, dashboardHeight;
	private String[] text;
	private String input;
	private String closeMessage;
	private boolean hasInput;
	
	public MessageBox(){
		
	}
	
	public MessageBox(TheDoorMaze world, String NPCname, String line1, String line2){
		this.world = world;
		this.dashboardWidth = (world.getWidth() / 3) * 2;
		this.dashboardHeight = 100;
		this.dashboardX = (world.getWidth() / 3) / 2;
		this.dashboardY = world.getHeight() - this.dashboardHeight;
		this.text = new String[]{NPCname, line1, line2};
		this.closeMessage = "Druk op enter om te sluiten";
		this.input = "";
		createDashboard();
	}
	
	public MessageBox(TheDoorMaze world, String NPCname, String line1, String line2, String line3){
		this.world = world;
		this.dashboardWidth = (world.getWidth() / 3) * 2;
		this.dashboardHeight = 130;
		this.dashboardX = (world.getWidth() / 3) / 2;
		this.dashboardY = world.getHeight() - this.dashboardHeight;
		this.text = new String[]{NPCname, line1, line2, line3};
		this.closeMessage = "Druk op enter om te sluiten";
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
		g.stroke(255);
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
		drawInput(g, (this.dashboardWidth - marginRight), marginTop, marginText);
		g.textAlign(RIGHT);
		g.text(this.closeMessage, this.dashboardWidth - marginRight, this.dashboardHeight - marginTop);
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
	
	public void setInput(char input){
		this.input = this.input + input;
	}
	
	public void setInputBackspace(){
		if(this.input.length() > 0){
			this.input = this.input.substring(0, this.input.length() - 1);
		}
	}
	
	public void resetInput(){
		this.input = "";
	}
	
	public String getInput(){
		return input;
	}
	
	private void drawInput(PGraphics g, float marginRight, int marginTop, int marginText){
		if(this.hasInput == true){
			int marginInvoer = 215;
			g.text("Invoer: " + this.input, marginRight - marginInvoer, marginTop + marginText);
		}
	}
	
	public void hasInput(){
		this.hasInput = true;
		this.closeMessage = "Druk op enter om door te gaan.";
	}

}
