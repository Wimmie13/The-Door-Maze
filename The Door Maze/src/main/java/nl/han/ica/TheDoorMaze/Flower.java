package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Flower extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/plant2.png";
	private String emptyImage = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/plant2empty.png";

	public Flower(TheDoorMaze world, String itemName) {
		super(image, itemName);
		this.world = world;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				System.out.println(ActionObject.inventory.getItem(this.itemName));
				if (world.key == ' ' && this.isUsed == false) {
					this.isUsed = true;
					this.setSprite(new Sprite(emptyImage));
					ActionObject.inventory.addItem(this.itemName);
				}

			}
		}
	}
}
