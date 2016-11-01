package nl.han.ica.TheDoorMaze;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Date extends ActionObject{
	private String[] text;
	private Sound missionComplete;

	public Date(TheDoorMaze world, int x, int y, String image, String[] text) {
		super(world, image, "Date", x, y);
		this.text = text;
		this.missionComplete = new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/missionComplete.mp3");
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player && world.keyPressed) {
				if (world.key == ' ' && this.isUsed == false && Map.message.getIsShown() == false && ((Map)Map.alarm.getTargets().get(0)).getGametime() <= 20) {
					Map.alarm.stop();
					Map.message = new MessageBox(world, "Chantal", new String[]{this.text[0], "Dat heeft wel "+ ((Map)Map.alarm.getTargets().get(0)).getGametime() +" seconden geduurt!"});
					((Player) g).setWalkAllowed();
					missionComplete.play();
					this.isUsed = true;
				}  
				else if (world.key == ' ' && this.isUsed == false && Map.message.getIsShown() == false && ((Map)Map.alarm.getTargets().get(0)).getGametime() >= 20) {
					Map.alarm.stop();
					Map.message = new MessageBox(world, "Chantal", new String[]{this.text[0], "Dat heeft wel "+((Map)Map.alarm.getTargets().get(0)).getGametime()+" seconden geduurt!", "Schiet de volgende keer een beetje op ja!"});
					((Player) g).setWalkAllowed();
					missionComplete.play();
					this.isUsed = true;
				}
				else if (world.key == TheDoorMaze.ENTER && Map.message.getIsShown() == true) {
					Map.message.removeDashboard();
					((Player) g).setWalkAllowed();
					world.setNextMap(3);
				}
			}
		}
	}
	
	public void moveRoom(){
		for(Map map : world.getMaps()){
			if(map.getDate() != null){
				world.getMaps().get(1).getObjects().add(world.getMaps().get(1).getObjects().size()-1, map.getDate());
				if(world.getCurrentMap() == 1){
					world.addGameObject(this);
				} else {
					world.deleteGameObject(this);
				}
				map.getObjects().remove(this);
			}
		}
	}
	
	public void endGame(){
		Map.message = new MessageBox(this.world, "Chantal", new String[]{"Oelewapper, je hebt d'r laten vliegen.", "Dit had ik niet van je verwacht...", "Ik zou d'r niet nog een keer uit vragen."});
		Map.message.removeCloseMessage();
	}
}
