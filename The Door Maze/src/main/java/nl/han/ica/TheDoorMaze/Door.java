package nl.han.ica.TheDoorMaze;


import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.waterworld.tiles.BoardsTile2;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;

public class Door extends SpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {
		private TheDoorMaze world;
		
	    public Door(TheDoorMaze world, String img) {
	    	this(new Sprite(img));
	    	this.world = world;
	    }
	    
	    private Door(Sprite sprite) {
	        super(sprite);
	    }
	    
	    @Override
	    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {

	    }

		@Override
		public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update() {
			
		}

		@Override
		public void draw(PGraphics g) {
		}
}
