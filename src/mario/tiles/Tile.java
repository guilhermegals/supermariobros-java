package mario.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mario.graphics.Assets;

//Classe para tratar os tiles do jogo
public class Tile {
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected BufferedImage texture;
	protected final int id; //Identificador do Tile
	protected boolean solid, hurt;

	//Construtor
	public Tile(BufferedImage texture, int id, boolean solid) {
		this.texture = texture;
		this.id = id;
		this.solid = solid;
		this.hurt = false;
	}

	//Captura os eventos do Tile
	public void eventsTile() {

	}

	//Desenha o tile
	public void drawTile(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	
	//Get e set
	
	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public boolean isSolid() {
		return solid;
	}
	
	public boolean isHurt() {
		return hurt;
	}

	public void setHurt(boolean hurt) {
		this.hurt = hurt;
	}

	public int getId() {
		return id;
	}
}
