package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.TheDoorMaze.ActionObject;
import nl.han.ica.TheDoorMaze.MessageBox;
import nl.han.ica.TheDoorMaze.Player;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class Person2 extends ActionObject implements ICollidableWithGameObjects {
	private String[] text;
	private boolean missionActive = false;
	private String missionObjective;
	private MessageBox message;
	private Sound missionComplete;
	private TheDoorMaze world;

	public Person2(TheDoorMaze world, int x, int y, String image, String itemName, String[] text, String missionObjective) {
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
				if (world.key == ' ' && this.isUsed == false && message.getIsShown() == false) {
					TheDoorMaze.inventory.addMission(this.missionObjective);
					message = new MessageBox(world, "Piet", this.text[0], this.text[1], "");

					this.isUsed = true;
					this.missionActive = true;
				} else if (world.key == ' ' && this.missionActive == true
						&& TheDoorMaze.inventory.itemInInventory("Boeken") && message.getIsShown() == false) {
					message = new MessageBox(world, "Piet", this.text[2], "", "");
					TheDoorMaze.inventory.delItem("Boeken");
					TheDoorMaze.inventory.delMission(this.missionObjective);
					TheDoorMaze.inventory.addItem("3");

					missionComplete.play();
					this.missionActive = false;
				} else if (world.key == ' ' && this.missionActive == true && message.getIsShown() == false) {
					message = new MessageBox(world, "Piet", this.text[3], "", "");

				} else if (world.key == ' ' && this.missionActive == false && message.getIsShown() == false) {
					message = new MessageBox(world, "Piet", this.text[4], this.text[5], "");

				} else if (world.key == TheDoorMaze.ENTER && message.getIsShown() == true) {
					message.removeDashboard();

				}
			}
		}
	}
}
