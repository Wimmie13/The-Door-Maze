package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.TheDoorMaze.media.maps.Map0;
import nl.han.ica.TheDoorMaze.media.maps.Map1;
import nl.han.ica.TheDoorMaze.media.maps.Map2;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class TheDoorMaze extends GameEngine {

	public static Inventory inventory;

	private int currentMap;
	public int nextMap;
	private ArrayList<Map> maps;

	private Sound backgroundSound;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.TheDoorMaze.TheDoorMaze" });
	}

	@Override
	public void setupGame() {
		maps = new ArrayList<>();
		maps.add(new Map0(this, 848, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/startscreenbg.png"));
		maps.add(new Map1(this, 2910, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw2.png"));
		maps.add(new Map2(this, 1455, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw.png"));

		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/TheDoorMaze/media/music/intro.mp3");
		backgroundSound.loop(-1);

		this.currentMap = 0;
		this.nextMap = 0;
		this.maps.get(currentMap).drawMap();
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
		if (this.currentMap != this.nextMap) {
			for (int i = 0; i < this.maps.size(); i++) {
				if(nextMap == i){
					this.maps.get(i).drawMap();
					this.currentMap = this.nextMap;
				}
			}
		}

	}

	private void initializeSound(String muziek) {
		backgroundSound.pause();
		backgroundSound = new Sound(this, muziek);
		backgroundSound.loop(-1);
	}

}
