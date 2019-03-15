package mario.maps;

import java.awt.Color;
import java.awt.Graphics;

import mario.entity.EntityManager;
import mario.entity.creature.Gobu;
import mario.entity.creature.Mario;
import mario.entity.statics.Hole;
import mario.entity.statics.LuckyBlock;
import mario.game.Handler;
import mario.graphics.Assets;
import mario.graphics.Audio;
import mario.graphics.Text;
import mario.tiles.Tile;
import mario.utils.Utils;

//Classe do mapa level 1-1
public class MapLevel1 extends Map {

	// Construtor
	public MapLevel1(Handler handler, String path, int w, int h, String nameMap, int mapTime) {
		super(handler, path, w, h, nameMap, mapTime);

		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 16, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 21, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 23, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 22, Tile.TILEWIDTH * 10));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 78, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 94, Tile.TILEWIDTH * 10));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 105, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 108, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 111, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 108, Tile.TILEWIDTH * 10));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 128, Tile.TILEWIDTH * 10));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 129, Tile.TILEWIDTH * 10));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 169, Tile.TILEWIDTH * 14));

		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 41, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 24, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 49, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 54, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 30, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 18, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 137, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 144, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 160, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 174, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 172, Tile.TILEWIDTH * 17));

		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 69, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 70, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 86, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 87, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 88, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 152, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 153, Tile.TILEWIDTH * 19));

		loadMap(path, w, h);

	}

	// Captura os eventos no mapa
	@Override
	public void eventsMap() {
		eventsMapFonts();
		entityManager.eventsEntities();
	}

	// Desenha o mapa e seus elementos
	@Override
	public void drawMap(Graphics g) {
		int xStart = (int) Math.max(0, handler.getCamera().getXFloat() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getXFloat() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		for (int y = 0; y < height; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).drawTile(g, (int) (x * Tile.TILEWIDTH - handler.getCamera().getXFloat()),
						(int) (y * Tile.TILEHEIGHT));

			}
		}
		entityManager.drawEntities(g);
		drawMapFonts(g);

	}

	@Override
	public void eventsMapFonts() {
		// TODO Auto-generated method stub
		if (handler.getWorld().getEntityManager().getPlayer().getX() > 197 * Tile.TILEWIDTH) {
			Audio.play(Assets.audioVictory, false);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			handler.setWorld(new MapLevel2(handler, "res/Maps/MapaLevel2.csv", 230, 21, "1  2", 400));
		}

	}

	@Override
	public void drawMapFonts(Graphics g) {
		Text.drawString(g, "MARIO", 50, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, entityManager.getPlayer().getScore() + "", 50, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "COINS", 250, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, "x00", 250, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "WORLD", 400, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, nameMap, 415, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "TIME", 550, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, "" + mapTime, 550, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "" + entityManager.getPlayer().getnLifes(), 650, 75, false, Color.WHITE, Assets.font);
	}

}
