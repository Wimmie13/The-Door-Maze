package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Door extends ActionObject implements ICollidableWithGameObjects {
	private String naar;
	private TheDoorMaze world;
	private boolean keyNeeded;

	public Door(TheDoorMaze world, int x, int y, String image, String naar, String itemName, boolean keyNeeded) {
		super(world, image, itemName, x, y);
		this.naar = naar;
		this.world = world;
		this.keyNeeded = keyNeeded;
	}

	public String getNaar() {
		return this.naar;
	}

	@Override
	 public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
	  for (GameObject g : collidedGameObjects) {
	   if (g instanceof Player && world.keyPressed) {
	    if(TheDoorMaze.inventory != null){
	     if (world.keyCode == TheDoorMaze.UP && TheDoorMaze.inventory.itemInInventory(this.naar) == true && keyNeeded == true) {
	      world.setNextMap(Integer.parseInt(this.naar));
	     } else if (world.keyCode == TheDoorMaze.UP && keyNeeded == false){
	      world.setNextMap(Integer.parseInt(this.naar));
	     } else if (world.keyCode == TheDoorMaze.UP){
	      Map.notify = new Notification(this.world, "Je hebt niet de juiste sleutel voor deze deur.");
	     }
	    }
	   }
	  }
	}
}
	   
	  

