package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.TheDoorMaze.Button;
import nl.han.ica.TheDoorMaze.IMap;
import nl.han.ica.TheDoorMaze.Inventory;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class Map0 extends Map implements IMap{

	public Map0(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
		
//		this.objects.add(new Nothing("src/main/java/nl/han/ica/TheDoorMaze/media/objects/nothing.png", world.getWidth() / 2, world.getHeight() / 2));
		this.objects.add(new Button(world, "src/main/java/nl/han/ica/TheDoorMaze/media/startgame.png",
				mapWidth / 2 - 100, mapHeight / 2 - 125, 200, 50, 1));

	}

	@Override
	public void drawView() {
		this.createView();
		TheDoorMaze.inventory = new Inventory(this.world, 848, 480);
	}
}
