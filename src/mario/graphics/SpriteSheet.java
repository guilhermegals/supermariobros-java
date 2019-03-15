package mario.graphics;

import java.awt.image.BufferedImage;


//Classe para recortar cada imagem
public class SpriteSheet {

	private BufferedImage sheet;
	
	//Construtor
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	//Cortar a imagem
	public BufferedImage slice(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
}
