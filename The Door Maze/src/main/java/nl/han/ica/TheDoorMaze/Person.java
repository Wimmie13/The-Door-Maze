package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;
import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public class Person extends ActionObject {
	private String[] text;
	private ArrayList<Mission> missions;

	public Person(TheDoorMaze world, int x, int y, String image, String itemName, String[] text) {
		super(world, image, itemName, x, y);
		this.text = text;
		this.missions = new ArrayList<>();
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player && world.keyPressed) {
				if(world.key == ' ' && this.hasMission() && Map.message.getIsShown() == false){
					if(this.getActiveMission() != null){
						this.getActiveMission().checkMission();
					} else {
						this.startMission();
					}
				} else if (world.key == ' ' && this.getActiveMission() != null && this.hasMission() == false && Map.message.getIsShown() == false) {
					Map.message = new MessageBox(world, itemName, this.text);
				} else if (world.key == TheDoorMaze.ENTER) {
					if(Map.message.getIsShown() == true){
						Map.message.removeDashboard();
					}
				}
			}
		}
	}
	
	public void addMission(String missionName, String objective, String[][] text, String item){
		this.missions.add(new Mission(world, this.itemName, missionName, objective, text, item));
	}
	
	private boolean hasMission(){
		if(this.missions.size() > 0){
			if(this.missions.get(this.missions.size() - 1).getComplete() == false){
				return true;
			}
		}
		return false;
	}
	
	private Mission getActiveMission(){
		for(int i = 0; i < this.missions.size(); i++){
			if(this.missions.get(i).getActive() == true){
				return this.missions.get(i);
			}
		}
		return null;
	}
	
	private void startMission(){
		for(int i = 0; i < this.missions.size(); i++){
			if(this.missions.get(i).getComplete() == false){
				this.missions.get(i).start();
				return;
			}
		}
	}
}
