package nl.han.ica.TheDoorMaze;

import java.util.ArrayList;

import org.apache.commons.lang3.time.StopWatch;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.TheDoorMaze.media.maps.StartScherm;
import nl.han.ica.waterworld.TextObject;
import nl.han.ica.TheDoorMaze.media.maps.EindScherm;
import nl.han.ica.TheDoorMaze.media.maps.Map1;
import nl.han.ica.TheDoorMaze.media.maps.Map2;
import nl.han.ica.TheDoorMaze.media.maps.Map3;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class TheDoorMaze extends GameEngine {

	public static Inventory inventory;

	public int currentMap;
	public int nextMap;
	public ArrayList<Map> maps;
	private Sound backgroundSound;
	private StopWatch stopWatch;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.TheDoorMaze.TheDoorMaze" });
	}

	@Override
	public void setupGame() {
		backgroundSound = new Sound(this, "src/main/java/nl/han/ica/TheDoorMaze/media/music/intro.mp3");
		initializeSound("src/main/java/nl/han/ica/TheDoorMaze/media/music/intro.mp3");
		maps = new ArrayList<>();
		maps.add(new StartScherm(this, 848, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/startscreenbg.png"));
		maps.add(new Map1(this, 2910, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw2.png"));
		maps.add(new Map2(this, 1455, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw.png"));
		maps.add(new Map3(this, 1455, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/background.fw.png"));
		maps.add(new EindScherm(this, 848, 480, "src/main/java/nl/han/ica/TheDoorMaze/media/endcart.png"));
		this.currentMap = 0;
		this.nextMap = 0;
		this.maps.get(currentMap).drawMap();	
		stopWatch = new StopWatch();
	}

	@Override
	public void update() {
		if (this.currentMap != this.nextMap) {
			for (int i = 0; i < this.maps.size(); i++) {
				if(nextMap == i){
					this.maps.get(i).drawMap();
					this.maps.get(i).setPlayerPosition(this.currentMap);
					this.currentMap = this.nextMap;
				}
			}
		}
	}

	public void initializeSound(String muziek) {
		backgroundSound.pause();
		backgroundSound = new Sound(this, muziek);
		backgroundSound.loop(-1);
	}

	public Sound getBackgroundSound() {
		return backgroundSound;
	}

	public void setBackgroundSound(Sound backgroundSound) {
		this.backgroundSound = backgroundSound;
	}
	
	public StopWatch getStopWatch(){
		return this.stopWatch;
	}
}
