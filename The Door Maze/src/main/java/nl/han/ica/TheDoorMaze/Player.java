package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Player extends AnimatedSpriteObject implements IAlarmListener {

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
		if (this.walkAllowed == true && this.alarmOn == false) {
			playerWalk(keyCode);
		}
	}
	
	private void playerWalk(int direction){
		String alarmName;
		int setDirection;
		if(direction == TheDoorMaze.LEFT){
			alarmName = "Walk left";
			setDirection = 270;
		} else if(direction == TheDoorMaze.RIGHT) {
			alarmName = "Walk right";
			setDirection = 90;
		} else {
			return;
		}
		setDirectionSpeed(setDirection, 5);
		startAlarm(alarmName);
		
	}

	private void startAlarm(String alarmName) {
		this.alarmOn = true;
		this.alarm = new Alarm(alarmName, 0.1F);
		this.alarm.addTarget(this);
		this.alarm.start();
	}

	private void stopAlarm() {
		this.setSpeed(0);
		this.alarm.stop();
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
				startAlarm("STOP");
			}
		}
		if (key == 'i' && TheDoorMaze.inventory.getIsOpen() == false && Map.message.getIsShown() == false) {
			this.setWalkAllowed();
			TheDoorMaze.inventory.createDashboard();
		} else if (key == 'i' && Map.message.getIsShown() == false) {
			this.setWalkAllowed();
			TheDoorMaze.inventory.removeDashboard();
		}

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