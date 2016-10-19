package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.tiles.BoardsTile2;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;

public class ActionObject extends SpriteObject {
	protected String itemName;
	private boolean isUsed;

	public ActionObject(String img, String itemName) {
		super(new Sprite(img));
		this.isUsed = false;
		this.itemName = itemName;
	}

	@Override
	public void update() {
	}
}
