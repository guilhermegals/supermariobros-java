package mario.graphics;

import java.awt.image.BufferedImage;


//Classe para tratar as animções de cada imagem
public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;

	//Construtor
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	//Captura os eventos da animação
	public void eventsAnimation(int noFrame) {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
				index++;
				if(index == noFrame){
					index++;
				}
				timer = 0;
				if (index >= frames.length) {
					index = 0;
				}
		}
	}
	
	//Captura os eventos da animção
	public void eventsAnimation() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
				index++;
				timer = 0;
				if (index >= frames.length) {
					index = 0;
				}
		}
	}

	
	//Get e Set
	
	public BufferedImage stayFrame(int index) {
		return frames[index];
	}

	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
