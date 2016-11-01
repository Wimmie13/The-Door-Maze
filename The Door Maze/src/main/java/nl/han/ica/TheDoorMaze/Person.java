package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Person extends ActionObject implements ICollidableWithGameObjects {
	private String[] text;
	private boolean missionActive = false;
	private String missionObjective;
	private MessageBox message;
	private Sound missionComplete;
	private TheDoorMaze world;

	public Person(TheDoorMaze world, int x, int y, String image, String itemName, String[] text, String missionObjective) {
		super(image, itemName, x, y);
		this.world = world;
		this.text = text;
		this.message = new MessageBox();
		this.missionObjective = missionObjective;
		this.missionComplete = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/missionComplete.mp3");
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (world.key == ' '  && message.getIsShown() == false) {
					message = new MessageBox(world, "Chris", this.text[0], "", "");

					this.isUsed = false;
					this.missionActive = false;
				} else if (world.key == ' ' && this.missionActive == true
						&& TheDoorMaze.inventory.getItem("Flower") == "Flower" && message.getIsShown() == false) {
					message = new MessageBox(world, "Chris", this.text[1], "", "");
					TheDoorMaze.inventory.delItem("Flower");
					TheDoorMaze.inventory.delMission(this.missionObjective);
					TheDoorMaze.inventory.addItem("Een condoom van een matig merk");

					missionComplete.play();
					this.missionActive = false;
				} else if (world.key == ' ' && this.missionActive == true && message.getIsShown() == false) {
					message = new MessageBox(world, "Chris", this.text[2], "", "");

				} else if (world.key == ' ' && this.missionActive == false && message.getIsShown() == false) {
					message = new MessageBox(world, "Chris", this.text[3], this.text[4], "");

				} else if (world.key == TheDoorMaze.ENTER && message.getIsShown() == true) {
					message.removeDashboard();

				}
			}
		}
	}
}
