package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

import java.util.List;

public class Key extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/key.png";
	private Sound keySound;
//	private int sw = 0;

	public Key(TheDoorMaze world, String itemName) {
		super(image, itemName);
		this.world = world;
		this.keySound = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/item.mp3");
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false) {
					this.isUsed = true;
					TheDoorMaze.inventory.addItem(this.itemName);
					keySound.play();
					world.deleteGameObject(this);
				}

			}
		}
	}
}