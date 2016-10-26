package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Bookshelf extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/bookcase.png";

	public Bookshelf(TheDoorMaze world, int x, int y, String itemName) {
		super(image, itemName, x, y);
		this.world = world;
	}

	@SuppressWarnings("static-access")
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {

				if (world.key == ' ' && this.isUsed == false) {
					this.isUsed = true;
					world.inventory.addItem(this.itemName);
				}
			}
		}
	}
}
