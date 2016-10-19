package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Person extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private String[] text;
	private boolean missionActive = false;
	private String missionObjective;
	private MessageBox message;
	private Sound missionComplete;
	private boolean pratend = false;
	
	public Person(String img, String itemName, TheDoorMaze world, String[] text, String missionObjective) {
		super(img, itemName);
		this.world = world;
		this.text = text;
		this.missionObjective = missionObjective;
		this.missionComplete = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/missionComplete.mp3");
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' ' && this.isUsed == false && this.pratend == false) {
					TheDoorMaze.inventory.addMission(this.missionObjective);
					message = new MessageBox(world, "Henk", this.text[0], "", "");
					((Player) g).setWalkAllowed();
					this.pratend = true;
					this.isUsed = true;
					this.missionActive = true;
				} else if (world.key == ' ' && this.missionActive == true
						&& TheDoorMaze.inventory.getItem("Flower") == "Flower" && this.pratend == false) {
					message = new MessageBox(world, "Henk", this.text[1], "", "");
					((Player) g).setWalkAllowed();
					TheDoorMaze.inventory.delItem("Flower");
					TheDoorMaze.inventory.delMission(this.missionObjective);
					TheDoorMaze.inventory.addItem("Een condoom van een matig merk");
					this.pratend = true;
					missionComplete.play();
					this.missionActive = false;
				} else if (world.key == ' ' && this.missionActive == true && this.pratend == false) {
					message = new MessageBox(world, "Henk", this.text[2], "", "");
					((Player) g).setWalkAllowed();
					this.pratend = true;
				} else if (world.key == ' ' && this.missionActive == false && this.pratend == false) {
					message = new MessageBox(world, "Henk", this.text[3], this.text[4], "");
					((Player) g).setWalkAllowed();
					this.pratend = true;
				} 
				else if (world.key == TheDoorMaze.ENTER && message.getIsShown() == true) {
					message.removeDashboard();
					((Player) g).setWalkAllowed();
					this.pratend = false;
				}
			}
		}
	}
}
