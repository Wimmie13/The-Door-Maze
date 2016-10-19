package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
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

public class Player extends AnimatedSpriteObject implements ICollidableWithGameObjects, IAlarmListener {

	final int height = 240;
	final int width = 100;
	private final TheDoorMaze world;
	private Alarm alarm;
	private boolean alarmOn;

	public Player(TheDoorMaze world) {
		super(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/player.png"), 16);
		this.world = world;
		this.alarmOn = false;
	}

	@Override
	public void update() {
		if (this.getX() <= 0) {
			this.setxSpeed(0);
			this.setX(0);
		}
		if (this.getX() >= world.getView().getWorldWidth() - this.width) {
			this.setxSpeed(0);
			this.setX(world.getView().getWorldWidth() - this.width);
		}
	}

	@Override
	public void keyPressed(int keyCode, char key) {
		final int speed = 5;
		if (keyCode == world.LEFT) {
			if (this.alarmOn == false) {
				this.alarmOn = true;
				setDirectionSpeed(270, speed);
				startAlarm("Walk left");
			}
		}
		if (keyCode == world.RIGHT) {
			if (this.alarmOn == false) {
				this.alarmOn = true;
				setDirectionSpeed(90, speed);
				startAlarm("Walk right");
			}
		}
		if (key == ' ') {
			System.out.println("Spatie!");
		}
	}

	private void startAlarm(String alarmName) {
		this.alarm = new Alarm(alarmName, 0.1F);
		this.alarm.addTarget(this);
		this.alarm.start();
	}

	private void stopAlarm() {
		this.alarm.stop();

		if (this.getDirection() == 270) {
			this.setCurrentFrameIndex(8);
		} else {
			this.setCurrentFrameIndex(0);
		}
	}

	@Override
	public void keyReleased(int keyCode, char key) {
		final int speed = 0;
		setSpeed(speed);
		if(this.alarmOn == true){
			startAlarm("STOP");
		}
	}

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
//        for (GameObject g:collidedGameObjects) {
//            if (g instanceof Door) {
//            	Door c = (Door)g;
//            	System.out.println("dit is een deur");
//            }
//        }
    }


	@Override
	public void triggerAlarm(String alarmName) {
		if (alarmName == "Walk left") {
			this.walkLeft();
		} else if (alarmName == "Walk right") {
			this.walkRight();
		} else if (alarmName == "STOP"){
			this.alarmOn = false;
			this.stopAlarm();
		}
	}
	
	private void walkLeft(){
		if (this.getCurrentFrameIndex() < 15 && this.getCurrentFrameIndex() >= 9) {
			this.nextFrame();
		} else {
			this.setCurrentFrameIndex(9);
		}
		this.startAlarm("Walk left");
	}
	
	private void walkRight(){
		if (this.getCurrentFrameIndex() < 7) {
			this.nextFrame();
		} else {
			this.setCurrentFrameIndex(0);
		}
		this.startAlarm("Walk right");
	}
}
