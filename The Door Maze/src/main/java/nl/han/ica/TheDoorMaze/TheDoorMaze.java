package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.TheDoorMaze.Player;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class TheDoorMaze extends GameEngine {

	private Player player;
	private Door bathroomdoor;
	private Flower flower;
	private Waterfountain waterfountain;
	private Locker locker;
	private Computer computer;
	public static Inventory inventory;
	public Person person;
	
	private Sound backgroundSound;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.TheDoorMaze.TheDoorMaze" });
	}

	@Override
	public void setupGame() {
		int worldWidth = 1455;
		int worldHeight = 480;
		
		createObjects();
        initializeSound();
		createViewWithViewport(worldWidth, worldHeight, 848, 480);
		
		inventory = new Inventory(this);
	}

	private void createViewWithViewport(int worldWidth, int worldHeight, int screenWidth, int screenHeight) {
		EdgeFollowingViewport viewPort = new EdgeFollowingViewport(player, screenWidth, screenHeight, 0, 80);
		viewPort.setTolerance(0, 0, 100, 100);
		View view = new View(viewPort, worldWidth, worldHeight);
		setView(view);
		size(screenWidth, screenHeight);
		view.setBackground(loadImage("src/main/java/nl/han/ica/TheDoorMaze/media/background.fw.png"));
	}

	private void createObjects() {
		bathroomdoor = new Door(this, "src/main/java/nl/han/ica/TheDoorMaze/media/doors/Toilet.png", "1", "BathRoom");
		addGameObject(bathroomdoor, 700, 130);
		locker = new Locker(this, "Key #45");
		addGameObject(locker, 50, 200);
		person = new Person("src/main/java/nl/han/ica/TheDoorMaze/media/objects/G001.png", "Persoon", this, new String[]{"Yo man, ik heb binnenkort een date zou je voor mij een bloem willen fixen?", "Thx man! neem deze condoom, je zult hem nodig hebben ;-)", "Fix eerst die bloem maar eens, dan praten we verder", "Veel succes op je date broer, d'r insta looks boem spang,", " net zoals team boem spang, maar dan minder spang."}, "Fix mij een flower!");
		addGameObject(person, 400, 200);
		
		computer = new Computer(this, "Barry's files");
		addGameObject(computer, 200, 200);
		waterfountain = new Waterfountain(this, "Bier");
		addGameObject(waterfountain, 1000, 218);
		flower = new Flower(this, "Flower");
		addGameObject(flower, 900, 200);
		Key sleutel = new Key(this, "1");
		addGameObject(sleutel, 1300, 250);
		player = new Player(this);
		addGameObject(player, 600, 200);
	}

	@Override
	public void update() {
	}
	
    private void initializeSound() {
      backgroundSound = new Sound(this, "src/main/java/nl/han/ica/TheDoorMaze/media/music/level1.mp3");
      backgroundSound.loop(-1);
  }

}
