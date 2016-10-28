package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Door extends ActionObject implements ICollidableWithGameObjects {
	private int naar;
	private TheDoorMaze world;
	private boolean keyNeeded;

	public Door(TheDoorMaze world, int x, int y, String image, int naar, String itemName, boolean keyNeeded) {
		super(image, itemName, x, y);
		this.naar = naar;
		this.world = world;
		this.keyNeeded = keyNeeded;
	}

	public int getNaar() {
		return this.naar;
	}

	public void keyPressed(int keyCode, char key) {
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if(TheDoorMaze.inventory != null){
					System.out.println("Bier");
					if (world.keyCode == TheDoorMaze.UP && TheDoorMaze.inventory.getItem(Integer.toString(this.naar)) == Integer.toString(this.naar) && keyNeeded == true) {
						System.out.println("fakka");
						world.nextMap = this.naar;
					} else if (world.keyCode == TheDoorMaze.UP && keyNeeded == false){
						world.nextMap = this.naar;
					}
				}
			}
		}
	}
}
