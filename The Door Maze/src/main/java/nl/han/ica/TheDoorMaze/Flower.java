package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Flower extends ActionObject {
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/plant2.png";
	private String emptyImage = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/plant2empty.png";

	public Flower(TheDoorMaze world, int x, int y, String itemName) {
		super(world, image, itemName, x, y);
	}
	
	@Override
	public void update() {
		if(this.isUsed == true){
			this.setSprite(new Sprite(emptyImage));
		}
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
