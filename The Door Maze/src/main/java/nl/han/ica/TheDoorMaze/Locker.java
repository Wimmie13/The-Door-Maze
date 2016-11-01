package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Locker extends ActionObject {
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/locker.png";
	private boolean open;
	private String lock;

	public Locker(TheDoorMaze world, int x, int y, String itemName, String lock) {
		super(world, image, itemName, x, y);
		this.open = false;
		this.lock = lock;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player && world.keyPressed) {
				if (Map.message.getIsShown() == true && world.key == TheDoorMaze.ENTER){
					checkInput();
				} else if (world.key == ' ' && this.isUsed == false && this.open == true) {
					this.addToInventory();
				} else if (world.key == ' ' && this.isUsed == false && Map.message.getIsShown() == false){
					Map.message = new MessageBox(world, "Kluis", new String[]{"Kluis van Ricky", "Gebruik de juiste nummer combinatie."});
					Map.message.hasInput();
				} else if (world.key == ' ' && this.isUsed == true) {
					Map.notify = new Notification(this.world, "Deze kluis is leeg.");
				}
			}
		}
	}
	
	private void checkInput(){
		if(Map.message.getInput().equals(this.lock)){
			this.setOpen();
			this.addToInventory();
			Map.message.removeDashboard();
		} else {
			Map.notify = new Notification(this.world, "Nummer combinatie fout");
			Map.message.removeDashboard();
		}
	}
	
	@Override
	public void keyReleased(int keyCode, char key) {
		if(Map.message.getIsShown()){
			if(key >= '0' && key <= '9' && Map.message.getInput().length() < 4){
				Map.message.setInput(key);
			}
			if(key == TheDoorMaze.BACKSPACE){
				Map.message.setInputBackspace();
			}
		}
	}
	
	public boolean getOpen(){
		return this.open;
	}
	
	public void setOpen(){
		this.open = !this.open;
	}
}
