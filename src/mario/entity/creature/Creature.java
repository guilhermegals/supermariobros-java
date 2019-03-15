package mario.entity.creature;

import java.awt.Graphics;

import mario.entity.Entity;
import mario.game.Handler;
import mario.tiles.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_LIFE = 1;
	public static final float DEFAULT_VEL = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 32;

	public static final float GRAVITY = 0.3f;
	protected float velY = 0f, vel, xMove, yMove;
	protected boolean onGround = true, jumping = false;
	protected int nLifes;

	// Construtor
	public Creature(Handler handler, float x, float y, int width, int height, boolean hurt, int idEnty) {
		super(handler, x, y, width, height, hurt, idEnty);
		vel = DEFAULT_VEL;
		xMove = 0;
		yMove = 0;
		nLifes = DEFAULT_LIFE;
	}

	// Pulo da criatura
	public void jump() {
		if (jumping) {
			if (onGround) {
				velY = -9.2f;
				onGround = false;
			}
		}

	}

	// Movimentação da criatura
	public abstract void move();

	public abstract void upping();

	public abstract void falling();

	public abstract void moveX();

	// Verifica se uma entidade Creatura esta colidindo com um Tile
	public boolean colisionTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// Get e Set

	public float getVel() {
		return vel;
	}

	public void setVel(float vel) {
		this.vel = vel;
	}

	@Override
	public void eventsEntity() {
		// TODO Auto-generated method stub

	}
	
	

	public int getnLifes() {
		return nLifes;
	}

	@Override
	public void drawEntity(Graphics g) {

	}

}
