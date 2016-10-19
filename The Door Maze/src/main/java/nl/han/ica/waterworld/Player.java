package nl.han.ica.waterworld;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PConstants;
import processing.core.PVector;

import java.util.List;
import java.util.Random;

/**
 * @author Ralph Niels
 * De spelerklasse (het paarse visje)
 */
public class Player extends AnimatedSpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {

    final int size=25;
    private final WaterWorld world;

    /**
     * Constructor
     * @param world Referentie naar de wereld
     */
    public Player(WaterWorld world) {
        super(new Sprite("src/main/java/nl/han/ica/waterworld/media/player.png"),2);
        this.world=world;
        setCurrentFrameIndex(1);
        setFriction(0.05f);
    }

    @Override
    public void update() {
        if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=world.getWidth()-size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY()>=world.getHeight()-size) {
            setySpeed(0);
            setY(world.getHeight() - size);
        }

    }
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == PConstants.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == PConstants.UP) {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == PConstants.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(1);
        }
        if (keyCode == PConstants.DOWN) {
            setDirectionSpeed(180, speed);
        }
        if (key == ' ') {
            System.out.println("Spatie!");
        }
    }


    @SuppressWarnings("static-access")
	@Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {
        PVector vector;

        for (CollidedTile ct : collidedTiles) {
            if (ct.theTile instanceof BoardsTile) {
                if (ct.collisionSide == ct.TOP) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                        setY(vector.y - getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == ct.RIGHT) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                        world.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject g:collidedGameObjects) {
            if (g instanceof Swordfish) {
            	Random rand = new Random();
                setX(rand.nextInt(world.getWidth() + 1 ));
                setY(rand.nextInt(world.getHeight() + 1 ));
            }
        }
    }
}
