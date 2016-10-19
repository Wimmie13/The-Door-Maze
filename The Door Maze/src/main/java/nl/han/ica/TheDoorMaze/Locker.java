package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Locker extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/locker.png";
	private boolean open;

	public Locker(TheDoorMaze world, String itemName) {
		super(image, itemName);
		this.world = world;
		this.open = false;
	}

	@SuppressWarnings("static-access")
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				System.out.println(world.inventory.getItem());
				if (world.key == ' ' && this.isUsed == false && this.open == true) {
					this.isUsed = true;
					world.inventory.addItem(this.itemName);
				}
			}
		}
	}
	
	public boolean getOpen(){
		return this.open;
	}
	
	public void setOpen(){
		this.open = !this.open;
	}
}
