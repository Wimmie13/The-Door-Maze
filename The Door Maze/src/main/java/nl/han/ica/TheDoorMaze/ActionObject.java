package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class ActionObject extends SpriteObject {
	protected String itemName;
	protected boolean isUsed = false;
	
	
	public ActionObject(String img, String itemName) {
		super(new Sprite(img));
		this.itemName = itemName;
	}

	@Override
	public void update() {
	}

}
