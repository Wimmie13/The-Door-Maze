package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.TheDoorMaze.Player;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class TheDoorMaze extends GameEngine {

	public static Inventory inventory;

	public int map;
	private Map map1;

	private Sound backgroundSound;
	private Nothing nothing;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.TheDoorMaze.TheDoorMaze" });
	}

	@Override
	public void setupGame() {
		int screenWidth = 848;
		int screenHeight = 480;

		inventory = new Inventory(this, 848, 480);
		nothing = new Nothing("src/main/java/nl/han/ica/TheDoorMaze/media/objects/nothing.png");
		addGameObject(nothing, screenWidth / 2, screenHeight / 2);
		Button button = new Button("src/main/java/nl/han/ica/TheDoorMaze/media/startgame.png");
		addGameObject(button, screenWidth / 2 - 100, screenHeight / 2 - 125);
		createViewWithViewport(848, 480, 848, 480);
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/TheDoorMaze/media/music/intro.mp3");
		backgroundSound.loop(-1);
		startscreen();
	}

	private void createViewWithViewport(int worldWidth, int worldHeight, int screenWidth, int screenHeight) {
		EdgeFollowingViewport viewPort = new EdgeFollowingViewport(nothing, screenWidth, screenHeight, 0, 0);
		viewPort.setTolerance(0, 0, 0, 0);
		View view = new View(viewPort, worldWidth, worldHeight);
		setView(view);
		size(screenWidth, screenHeight);
		view.setBackground(loadImage("src/main/java/nl/han/ica/TheDoorMaze/media/startscreenbg.png"));
	}

	// private void createObjects() {
	// bathroomdoor = new Door(this,
	// "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "2",
	// "BathRoom", true);
	// addGameObject(bathroomdoor, 700, 130);
	// locker = new Locker(this, "Key #45", "1234");
	// addGameObject(locker, 50, 200);
	// person = new
	// Person("src/main/java/nl/han/ica/TheDoorMaze/media/objects/G001.png",
	// "Persoon1", this, new String[]{"Yo man, ik heb binnenkort een date zou je
	// voor mij een bloem willen fixen?", "Thx man! neem deze condoom, je zult
	// hem nodig hebben ;-)", "Fix eerst die bloem maar eens, dan praten we
	// verder", "Veel succes op je date broer, d'r insta looks boem spang,", "
	// net zoals team boem spang, maar dan minder spang."}, "Fix mij een
	// flower!");
	// addGameObject(person, 400, 200);
	//
	// computer = new Computer(this, "Barry's files");
	// addGameObject(computer, 200, 200);
	// waterfountain = new Waterfountain(this, "Bier");
	// addGameObject(waterfountain, 1000, 218);
	// flower = new Flower(this, "Flower");
	// addGameObject(flower, 900, 200);
	// Key sleutel = new Key(this, "2");
	// addGameObject(sleutel, 1300, 250);
	// Bookshelf playboy = new Bookshelf(this, "playboy");
	// addGameObject(playboy, 1600, 170);
	// player = new Player(this);
	// addGameObject(player, 600, 200);
	// }

	@Override
	public void update() {
		switch (map) {
		case 1:
			this.map1();
			break;
		case 2:
			this.map2();
			break;
		case 1000:
			this.startscreen();
			break;
		case 1001:
			this.startgame();
			break;
		}
	}

	private void initializeSound(String muziek) {
		backgroundSound.pause();
		backgroundSound = new Sound(this, muziek);
		backgroundSound.loop(-1);
	}

	private void startgame() {
		this.deleteAllGameOBjects();
		this.deleteAllDashboards();
		inventory = new Inventory(this, 848, 480);
		initializeSound("src/main/java/nl/han/ica/TheDoorMaze/media/music/level1.mp3");
		this.map = 1;
	}

	private void map1() {
		map1 = new Map(this, 2910, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw2.png");
		map1.addObject(new Door(this, 700, 130, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "2",
				"BathRoom", true));
		map1.addObject(new Locker(this, 50, 200, "Key #45", "1234"));
		map1.addObject(
				new Person(this, 400, 200, "src/main/java/nl/han/ica/TheDoorMaze/media/objects/G001.png", "Persoon",
						new String[] { "Yo man, ik heb binnenkort een date zou je voor mij een bloem willen fixen?",
								"Thx man! neem deze condoom, je zult hem nodig hebben ;-)",
								"Fix eerst die bloem maar eens, dan praten we verder",
								"Veel succes op je date broer, d'r insta looks boem spang,",
								" net zoals team boem spang, maar dan minder spang." },
						"Fix mij een flower!"));
		map1.addObject(new Computer(this, 200, 200, "Barry's files"));
		map1.addObject(new Waterfountain(this, 1000, 218, "Bier"));
		map1.addObject(new Flower(this, 900, 200, "Flower"));
		map1.addObject(new Key(this, 1300, 250, "2"));
		map1.addObject(new Bookshelf(this, 1600, 170, "playboy"));
		map1.addObject(new Player(this, 600, 200));
		map1.drawMap();

		EdgeFollowingViewport viewPort = new EdgeFollowingViewport(map1.getPlayer(), 848, 480, 0, 80);
		viewPort.setTolerance(0, 0, 100, 100);
		View view = new View(viewPort, map1.getMapWidth(), map1.getMapHeight());
		setView(view);
		view.setBackground(loadImage(map1.getBackground()));
		this.map = 0;
	}

	private void map2() {
		Map map2 = new Map(this, 1455, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw.png");
		map2.addObject(new Computer(this, 600, 200, "Barry's files"));
		map2.addObject(new Door(this, 700, 130, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "1",
				"BathRoom", false));
		map2.addObject(new Player(this, 600, 200));
		map2.drawMap();

		EdgeFollowingViewport viewPort = new EdgeFollowingViewport(map2.getPlayer(), 840, 480, 0, 80);
		viewPort.setTolerance(0, 0, 100, 100);
		View view = new View(viewPort, map2.getMapWidth(), map2.getMapHeight());
		setView(view);
		view.setBackground(loadImage(map2.getBackground()));
		this.map = 0;
	}

	private void startscreen() {
		map = 1000;
		System.out.println(this.mouseY);
		System.out.println(this.getWidth());
		if (this.mouseX >= this.getWidth() / 2 - 100 && this.mouseX <= this.getWidth() / 2 + 100
				&& this.mouseY >= this.getHeight() / 2 - 125 && this.mouseY <= this.getHeight() / 2 - 75
				&& this.mousePressed) {
			map = 1001;
		}
	}

}
