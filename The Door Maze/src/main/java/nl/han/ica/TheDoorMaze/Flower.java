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

public class Flower extends ActionObject implements ICollidableWithGameObjects {
	private boolean empty = false;
	private TheDoorMaze world;

	public Flower(TheDoorMaze world, String itemName) {
		super("src/main/java/nl/han/ica/TheDoorMaze/media/plant2.png", itemName);
		this.world = world;
	}

	public void keyPressed(int keyCode, char key) {
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.empty == false) {
					this.empty = true;
					System.out.println("SKURT");
					this.setSprite(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/plant2empty.png"));
				}

			}
		}
	}
}
