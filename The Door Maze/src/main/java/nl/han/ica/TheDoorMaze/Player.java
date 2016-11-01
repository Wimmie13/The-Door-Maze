package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Player extends AnimatedSpriteObject implements ICollidableWithGameObjects, IAlarmListener {

	final int height = 240;
	final int width = 100;
	private final TheDoorMaze world;
	private Alarm alarm;
	private boolean alarmOn;
	private boolean walkAllowed;

	public Player(TheDoorMaze world, int x, int y) {
		super(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/player.png"), 16);
		this.world = world;
		this.alarmOn = false;
		this.walkAllowed = true;
		
		this.setX(x);
		this.setY(y);
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
		if (this.walkAllowed == true) {
			final int speed = 5;
			if (keyCode == TheDoorMaze.LEFT) {
				if (this.alarmOn == false) {
					setDirectionSpeed(270, speed);
					startAlarm("Walk left");
				}
			} else if (keyCode == TheDoorMaze.RIGHT) {
				if (this.alarmOn == false) {
					setDirectionSpeed(90, speed);
					startAlarm("Walk right");
				}
			}
		}
	}

	private void startAlarm(String alarmName) {
		this.alarmOn = true;
		this.alarm = new Alarm(alarmName, 0.1F);
		this.alarm.addTarget(this);
		this.alarm.start();
	}

	private void stopAlarm() {
		this.alarm.stop();
		this.alarm = null;
		this.alarmOn = false;

		if (this.getDirection() == 270) {
			this.setCurrentFrameIndex(8);
		} else {
			this.setCurrentFrameIndex(0);
		}
	}

	@Override
	public void keyReleased(int keyCode, char key) {
		if (TheDoorMaze.inventory.getIsOpen() == false) {
			if (this.alarm != null) {
				setSpeed(0);
				startAlarm("STOP");
			}
		}
		if (key == 'i' && TheDoorMaze.inventory.getIsOpen() == false) {
			this.setWalkAllowed();
			TheDoorMaze.inventory.createDashboard();
			this.setSpeed(0);
			if (this.alarmOn == true) {
				startAlarm("STOP");
			}
		} else if (key == 'i') {
			this.setWalkAllowed();
			TheDoorMaze.inventory.removeDashboard();
		}
		
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if (alarmName == "Walk left") {
			this.walkLeft();
		} else if (alarmName == "Walk right") {
			this.walkRight();
		} else if (alarmName == "STOP") {
			this.stopAlarm();
		}
	}

	private void walkLeft() {
		if (this.getCurrentFrameIndex() < 15 && this.getCurrentFrameIndex() >= 9) {
			this.nextFrame();
		} else {
			this.setCurrentFrameIndex(9);
		}
		this.startAlarm("Walk left");
	}

	private void walkRight() {
		if (this.getCurrentFrameIndex() < 7) {
			this.nextFrame();
		} else {
			this.setCurrentFrameIndex(0);
		}
		this.startAlarm("Walk right");
	}

	public void setWalkAllowed() {
		this.walkAllowed = !this.walkAllowed;
	}
}