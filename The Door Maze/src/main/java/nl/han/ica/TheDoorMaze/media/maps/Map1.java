package nl.han.ica.TheDoorMaze.media.maps;

import nl.han.ica.TheDoorMaze.Bookshelf;
import nl.han.ica.TheDoorMaze.Computer;
import nl.han.ica.TheDoorMaze.Door;
import nl.han.ica.TheDoorMaze.Flower;
import nl.han.ica.TheDoorMaze.Key;
import nl.han.ica.TheDoorMaze.Locker;
import nl.han.ica.TheDoorMaze.Map;
import nl.han.ica.TheDoorMaze.Person;
import nl.han.ica.TheDoorMaze.Player;
import nl.han.ica.TheDoorMaze.TheDoorMaze;
import nl.han.ica.TheDoorMaze.Waterfountain;

public class Map1 extends Map{

	public Map1(TheDoorMaze world, int mapWidth, int mapHeight, String background) {
		super(world, mapWidth, mapHeight, background);
		
		this.objects.add(new Door(this.world, 700, 130, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "2",
				"BathRoom", true));
		this.objects.add(new Locker(this.world, 50, 200, "Key #45", "1234"));
		this.objects.add(
				new Person(world, 400, 200, "src/main/java/nl/han/ica/TheDoorMaze/media/objects/G001.png", "Persoon",
						new String[] { "Yo man, ik heb binnenkort een date zou je voor mij een bloem willen fixen?",
								"Thx man! neem deze condoom, je zult hem nodig hebben ;-)",
								"Fix eerst die bloem maar eens, dan praten we verder",
								"Veel succes op je date broer, d'r insta looks boem spang,",
								" net zoals team boem spang, maar dan minder spang." },
						"Fix mij een flower!"));
		this.objects.add(new Computer(this.world, 200, 200, "Barry's files"));
		this.objects.add(new Waterfountain(this.world, 1000, 218, "Bier"));
		this.objects.add(new Flower(this.world, 900, 200, "Flower"));
		this.objects.add(new Key(this.world, 1300, 250, "2"));
		this.objects.add(new Bookshelf(this.world, 1600, 170, "playboy"));
		this.objects.add(new Player(this.world, 600, 200));
		this.drawMap();
		this.createEdgeView(848, 480, 0, 80, this.getPlayer());
	}

}
