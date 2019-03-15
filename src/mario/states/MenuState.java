package mario.states;

import java.awt.Graphics;

import mario.game.Handler;
import mario.graphics.Animation;
import mario.graphics.Assets;
import mario.graphics.Audio;

public class MenuState extends State {

	Animation animation;

	// Construtor
	public MenuState(Handler handler) {
		super(handler);
		animation = new Animation(300, Assets.tick);
		
	}

	// Atualiza eventos do estado Menu
	@Override
	public void uptadeEvents() {
		if (handler.getKeyManager().keyEnter) {
			setState(new GameState(handler));
			//Assets.audioSong.stop();
			//setState(handler.getGame().gameState);
		}

		animation.eventsAnimation();

	}

	// Atualiza os desenhos do estado Menu
	@Override
	public void updateDraws(Graphics g) {

		g.drawImage(Assets.menu, 0, 0, 1280, 640, null);
		g.drawImage(animation.getCurrentFrame(), 226*2, 194*2, 210*2, 30*2, null);
		//Assets.audioSong.play(1);
		

	}

}
