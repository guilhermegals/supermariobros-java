package mario.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Classe para capturar os eventos de teclado do jogo
public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean keyUp, keyDown, keyLeft, keyRight, keyEnter, keyEsc, keyP;

	//Construtor
	public KeyManager() {
		keys = new boolean[256];
	}

	//Eventos de teclas
	public void eventKey() {
		keyUp = keys[KeyEvent.VK_UP];
		keyDown = keys[KeyEvent.VK_DOWN];
		keyLeft = keys[KeyEvent.VK_LEFT];
		keyRight = keys[KeyEvent.VK_RIGHT];
		keyEnter = keys[KeyEvent.VK_ENTER];
		keyEsc = keys[KeyEvent.VK_ESCAPE];
		keyP = keys[KeyEvent.VK_P];
	}

	//Tecla pressionada
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	//Tecla	solta
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	//Tecla clicada
	@Override
	public void keyTyped(KeyEvent e) {

	}

}
