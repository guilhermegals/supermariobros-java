package mario.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import mario.graphics.Assets;
import mario.graphics.Audio;
import mario.graphics.Camera;
import mario.input.KeyManager;
import mario.input.MouseManager;
import mario.states.MenuState;
import mario.states.State;

public class Game implements Runnable {
	private static final int FPS = 60;
	private double timePerFrame = 1000000000 / FPS;
	private boolean running = false;

	private Thread thread;
	private BufferStrategy strategy;
	private Graphics g;

	private GameFrame gFrame;
	public State gameState, menuState;
	private Camera camera;
	private Handler handler;

	private KeyManager keyManager;
	private MouseManager mouseManager;

	//Construtor
	public Game() {
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		start();
	}

	//Inicializa tudo
	private void init() {
		Assets.load();
		gFrame = new GameFrame();
		handler = new Handler(this);
		gFrame.getFrame().addKeyListener(keyManager);
		gFrame.getFrame().addMouseListener(mouseManager);
		gFrame.getFrame().addMouseMotionListener(mouseManager);
		gFrame.getCanvas().addMouseListener(mouseManager);
		gFrame.getCanvas().addMouseMotionListener(mouseManager);
		//gameState = new GameState(handler);
		//menuState = new MenuState(handler);
		camera = new Camera(handler, 0);
		//State.setState(menuState);
		Audio.play(Assets.audioSong, true);
		State.setState(new MenuState(handler)); //Inicializa a atual tela do jogo

	}

	//Captura todos os eventos da tela
	private void uptadeEvents() {
		keyManager.eventKey();
		if (State.getState() != null) {
			State.getState().uptadeEvents();
		}
	}

	//Desenha os objetos na tela
	private void updateDraws() {
		strategy = gFrame.getCanvas().getBufferStrategy();
		if (strategy == null) {
			gFrame.getCanvas().createBufferStrategy(3);
			return;
		}
		g = strategy.getDrawGraphics();
		// Limoa a tela
		g.clearRect(0, 0, gFrame.WIDTH, gFrame.HEIGHT);
		// Começa a desenhar
		if (State.getState() != null) {
			State.getState().updateDraws(g);
		}
		// Termina os desenhos
		strategy.show(); //Mostra tudo na tela
		g.dispose();
	}

	//Game loop
	@Override
	public void run() {
		init();
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int frames = 0;
		while (running) { //Loop do jogo e controle de FPS
			now = System.nanoTime();
			delta += (now - lastTime) / timePerFrame;
			timer += now - lastTime;
			lastTime = now;
			if (delta > 1) {
				uptadeEvents();
				updateDraws();
				frames++;
				delta--;
			}
			if (timer >= 1000000000) {
				frames = 0;
				timer = 0;
			}

		}
		stop();
	}

	//Iniciando a thread
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	//Parando a thread
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	//Get e Set
	
	public int getWidth() {
		return gFrame.WIDTH;
	}

	public int getHeight() {
		return gFrame.HEIGHT;
	}

	public Camera getCamera() {
		return camera;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}

}
