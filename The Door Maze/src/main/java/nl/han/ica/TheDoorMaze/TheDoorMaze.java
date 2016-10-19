package nl.han.ica.TheDoorMaze;

import com.sun.prism.image.ViewPort;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.CenterFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.TheDoorMaze.Player;
import nl.han.ica.waterworld.Swordfish;
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
		addGameObject(locker, 200,200);
		Person person = new Person("src/main/java/nl/han/ica/TheDoorMaze/media/objects/G001.png", "Persoon", this, new String[]{"hoi", "ik"}, "Fix mij een Pizza!");
		addGameObject(person, 400, 200);
		
		//		computer = new Computer(this, "Barry's files");
//		addGameObject(computer, 400, 200);
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
