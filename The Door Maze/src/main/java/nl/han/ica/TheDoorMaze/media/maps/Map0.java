package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.TheDoorMaze.Button;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class Map0 extends Map{
	private SpriteObject nothing;

	public Map0(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
		
		this.objects.add(new SpriteObject(new Sprite("src/main/java/nl/han/ica/TheDoorMaze/media/objects/nothing.png")));
		
		addGameObject(nothing, screenWidth / 2, screenHeight / 2);
		Button button = new Button("src/main/java/nl/han/ica/TheDoorMaze/media/startgame.png");
		addGameObject(button, screenWidth / 2 - 100, screenHeight / 2 - 125);
		createEdgeView(848, 480, 848, 480, 0, 0, nothing);
		startscreen();
	}

}
