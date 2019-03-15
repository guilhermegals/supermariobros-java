package mario.states;

import java.awt.Graphics;

import mario.game.Handler;

//Classe abstrata referente a cada estado do jogo
public abstract class State {
	private static State currentState = null;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 640;
	protected Handler handler;

	// Construtor
	public State(Handler handler) {
		this.handler = handler;
	}

	// Função abstrata para atualizar os eventos do estado
	public abstract void uptadeEvents();

	// Função abstrata para atualizar os desenhos do estaod
	public abstract void updateDraws(Graphics g);

	
	//Get e Set
	
	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}


}
