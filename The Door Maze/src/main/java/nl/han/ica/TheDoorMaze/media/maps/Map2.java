package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.TheDoorMaze.Computer;
import nl.han.ica.TheDoorMaze.Door;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.Player;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class Map2 extends Map{

	public Map2(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
		// TODO Auto-generated constructor stub
		this.objects.add(new Computer(this.world, 600, 200, "Barry's files"));
		this.objects.add(new Door(this.world, 700, 130, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "1",
				"BathRoom", false));
		this.objects.add(new Player(this.world, 600, 200));
		this.drawMap();
		this.createEdgeView(848, 480, 0, 80, this.getPlayer());
	}

}
