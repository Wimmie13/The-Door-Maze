package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.TheDoorMaze.IMap;
import nl.han.ica.TheDoorMaze.Inventory;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class EindScherm extends Map implements IMap{

	public EindScherm(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
	}

	@Override
	public void drawView() {
		this.createView();
		TheDoorMaze.inventory = new Inventory(this.world, 848, 480);
	}

	@Override
	public void initializeSound() {
		world.getBackgroundSound().pause();
		world.setBackgroundSound(new Sound(world, "src/main/java/nl/han/ica/TheDoorMaze/media/music/ending.mp3"));
		world.getBackgroundSound().loop(-1);
	}
}
