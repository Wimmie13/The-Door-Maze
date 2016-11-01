package nl.han.ica.TheDoorMaze;

import java.util.List;
import java.util.concurrent.TimeUnit;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Date extends ActionObject implements ICollidableWithGameObjects {
	private String[] text;
	private MessageBox message;
	private Sound missionComplete;
	private TheDoorMaze world;

	public Date(TheDoorMaze world, int x, int y, String image, String[] text) {
		super(image, "Date", x, y);
		this.world = world;
		this.text = text;
		this.missionComplete = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/missionComplete.mp3");
		this.message = new MessageBox();
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false && message.getIsShown() == false && world.getStopWatch().getTime(TimeUnit.SECONDS) <= 20) {
					world.getStopWatch().stop();
					message = new MessageBox(world, "Chantal", this.text[0], "Dat heeft wel "+world.getStopWatch().getTime(TimeUnit.SECONDS)+" seconden geduurt!", "");
					((Player) g).setWalkAllowed();
					missionComplete.play();
				}  
				else if (world.key == ' ' && this.isUsed == false && message.getIsShown() == false && world.getStopWatch().getTime(TimeUnit.SECONDS) >= 20) {
					world.getStopWatch().stop();
					message = new MessageBox(world, "Chantal", this.text[0], "Dat heeft wel "+world.getStopWatch().getTime(TimeUnit.SECONDS)+" seconden geduurt!", "Schiet de volgende keer een beetje op ja!");
					((Player) g).setWalkAllowed();
					missionComplete.play();
				}
				else if (world.key == TheDoorMaze.ENTER && message.getIsShown() == true) {
					message.removeDashboard();
					((Player) g).setWalkAllowed();
					world.nextMap = 4;
				}
			}
		}
	}
}
