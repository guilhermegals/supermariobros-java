package mario.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import mario.game.Handler;

public abstract class Entity {
	protected float x, y;
	protected int width, height;
	protected Handler handler;
	protected Rectangle rec;
	protected boolean alive;
	protected boolean hurt;

	protected int idEnty;

	// Construtor
	public Entity(Handler handler, float x, float y, int width, int height, boolean hurt, int id) {
		this.x = x;
		this.y = y;
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.alive = true;
		this.hurt = hurt;
		this.idEnty = id;

		this.rec = new Rectangle(0, 0, this.width, this.height);
	}

	// Retorna o retangulo da colisao
	public Rectangle getCollisionBounds(float xOffset, float yOffset, int location) {
		return new Rectangle((int) (x + rec.x + xOffset) / location, (int) (y + rec.y + yOffset) / location,
				rec.width / location, (rec.height / location) + 1);
	}

	public abstract void death();

	public void hit() {
		alive = false;
	}

	// Verifica se ouver colisao entre entidades
	public abstract boolean checkEntityCollisions(float xOffset, float yOffset);

	// Função abstrata dos eventos de uma entidade
	public abstract void eventsEntity();

	// Função abstrata para desenhar uma entidade
	public abstract void drawEntity(Graphics g);

	// Get e Set

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getIdEnty() {
		return idEnty;
	}

}
