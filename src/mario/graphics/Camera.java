package mario.graphics;

import mario.entity.Entity;
import mario.game.Handler;
import mario.tiles.Tile;

//Classe camera para controlar a movimentação da camera
public class Camera {
	private Handler handler;
	private float xFloat;

	// Construtor
	public Camera(Handler handler, float xFloat) {
		this.handler = handler;
		this.xFloat = xFloat;
	}

	// Centraliza a camera/tela do jogo em relaçao a entidade
	public void centerEntity(Entity e) {
		xFloat = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		if (xFloat < 0) {
			xFloat = 0;
		} else if (xFloat > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xFloat = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}

	}

	// Movimenta a camera no eixo X
	public void move(float xAmt) {
		xFloat += xAmt;

	}

	// Get e Set

	public float getXFloat() {
		return xFloat;
	}

	public void setXFloat(float xOffset) {
		this.xFloat = xOffset;
	}

}
