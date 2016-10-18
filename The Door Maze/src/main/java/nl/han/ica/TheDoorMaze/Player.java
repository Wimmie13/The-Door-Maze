package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PVector;

import java.util.List;
import java.util.Random;

public class Player extends AnimatedSpriteObject implements ICollidableWithGameObjects {

    final int height = 240;
    final int width = 100;
    private int currentFrame;
    private final TheDoorMaze world;
    

    public Player(TheDoorMaze world) {
        super(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/player.png"),16);
        this.world=world;
        this.currentFrame = 0;
//        setFriction(0.05f);
    }

    @Override
    public void update() {
        if (this.getX()<=0) {
            this.setxSpeed(0);
            this.setX(0);
        }
        if (this.getX()>=world.getView().getWorldWidth() - this.width) {
            this.setxSpeed(0);
            this.setX(world.getView().getWorldWidth() - this.width);
        }
        if (this.getCurrentFrameIndex() != this.currentFrame){
        	this.setCurrentFrameIndex(this.currentFrame);
        }
    }

	@Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == world.LEFT) {
            setDirectionSpeed(270, speed);
            if(this.currentFrame < 15){
            	this.nextFrame();
            } else {
            	this.currentFrame = 9;
            }
        }
        if (keyCode == world.RIGHT) {
            setDirectionSpeed(90, speed);
            if(this.currentFrame < 7){
            	this.nextFrame();
            } else {
            	this.currentFrame = 0;
            }
        }
        if (key == ' ') {
            System.out.println("Spatie!");
        }
    }
	
	@Override
	public void keyReleased(int keyCode, char key){
		final int speed = 0;
		setSpeed(speed);

        if (this.getDirection() == 270){
        	this.currentFrame = 8;
        } else {
        	this.currentFrame = 0;
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
