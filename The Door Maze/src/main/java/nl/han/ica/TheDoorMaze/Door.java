package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Door extends ActionObject implements ICollidableWithGameObjects {
	private String naar;
	private TheDoorMaze world;

	public Door(TheDoorMaze world, String img, String naar, String itemName) {
		super(img, itemName);
		this.naar = naar;
		this.world = world;
	}

	public String getNaar() {
		return this.naar;
	}

	public void keyPressed(int keyCode, char key) {
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.keyCode == TheDoorMaze.UP && TheDoorMaze.inventory.getItem(this.naar) == this.naar) {
					System.out.println("fakka");
				}

			}
		}
	}
}
