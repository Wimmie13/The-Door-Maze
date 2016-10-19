package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Computer extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/computerscreen.png";
	private static String imageHacked = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/computerscreenhacked.png";
	private boolean hacked;
	public Computer(TheDoorMaze world, String itemName) {
		super(image, itemName);
		this.world = world;
		this.hacked = false;
	}

	@SuppressWarnings("static-access")
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false){
					this.hacked = true;
					this.setSprite(new Sprite(imageHacked));
				}
				if (world.key == ' ' && this.isUsed == false && this.hacked == true) {
					this.isUsed = true;
					world.inventory.addItem(this.itemName);
				}
			}
		}
	}
	
	public boolean getHacked(){
		return this.hacked;
	}
	
	public void setHacked(){
		this.hacked = !this.hacked;
	}
}
