package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class Notification extends GameObject implements IAlarmListener{

	private TheDoorMaze world;
	private Dashboard dashboardAction;
	private float dashboardX, dashboardY, dashboardWidth, dashboardHeight;
	private String text;
	private Alarm alarm;
	
	public Notification(TheDoorMaze world, String text, Double seconds){
		this.world = world;
		if(Map.notify != null){
			Map.notify.alarm.stop();
			Map.notify.removeDashboard();
		}
		this.text = text;
		this.dashboardWidth = 30 + text.length() * 8;
		this.dashboardHeight = 30;
		this.dashboardX = world.getWidth() / 2 - this.dashboardWidth / 2;
		this.dashboardY = 50;
		this.createDashboard();
		this.alarm = new Alarm("Notification", seconds);
		this.alarm.addTarget(this);
		this.alarm.start();
	}
	
	public Notification(TheDoorMaze world, String text){
		this.world = world;
		if(Map.notify != null){
			Map.notify.alarm.stop();
			Map.notify.removeDashboard();
		}
		this.text = text;
		this.dashboardWidth = 30 + text.length() * 8;
		this.dashboardHeight = 30;
		this.dashboardX = world.getWidth() / 2 - this.dashboardWidth / 2;
		this.dashboardY = 50;
		this.createDashboard();
		this.alarm = new Alarm("Notification", 5.0);
		this.alarm.addTarget(this);
		this.alarm.start();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(PGraphics g) {
		final float marginTop = 15;
		g.textSize(14);
		g.fill(200);
		g.rect(0, 0, this.dashboardWidth, this.dashboardHeight, 5);
		g.fill(0);
		g.textAlign(CENTER, CENTER);
		g.text(this.text, this.dashboardWidth / 2, marginTop);
	}
	
	private void createDashboard() {
		dashboardAction = new Dashboard(this.dashboardX, this.dashboardY, this.dashboardWidth, this.dashboardHeight);
		dashboardAction.addGameObject(this);
		world.addDashboard(dashboardAction);
	}
	
	public void removeDashboard(){
		world.deleteDashboard(dashboardAction);
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if(alarmName == "Notification"){
			this.removeDashboard();
		}
	}
	
	public String getText(){
		return this.text;
	}
}
