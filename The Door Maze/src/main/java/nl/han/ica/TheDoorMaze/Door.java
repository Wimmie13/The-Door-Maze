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

public class Door extends SpriteObject implements ICollidableWithGameObjects {
	private int naar;
	private TheDoorMaze world;
	
	    public Door(TheDoorMaze world, String img, int naar) {
	    	super(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/Toilet.png"));
	    	this.naar = naar;
	    	this.world = world;
	    }

		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}

		public int getNaar() {
			return naar;
		}

		public void keyPressed(int keyCode, char key) {
	    }
		
		
	    @Override
	    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
	        for (GameObject g:collidedGameObjects) {
	            if (g instanceof Player) {
	    	        if (world.keyCode == UP) {
	    	            System.out.println("fakka");
	    	        }
	            	
	            	}
	            }
	        }
	    }

