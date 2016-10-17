package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

import java.util.List;
import java.util.Random;

public class Player extends AnimatedSpriteObject implements ICollidableWithGameObjects {

    final int height = 240;
    final int width = 100;
    private final TheDoorMaze world;

    public Player(TheDoorMaze world) {
        super(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/player.png"),16);
        this.world=world;
        setCurrentFrameIndex(1);
//        setFriction(0.05f);
    }

    @Override
    public void update() {
        if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getX()>=world.getWidth() - this.width) {
            setxSpeed(0);
            setX(world.getWidth() - this.width);
        }

    }
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == world.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == world.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(1);
        }
        if (key == ' ') {
            System.out.println("Spatie!");
        }
    }
    
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject g:collidedGameObjects) {
//            if (g instanceof Swordfish) {
//            	Random rand = new Random();
//                setX(rand.nextInt(world.getWidth() + 1 ));
//                setY(rand.nextInt(world.getHeight() + 1 ));
//            }
        }
    }
}
