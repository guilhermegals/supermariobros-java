package mario.entity.creature;

import java.awt.Graphics;

import mario.game.Handler;
import mario.graphics.Animation;
import mario.graphics.Assets;
import mario.tiles.Tile;

public class Gobu extends Creature {

	private Animation animation;

	// Construtor
	public Gobu(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32, true, 1);
		rec.x = 0;
		rec.y = 0;
		rec.width = width;
		rec.height = height;
		vel = 1.5f;
		xMove = vel;
		animation = new Animation(150, Assets.gobu);
	}

	// Eventos da entidade Gobu
	@Override
	public void eventsEntity() {
		animation.eventsAnimation(2);
		move();
	}

	// Move entidade Gobu
	@Override
	public void move() {
		if (alive) {
			moveX();
			falling();
			upping();
		}
	}

	// Movimenta no eixo X entidade Gobu
	@Override
	public void moveX() {
		if (xMove > 0) {// Direita
			if (x < ((handler.getWorld().getWidth() * 32) - width - 2)) {
				int tx = (int) (x + xMove + rec.x + rec.width) / Tile.TILEWIDTH;

				if (!colisionTile(tx, (int) (y + rec.y) / Tile.TILEHEIGHT)
						&& !colisionTile(tx, (int) (y + rec.y + rec.height) / Tile.TILEHEIGHT)) {
					x += xMove;
				} else {
					x = tx * Tile.TILEWIDTH - rec.x - rec.width - 1;
					xMove = -vel;
				}
			} else {
				x = (handler.getWorld().getWidth() * 32) - width - 2;
				xMove = -vel;
			}
		} else if (xMove < 0) {// Esquerda
			if (x > 1) {
				int tx = (int) (x + xMove + rec.x) / Tile.TILEWIDTH;

				if (!colisionTile(tx, (int) (y + rec.y) / Tile.TILEHEIGHT)
						&& !colisionTile(tx, (int) (y + rec.y + rec.height) / Tile.TILEHEIGHT)) {
					x += xMove;
				} else {
					x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - rec.x;
					xMove = vel;
				}
			} else {
				x = 1;
				xMove = vel;
			}
		}

	}

	@Override
	public void upping() {
		// TODO Auto-generated method stub

	}

	@Override
	public void falling() {
		int ty = (int) (y + yMove + rec.y + rec.height) / Tile.TILEHEIGHT;

		if (onGround && y < ty * Tile.TILEHEIGHT - rec.y - rec.height - 2
				|| colisionTile((int) ((x + rec.x + rec.width - 2)) / (Tile.TILEWIDTH), ty)
				|| colisionTile((int) ((x + rec.x + rec.width / 12)) / (Tile.TILEWIDTH), ty)) {
			velY = 0;
			onGround = true;
			jumping = false;
			y = ty * Tile.TILEHEIGHT - rec.y - rec.height - 1;

		} else {

		}

	}

	// Desenha entidade Gobu
	@Override
	public void drawEntity(Graphics g) {
		if (alive) {
			g.drawImage(animation.getCurrentFrame(), (int) (x - handler.getCamera().getXFloat()), (int) y, width,
					height, null);
		}
	}

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
