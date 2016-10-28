package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class ActionObject extends SpriteObject {
	protected String itemName;
	protected boolean isUsed = false;

	public ActionObject(String img, String itemName, int x, int y) {
		super(new Sprite(img));
		this.itemName = itemName;

		this.setX(x);
		this.setY(y);
	}

	@Override
	public void update() {
	}
	
	public void checkIsUsed(){
		if (TheDoorMaze.inventory.getItemBoolean(itemName) == true) {
			this.isUsed = true;
		}
	}

}
