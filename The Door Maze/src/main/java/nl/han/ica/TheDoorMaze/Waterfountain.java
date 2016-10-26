package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Waterfountain extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/sink.png";
	private String emptyImage = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/sink_empty.png";

	public Waterfountain(TheDoorMaze world, int x, int y, String itemName) {
		super(image, itemName, x, y);
		this.world = world;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false) {
					this.isUsed = true;
					this.setSprite(new Sprite(emptyImage));
					TheDoorMaze.inventory.addItem(this.itemName);
				}

			}
		}
	}
}
