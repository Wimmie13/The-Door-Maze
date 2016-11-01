package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class ActionObject extends SpriteObject implements ICollidableWithGameObjects {
	protected TheDoorMaze world;
	protected String itemName;
	protected boolean isUsed;

	public ActionObject(TheDoorMaze world, String img, String itemName, int x, int y) {
		super(new Sprite(img));
		this.world = world;
		this.itemName = itemName;

		this.setX(x);
		this.setY(y);
	}

	@Override
	public void update() {
	}

	public void checkIsUsed() {
		if (TheDoorMaze.inventory.getItemBoolean(itemName) == true) {
			this.isUsed = true;
		}
	}

	protected void addToInventory() {
		this.isUsed = true;
		TheDoorMaze.inventory.addItem(this.itemName);
	}

	public void setIsUsed() {
		this.isUsed = !this.isUsed;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {		
	}

}
