package mario.game;

import mario.graphics.Camera;
import mario.input.KeyManager;
import mario.input.MouseManager;
import mario.maps.Map;
import mario.maps.MapLevel1;


//Classe para pegar as informções de cada objeto
public class Handler {
	
	private Game game;
	private Map map;
	
	//Get e Set
	
	public Handler(Game game){
		this.game = game;
	}
	
	public Camera getCamera(){
		return game.getCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Map getWorld() {
		return map;
	}

	public void setWorld(Map map) {
		this.map = map;
	}

}
