package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

import java.util.List;

public class Locker extends ActionObject implements ICollidableWithGameObjects {
	private TheDoorMaze world;
	private static String image = "src/main/java/nl/han/ica/TheDoorMaze/media/objects/locker.png";
	private boolean open;
	private String lock;
	private MessageBox message;

	public Locker(TheDoorMaze world, int x, int y, String itemName, String lock) {
		super(image, itemName, x, y);
		this.world = world;
		this.open = false;
		this.message = new MessageBox();
		this.lock = lock;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				if (message.getIsShown() == true && world.key == TheDoorMaze.ENTER){
					checkInput();
				} else if (world.key == ' ' && this.isUsed == false && this.open == true) {
					this.isUsed = true;
					TheDoorMaze.inventory.addItem(this.itemName);
				} else if (world.key == ' ' && this.isUsed == false && this.message.getIsShown() == false){
					message = new MessageBox(world, "Locker", "This is the locker of Ricky", "Enter the right values to open the locker.");
					message.hasInput();
				}
			}
		}
	}
	
	private void checkInput(){
		if(this.message.getInput().equals(this.lock)){
			this.setOpen();
			this.isUsed = true;
			TheDoorMaze.inventory.addItem(this.itemName);
			this.message.removeDashboard();
		} else {
			this.message.removeDashboard();
		}
	}
	
	@Override
	public void keyReleased(int keyCode, char key) {
		if(message.getIsShown()){
			if(key >= '0' && key <= '9' && this.message.getInput().length() < 4){
				this.message.setInput(key);
			}
			if(key == TheDoorMaze.BACKSPACE){
				this.message.setInputBackspace();
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
