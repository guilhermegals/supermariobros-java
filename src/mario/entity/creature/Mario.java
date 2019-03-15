package mario.entity.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mario.entity.Entity;
import mario.game.Handler;
import mario.graphics.Animation;
import mario.graphics.Assets;
import mario.graphics.Audio;
import mario.tiles.Tile;

public class Mario extends Creature {

	private Animation animationLeft, animationRight;
	private int score;

	public boolean levelComplete = false;

	// Construtor
	public Mario(Handler handler, float x, float y) {
		super(handler, x, y, 26, 32, false, 0);
		rec.x = 0;
		rec.y = 0;
		rec.width = width;
		rec.height = height;
		animationLeft = new Animation(150, Assets.playerLeft);
		animationRight = new Animation(150, Assets.playerRight);
		nLifes = 3;
		score = 0;

	}

	// Eventos da entidade player
	@Override
	public void eventsEntity() {
		getInput();
		animationLeft.eventsAnimation(3);
		animationRight.eventsAnimation(3);
		move();
		handler.getCamera().centerEntity(this);

	}

	// Função para movimentação do player
	@Override
	public void move() {

		moveX();
		jump();
		upping();
		falling();

	}

	// Captura o teclado
	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().keyUp) {
			jumping = true;
			if (onGround && jumping) {
				// Assets.audioJump.play(1);
				Audio.play(Assets.audioJump, false);
			}
		}
		if (handler.getKeyManager().keyDown) {
			yMove = vel;
		}
		if (handler.getKeyManager().keyLeft) {
			xMove = -vel;
		}
		if (handler.getKeyManager().keyRight) {
			xMove = vel;
		}

	}

	// Quando o player estiver subindo
	@Override
	public void upping() {

		int ty = (int) (y + yMove + rec.y - 1) / Tile.TILEHEIGHT;
		velY = velY + GRAVITY;
		if (!colisionTile((int) (x + rec.x) / Tile.TILEWIDTH, ty)
				&& !colisionTile((int) (x + rec.x + rec.width) / Tile.TILEWIDTH, ty)) {
			y += velY;
		} else {
			y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - rec.y + 2;
			velY = 0;
		}

	}

	// Quando o player estiver descendo
	@Override
	public void falling() {

		int ty = (int) (y + yMove + rec.y + rec.height) / Tile.TILEHEIGHT;

		if (onGround && y < ty * Tile.TILEHEIGHT - rec.y - rec.height - 2
				|| colisionTile((int) ((x + rec.x + rec.width - 2)) / (Tile.TILEWIDTH), ty)
				|| colisionTile((int) ((x + rec.x + rec.width / 12)) / (Tile.TILEWIDTH), ty)
				|| checkEntityCollisions(0f, yMove)) {
			velY = 0;
			onGround = true;
			jumping = false;
			y = ty * Tile.TILEHEIGHT - rec.y - rec.height - 1;
		} else {

		}

	}

	// Quando o player estiver movimentando no eixo X
	@Override
	public void moveX() {
		if (!checkEntityCollisions(xMove, 0f)) {
			if (xMove > 0) {// Moving right
				if (x < ((handler.getWorld().getWidth() * 32) - width - 2)) {
					int tx = (int) (x + xMove + rec.x + rec.width) / Tile.TILEWIDTH;

					if (!colisionTile(tx, (int) (y + rec.y) / Tile.TILEHEIGHT)
							&& !colisionTile(tx, (int) (y + rec.y + rec.height) / Tile.TILEHEIGHT)) {
						x += xMove;
					} else {
						x = tx * Tile.TILEWIDTH - rec.x - rec.width - 1;
					}
				} else {
					x = (handler.getWorld().getWidth() * 32) - width - 2;
				}
			} else if (xMove < 0) {// Moving left
				if (x > 1) {
					int tx = (int) (x + xMove + rec.x) / Tile.TILEWIDTH;

					if (!colisionTile(tx, (int) (y + rec.y) / Tile.TILEHEIGHT)
							&& !colisionTile(tx, (int) (y + rec.y + rec.height) / Tile.TILEHEIGHT)) {
						x += xMove;
					} else {
						x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - rec.x;
					}
				} else {
					x = 1;
				}
			}
		}
	}

	// Verifica se ouver colisao entre entidades
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		int index = 1;
		for (Entity e : handler.getWorld().getEntityManager().getEntityList()) {

			if (e.equals(this))
				continue;
			if (e.getIdEnty() == 2) {
				if (e.isAlive()) {
					if (e.getCollisionBounds(0f, 0f, 1).intersects(getCollisionBounds(0f, yOffset, 1))) {
						e.setAlive(false);
						Audio.play(Assets.audioCoin, false);
						score += 50;
						return true;
					}
				}
				if (e.getCollisionBounds(0f, 0f, 1).intersects(getCollisionBounds(xOffset, yOffset, 1))) {
					return true;
				}

			}
			if (e.getIdEnty() == 1 && e.isAlive()) {
				if (e.getCollisionBounds(0f, 0f, 2).intersects(getCollisionBounds(0f, yOffset, 2))) {
					e.setAlive(false);
					// handler.getWorld().getEntityManager().getEntityList().remove(index);
					score += 200;
					Audio.play(Assets.audioJump, false);
					onGround = false;
					velY = -11.2f;
					jumping = true;
					return false;
				}
				if (e.getCollisionBounds(0f, 0f, 2).intersects(getCollisionBounds(xOffset, 0f, 2))) {
					death();
					return false;
				}

			}

			if (e.getIdEnty() == 3) {
				if (e.getCollisionBounds(0f, 0f, 1).intersects(getCollisionBounds(0f, yOffset, 1))) {

					death();
					return false;
				}
			}

			index++;
		}
		index = 1;
		return false;
	}

	// Desenha entidade player
	@Override
	public void drawEntity(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getCamera().getXFloat()), (int) y, width, height,
				null);
	}

	// Retorna o atual frame
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0 && !jumping) {
			return animationLeft.getCurrentFrame();
		} else if (xMove > 0 && !jumping) {
			return animationRight.getCurrentFrame();
		} else if (xMove > 0 && jumping) {
			return Assets.playerJumpRight;
		} else if (xMove < 0 && jumping) {
			return Assets.playerJumpLeft;
		} else if (jumping) {
			return Assets.playerJumpRight;
		} else if (yMove > 0) {

		}
		return animationRight.stayFrame(3);
	}

	public int getScore() {
		return score;
	}

	@Override
	public void death() {
		Audio.play(Assets.audioDeath, false);
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nLifes--;
		x = 100;
		y = 543;

	}
}
