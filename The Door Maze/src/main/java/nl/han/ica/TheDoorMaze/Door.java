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

public class Door extends ActionObject implements ICollidableWithGameObjects {
	private String naar;
	private TheDoorMaze world;

	public Door(TheDoorMaze world, String img, String naar, String itemName) {
		super(img, itemName);
		this.naar = naar;
		this.world = world;
	}

	public String getNaar() {
		return this.naar;
	}

	public void keyPressed(int keyCode, char key) {
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.keyCode == TheDoorMaze.UP && TheDoorMaze.inventory.getItem(this.naar) == this.naar) {
					world.keyCode = 0;
					System.out.println("fakka");
				}

			}
		}
	}
}
