package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.tiles.BoardsTile2;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;

public class ActionObject extends SpriteObject {
	protected String itemName;
	protected boolean isUsed = false;
	private Dashboard dashboardAction;
	private float dashboardX, dashboardY, dashboardWidth, dashboardHeight;
	private boolean isOpen = false;
	private TheDoorMaze world;
	
	
	public ActionObject(String img, String itemName, TheDoorMaze world) {
		super(new Sprite(img));
		this.itemName = itemName;
		this.dashboardX = (world.getWidth() / 3) / 2;
		this.dashboardY = (world.getHeight() / 3) / 2;
		this.dashboardWidth = (world.getWidth() / 3) * 2;
		this.dashboardHeight = (world.getHeight() / 3) * 2;
		this.world = world;
	}
	
	public ActionObject(String img, String itemName) {
		super(new Sprite(img));
		this.itemName = itemName;
	}

	@Override
	public void update() {
	}
	public boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen() {
		this.isOpen = !this.isOpen;
	}
	
	public void createDashboard() {
		dashboardAction = new Dashboard(this.dashboardX, this.dashboardY, this.dashboardWidth, this.dashboardHeight);

		dashboardAction.addGameObject(this);

		world.addDashboard(dashboardAction);
	}
	
	public void removeDashboard(){
		world.deleteDashboard(dashboardAction);
	}

}
