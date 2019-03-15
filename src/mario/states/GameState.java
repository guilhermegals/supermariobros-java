package mario.states;

import java.awt.Color;
import java.awt.Graphics;

import mario.game.Handler;
import mario.graphics.Assets;
import mario.graphics.Audio;
import mario.maps.MapLevel1;
import mario.maps.MapLevel2;

public class GameState extends State {

	private MapLevel1 map1;
	private MapLevel2 map2;

	// Construtor
	public GameState(Handler handler) {
		super(handler);
		handler.setWorld(new MapLevel1(handler, "res/Maps/MapaLevel1.csv", 213, 21, "1  1", 300));
	}

	// Atualiza os eventos do estado Game
	@Override
	public void uptadeEvents() {
		handler.getWorld().eventsMap();
		if (handler.getKeyManager().keyEsc) {
			State.setState(new MenuState(handler));
		}
		if(handler.getWorld().getEntityManager().getPlayer().getnLifes() == 0 ){
			State.setState(new MenuState(handler));
		}
	}

	// Atualiza os desenhos do estado Game
	@Override
	public void updateDraws(Graphics g) {
		handler.getWorld().drawMap(g);
	}
}
