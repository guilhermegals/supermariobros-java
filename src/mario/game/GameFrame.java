package mario.game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import mario.graphics.Assets;

//Janela do jogo
public class GameFrame {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 640;
	public static final String TITLE = "Super Mario Bros!";

	private JFrame frame;
	private Canvas canvas;

	//Construtor
	public GameFrame() {
		frame = new JFrame(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(25, 25);
		frame.setIconImage(Assets.luckyBlock[1]);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
	}

	// Main
	public static void main(String[] args) {
		new Game();
	}

	
	//Get e Set
	
	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

}
