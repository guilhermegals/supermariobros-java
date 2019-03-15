package mario.entity.statics;

import java.awt.Graphics;

import mario.game.Handler;
import mario.graphics.Animation;
import mario.graphics.Assets;
import mario.tiles.Tile;

public class LuckyBlock extends StaticEntity {

	private Animation animation;

	// Construtor
	public LuckyBlock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, false, 2);
		animation = new Animation(200, Assets.luckyBlock);
	}

	// Eventos da entidade estática
	@Override
	public void eventsEntity() {
		// TODO Auto-generated method stub
		animation.eventsAnimation(4);
	}

	// Desenho da entidade estática
	@Override
	public void drawEntity(Graphics g) {
		if (alive) {
			g.drawImage(animation.getCurrentFrame(), (int) (x - handler.getCamera().getXFloat()), (int) y, width,
					height, null);
		} else {
			g.drawImage(animation.stayFrame(4), (int) (x - handler.getCamera().getXFloat()), (int) y, width, height,
					null);
		}

	}

	// Get e Set

	@Override
	public void death() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		// TODO Auto-generated method stub
		return false;
	}

}
