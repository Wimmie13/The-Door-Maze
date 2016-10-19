package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Waterfountain extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/sink.png";
	private String emptyImage = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/sink_empty.png";

	public Waterfountain(TheDoorMaze world, String itemName) {
		super(image, itemName);
		this.world = world;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				System.out.println(world.inventory.getItem());
				if (world.key == ' ' && this.isUsed == false) {
					this.isUsed = true;
					this.setSprite(new Sprite(emptyImage));
					world.inventory.addItem(this.itemName);
				}

			}
		}
	}
}
