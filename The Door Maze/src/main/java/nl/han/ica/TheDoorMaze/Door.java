package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Door extends ActionObject implements ICollidableWithGameObjects {
	private int naar;
	private TheDoorMaze world;
	private boolean keyNeeded;

	public Door(TheDoorMaze world, String img, int naar, String itemName, boolean keyNeeded) {
		super(img, itemName);
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
			System.out.println(TheDoorMaze.inventory.getItem(Integer.toString(this.naar)));
			if (g instanceof Player) {
				if (world.keyCode == TheDoorMaze.UP && TheDoorMaze.inventory.getItem(Integer.toString(this.naar)) == Integer.toString(this.naar) && keyNeeded == true) {
					System.out.println("fakka");
					world.map = this.naar;
				} else if (world.keyCode == TheDoorMaze.UP && keyNeeded == false){
					world.map = this.naar;
				}

			}
		}
	}
}
