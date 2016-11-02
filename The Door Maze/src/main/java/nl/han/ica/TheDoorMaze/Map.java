package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public abstract class Map implements IMap, IAlarmListener{
	protected final TheDoorMaze world;
	protected ArrayList<GameObject> objects;
	
	private int mapWidth;
	private int mapHeight;
	private String background;
	private int tolerance;
	
	public static Notification notify;
	public static MessageBox message;
	
	public static Alarm alarm;
	private int gametime;
	
	public Map(TheDoorMaze world, int mapWidth, int mapHeight, String background){
		this.world = world;
		this.objects = new ArrayList<>();
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.background = background;
		this.tolerance = 250;
		Map.message = new MessageBox();
	}
	
	private void checkUsedObjects(){
		for(int i = 0; i < this.objects.size(); i++){
			if(this.objects.get(i) instanceof ActionObject){
				((ActionObject) this.objects.get(i)).checkIsUsed();
			}
		}
	}
	
	
	public void drawMap(){
    	world.deleteAllGameOBjects();
    	world.deleteAllDashboards();
		for(int i = 0; i < this.objects.size(); i++){
			world.addGameObject(this.objects.get(i));
		}
		this.checkUsedObjects();
		this.initializeSound();
		this.drawView();
		world.keyCode = TheDoorMaze.DOWN;
	}
	
	protected GameObject getPlayer(){
		for(int i = 0; i < this.objects.size(); i++){
			if(this.objects.get(i) instanceof Player){
				return this.objects.get(i);
			}
		}
		return null;
	}
	
	protected GameObject getDate(){
		for(int i = 0; i < this.objects.size(); i++){
			if(this.objects.get(i) instanceof Date){
				return this.objects.get(i);
			}
		}
		return null;
	}
	
	
	protected void createEdgeView(int screenWidth, int screenHeight, double xOffset, double yOffset, GameObject object) {
		EdgeFollowingViewport viewPort = new EdgeFollowingViewport(object, screenWidth, screenHeight, xOffset, yOffset);
		viewPort.setTolerance(0, 0, this.tolerance, this.tolerance);
		View view = new View(viewPort, this.mapWidth, this.mapHeight);
		world.setView(view);
		world.size(screenWidth, screenHeight);
		view.setBackground(world.loadImage(this.background));
	}
	
	protected void createView(){
		View view = new View(this.mapWidth, this.mapHeight);
		world.setView(view);
		world.size(this.mapWidth, this.mapHeight);
		view.setBackground(world.loadImage(this.background));
	}
	
	protected void checkViewPort(){
		if(this.getPlayer() != null){
			if(((EdgeFollowingViewport) world.getView().getViewport()).getRightTolerance() == this.tolerance &&
					this.getPlayer().getX() < ((EdgeFollowingViewport) world.getView().getViewport()).getLeftTolerance() ||
					this.getPlayer().getX() > world.getView().getWorldWidth() - ((EdgeFollowingViewport) world.getView().getViewport()).getRightTolerance() - this.getPlayer().getWidth()){
				((EdgeFollowingViewport) world.getView().getViewport()).setTolerance(0, 0, 0, 0);
			} else if(((EdgeFollowingViewport) world.getView().getViewport()).getRightTolerance() == 0 &&
					this.getPlayer().getX() > this.tolerance &&
					this.getPlayer().getX() < world.getView().getWorldWidth() - this.tolerance - this.getPlayer().getWidth()){
				((EdgeFollowingViewport) world.getView().getViewport()).setTolerance(0, 0, this.tolerance, this.tolerance);
			}
		}
	}

	@Override
	public abstract void drawView();
	
	@Override
	public abstract void initializeSound();
	
	protected void setPlayerPosition(int currentMap){
		for(int i = 0; i < this.objects.size(); i++){
			if(this.objects.get(i) instanceof Door){
				Door door = (Door) this.objects.get(i);
				if(door.getNaar().equals(Integer.toString(currentMap))){
					this.getPlayer().setX(door.getX() + door.getWidth());
				}
			}
		}
	}
	
	public ArrayList<GameObject> getObjects(){
		return this.objects;
	}
	
	@Override
	public void triggerAlarm(String alarmName) {
		if(alarmName == "Gametimer"){
			if(this.gametime == 60){
				for(Map map : world.getMaps()){
					if(map.getDate() != null){
						((Date)map.getDate()).moveRoom();
					}
				}
			} else if (this.gametime == 90){
				for(Map map : world.getMaps()){
					if(map.getDate() != null){
						((Date)map.getDate()).endGame();
					}
				}
			} else if (this.gametime == 100){
				world.setNextMap(3);
				return;
			}
			this.gametime++;
			this.startGametimer();
		}
	}
	
	protected void startGametimer(){
		Map.alarm = new Alarm("Gametimer", 1F);
		Map.alarm.addTarget(this);
		Map.alarm.start();
	}
	
	public int getGametime(){
		return this.gametime;
	}
}
