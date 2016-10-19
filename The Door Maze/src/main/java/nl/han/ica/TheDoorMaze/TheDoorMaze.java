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

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.TheDoorMaze.TheDoorMaze" });

	}

	@Override
	public void setupGame() {
		int worldWidth = 1455;
		int worldHeight = 480;

		createObjects();

		createViewWithViewport(worldWidth, worldHeight, 848, 480);
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
		bathroomdoor = new Door(this, "src/main/java/nl/han/ica/TheDoorMaze/media/Toilet.png", 1, "BathRoom");
		addGameObject(bathroomdoor, 700, 130);
		flower = new Flower(this, "Flower");
		addGameObject(flower, 900, 200);
		player = new Player(this);
		addGameObject(player, 600, 200);
	}

	@Override
	public void update() {
	}

}
