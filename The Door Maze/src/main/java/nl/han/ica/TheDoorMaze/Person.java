package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Person extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	@SuppressWarnings("unused")
	private String[] text;
	private boolean missionActive = false;
	private String missionObjective;
	private MessageBox message;
	private Sound missionComplete;

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
				if (world.key == ' ' && this.isUsed == false) {
					TheDoorMaze.inventory.addMission(this.missionObjective);
					message  = new MessageBox(world, "Henk", "Patat is lekker", "HAAL VOOR MIJ EEN FACKING BLOEM", "Joh");
					((Player) g).setWalkAllowed();
					this.isUsed = true;
					this.missionActive = true;
				} else if (world.key == ' ' && this.missionActive == true && TheDoorMaze.inventory.getItem("Flower") == "Flower") {
					TheDoorMaze.inventory.delItem("Flower");
					TheDoorMaze.inventory.delMission(this.missionObjective);
					missionComplete.play();
					this.missionActive = false;
				} else if (world.key == TheDoorMaze.ENTER && message.getIsShown() == true){
					message.removeDashboard();
					((Player) g).setWalkAllowed();
				}
			}
		}
	}
}
