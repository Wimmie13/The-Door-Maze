package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

import java.util.List;

public class Computer extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/computerscreen.png";
	private static String imageHacked = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/computerscreenhacked.png";
	private boolean hacked;
	private Sound hackedSound;
	
	public Computer(TheDoorMaze world, int x, int y, String itemName) {
		super(image, itemName, x, y);
		this.world = world;
		this.hacked = false;
		this.hackedSound = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/hacked.mp3");
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false){
					this.hacked = true;
					this.setSprite(new Sprite(imageHacked));
					hackedSound.play();
				}
				if (world.key == ' ' && this.isUsed == false && this.hacked == true) {
					this.isUsed = true;
					TheDoorMaze.inventory.addItem(this.itemName);
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
