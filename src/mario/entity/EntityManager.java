package mario.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import mario.entity.creature.Mario;
import mario.game.Handler;

public class EntityManager {
	private Handler handler;
	private Mario player;

	private ArrayList<Entity> entityList;

	//Construtor
	public EntityManager(Handler handler, Mario player) {
		this.player = player;
		this.handler = handler;
		entityList = new ArrayList<Entity>();
		entityList.add(this.player);
	}

	//Eventos de todas as entidades da lista
	public void eventsEntities() {
		for (Entity e : entityList) {
			e.eventsEntity();
		}
	}

	//Desenho de todas as entidades da lista
	public void drawEntities(Graphics g) {
		for (Entity e : entityList) {
			e.drawEntity(g);
		}
	}

	//Adiciona uma entidade
	public void addEntity(Entity e) {
		entityList.add(e);
	}
	

	//Get e Set

	public Handler getHandler() {
		return handler;
	}

	public Mario getPlayer() {
		return player;
	}

	public ArrayList<Entity> getEntityList() {
		return entityList;
	}

}
