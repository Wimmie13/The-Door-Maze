package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Bookshelf extends ActionObject {
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/bookcase.png";

	public Bookshelf(TheDoorMaze world, int x, int y, String itemName) {
		super(world, image, itemName, x, y);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player && world.keyPressed) {
				if (world.key == ' ' && this.isUsed == false) {
					this.addToInventory();
				}
			}
		}
	}
}
