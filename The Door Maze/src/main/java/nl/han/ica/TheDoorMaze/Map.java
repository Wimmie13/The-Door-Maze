package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.View.CenterFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public class Map {
	protected final TheDoorMaze world;
	protected ArrayList<GameObject> objects;
	
	private int mapWidth;
	private int mapHeight;
	private String background;
	
	public Map(TheDoorMaze world, int mapWidth, int mapHeight, String background){
		this.world = world;
		this.objects = new ArrayList<>();
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.background = background;
		
    	world.deleteAllGameOBjects();
    	world.deleteAllDashboards();
	}
	
	protected void drawMap(){
		for(int i = 0; i < this.objects.size(); i++){
			world.addGameObject(this.objects.get(i));
		}
	}
	
	protected GameObject getPlayer(){
		for(int i = 0; i < this.objects.size(); i++){
			if(this.objects.get(i) instanceof Player){
				return this.objects.get(i);
			}
		}
		GameObject player = new Player(world, 600, 200);
		return player;
	}
	
	protected void createCenterView(int worldWidth, int worldHeight, int screenWidth, int screenHeight, double xOffset, double yOffset, GameObject object) {
		CenterFollowingViewport viewPort = new CenterFollowingViewport(object, screenWidth, screenHeight, xOffset, yOffset);
		View view = new View(viewPort, worldWidth, worldHeight);
		world.setView(view);
		world.size(screenWidth, screenHeight);
		view.setBackground(world.loadImage("src/main/java/nl/han/ica/TheDoorMaze/media/startscreenbg.png"));
	}
	
	protected void createEdgeView(int screenWidth, int screenHeight, double xOffset, double yOffset, GameObject object) {
		EdgeFollowingViewport viewPort = new EdgeFollowingViewport(object, screenWidth, screenHeight, xOffset, yOffset);
		viewPort.setTolerance(0, 0, 100, 100);
		View view = new View(viewPort, this.mapWidth, this.mapHeight);
		world.setView(view);
		world.size(screenWidth, screenHeight);
		view.setBackground(world.loadImage(this.background));
	}
}
