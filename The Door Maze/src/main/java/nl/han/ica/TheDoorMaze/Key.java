package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

import java.util.List;

public class Key extends ActionObject {
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/key.png";
	private Sound keySound;

	public Key(TheDoorMaze world, int x, int y, String itemName) {
		super(world, image, itemName, x, y);
		this.keySound = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/item.mp3");
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player && world.keyPressed) {
				if (world.key == ' ' && this.isUsed == false) {
					this.addToInventory();
					keySound.play();
					world.deleteGameObject(this);
					world.getMaps().get(world.getCurrentMap()).getObjects().remove(this);
				}
			}
		}
	}
}