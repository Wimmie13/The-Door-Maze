package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public class Person extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private String[] text;
	private boolean missionActive = false;
	private String missionObjective;
	
	
	public Person(String img, String itemName, TheDoorMaze world, String[] text, String missionObjective) {
		super(img, itemName);
		this.world = world;
		this.text = text;
		this.missionObjective = missionObjective;
	}
	
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {

		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false) {
					TheDoorMaze.inventory.addMission(this.missionObjective);
					System.out.println("at");
					this.isUsed = true;
				}

			}
		}
	}
	
}