package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Mission {
	private TheDoorMaze world;
	private String NPCname, name;
	private Item objective, item;
	private String[] text;
	private Sound missionComplete;
	private boolean active, complete;

	public Mission(TheDoorMaze world, String NPCname, String name, Item objective, String[] text, Item item) {
		this.world = world;
		this.NPCname = NPCname;
		this.name = name;
		this.objective = objective;
		this.text = text;
		this.item = item;
		this.missionComplete = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/missionComplete.mp3");
	}
	
	public boolean getActive(){
		return this.active;
	}
	
	public boolean getComplete(){
		return this.complete;
	}
	
	public void start(){
		Map.message = new MessageBox(world, this.NPCname, this.text[0]);
		TheDoorMaze.inventory.addMission(this.name);
		this.active = true;
	}
	
	public void checkMission(){
		if(TheDoorMaze.inventory.getItem(this.objective.getName()).equals(this.objective.getName())) {
			Map.message = new MessageBox(world, this.NPCname, this.text[1]);
			TheDoorMaze.inventory.delItem(this.objective);
			TheDoorMaze.inventory.delMission(this.name);
			TheDoorMaze.inventory.addItem(this.item);
			this.missionComplete.play();
			this.active = true;
			this.complete = true;
		} else {
			Map.message = new MessageBox(world, this.NPCname, this.text[2]);
		}
	}
}
