package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.TheDoorMaze.Button;
import nl.han.ica.TheDoorMaze.IMap;
import nl.han.ica.TheDoorMaze.Inventory;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class StartScherm extends Map implements IMap{

	public StartScherm(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
		
		this.objects.add(new Button(world, "src/main/java/nl/han/ica/TheDoorMaze/media/startgame.png",
				mapWidth / 2 - 100, mapHeight / 2 - 125, 200, 50, 1));

	}

	@Override
	public void drawView() {
		this.createView();
		TheDoorMaze.inventory = new Inventory(this.world, 848, 480);
	}

	@Override
	public void initializeSound() {
		// TODO Auto-generated method stub
		
	}
}
