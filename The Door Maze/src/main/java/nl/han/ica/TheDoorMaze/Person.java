package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;

public class Person extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private String[] text;
	private boolean missionActive = false;
	private String missionObjective;
	private Sound missionComplete;

	public Person(String img, String itemName, TheDoorMaze world, String[] text, String missionObjective) {
		super(img, itemName, world);
		this.world = world;
		this.text = text;
		this.missionObjective = missionObjective;
		this.missionComplete = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/missionComplete.mp3");
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false) {
					TheDoorMaze.inventory.addMission(this.missionObjective);
					System.out.println("at");
					this.isUsed = true;
					this.missionActive = true;
				} else if (world.key == ' ' && this.missionActive == true
						&& world.inventory.getItem("Flower") == "Flower") {
					TheDoorMaze.inventory.delItem("Flower");
					TheDoorMaze.inventory.delMission(this.missionObjective);
					missionComplete.play();
					this.missionActive = false;
				}
			}
		}
	}
}
