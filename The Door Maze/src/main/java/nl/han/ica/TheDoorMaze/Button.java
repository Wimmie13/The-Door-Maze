package nl.han.ica.TheDoorMaze;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IMouseInput;

public class Button extends SpriteObject implements IMouseInput {
	private final TheDoorMaze world;
	private int nextMap;
	
	public Button(TheDoorMaze world, String img, int x, int y, int width, int height, int nextMap) {
		super(new Sprite(img));
		this.world = world;
		this.nextMap = nextMap;
		
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(int x, int y, int button){
		if(x >= this.x && x <= this.x + this.width && x >= this.y && y <= this.y + this.height){
			world.nextMap = this.nextMap;
		}
	}
}
