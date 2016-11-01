package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Waterfountain extends ActionObject  {
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/sink.png";
	private String emptyImage = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/sink_empty.png";

	public Waterfountain(TheDoorMaze world, int x, int y) {
		super(world, image, "Glas water", x, y);
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
