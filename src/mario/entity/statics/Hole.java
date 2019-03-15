package mario.entity.statics;

import java.awt.Graphics;

import mario.game.Handler;
import mario.graphics.Assets;
import mario.tiles.Tile;

public class Hole extends StaticEntity{

	public Hole(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, true, 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void death() {
		
	}

	@Override
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eventsEntity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawEntity(Graphics g) {
		//g.drawImage(Assets.lava, (int) (x - handler.getCamera().getXFloat()), (int) y, width, height,
				//null);
		
	}

}
