package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.TheDoorMaze.Computer;
import nl.han.ica.TheDoorMaze.Date;
import nl.han.ica.TheDoorMaze.Door;
import nl.han.ica.TheDoorMaze.IMap;
import nl.han.ica.TheDoorMaze.Inventory;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.Person;
import nl.han.ica.TheDoorMaze.Person2;
import nl.han.ica.TheDoorMaze.Player;
import nl.han.ica.TheDoorMaze.TheDoorMaze;

public class Map2 extends Map implements IMap{

	public Map2(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
		// TODO Auto-generated constructor stub
		this.objects.add(new Computer(this.world, 600, 200, "Barry's files"));
		this.objects.add(new Door(this.world, 700, 130, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "1",
				"BathRoom", false));
		this.objects.add(new Door(this.world, 1000, 100, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/door3.png", "3",
				"Klas 03", true));
		this.objects.add(
				new Person2(world, 400, 200, "src/main/java/nl/han/ica/TheDoorMaze/media/objects/008.png", "Persoon",
						new String[] { "Ja ik heb de sleutel van lokaal #6 voor je, maar ik ben mijn boeken vergeten.",
								"Kun je deze toevallig jatten uit de kluis van Ricky? Chris weet vast de code!",
								"Bij deze heb je je sleutel man",
								"Fix eerst die boeken maar eens, dan praten we verder",
								"Succes broer!" },
						"Steel voor mij wat boeken"));
		this.objects.add(new Player(this.world, 500, 200));
	}

	@Override
	public void drawView() {
		this.createEdgeView(848, 480, 0, 80, this.getPlayer());
	}

	@Override
	public void initializeSound() {
		// TODO Auto-generated method stub
		
	}

}
