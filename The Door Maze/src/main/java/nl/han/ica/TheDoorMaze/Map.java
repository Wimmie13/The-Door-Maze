package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public class Map {
	private final TheDoorMaze world;
	private ArrayList<GameObject> objects;
	
	private int mapWidth;
	private int mapHeight;
	private String background;
	
//	private Door bathroomdoor;
//	private Flower flower;
//	private Waterfountain waterfountain;
//	private Locker locker;
//	private Computer computer;
//	private Person person;
//	private Bookshelf bookshelf;
	
	public Map(TheDoorMaze world, int mapWidth, int mapHeight, String background){
		this.world = world;
		this.objects = new ArrayList<>();
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.background = background;
		
    	world.deleteAllGameOBjects();
    	world.deleteAllDashboards();
	}
	
	public void addObject(GameObject object){
		this.objects.add(object);
	}
	
	public void drawMap(){
		for(int i = 0; i < this.objects.size(); i++){
			world.addGameObject(this.objects.get(i));
		}
	}
	
	public GameObject getPlayer(){
		for(int i = 0; i < this.objects.size(); i++){
			if(this.objects.get(i) instanceof Player){
				return this.objects.get(i);
			}
		}
		GameObject player = new Player(world, 600, 200);
		return player;
	}
	
	public String getBackground(){
		return this.background;
	}
	
	public int getMapWidth(){
		return this.mapWidth;
	}
	
	public int getMapHeight(){
		return this.mapHeight;
	}
}
