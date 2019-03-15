package mario.maps;

import java.awt.Color;
import java.awt.Graphics;

import mario.entity.creature.Gobu;
import mario.entity.statics.Hole;
import mario.entity.statics.LuckyBlock;
import mario.game.Handler;
import mario.graphics.Assets;
import mario.graphics.Audio;
import mario.graphics.Text;
import mario.states.MenuState;
import mario.states.State;
import mario.tiles.Tile;

public class MapLevel2 extends Map{

	public MapLevel2(Handler handler, String path, int w, int h, String nameMap, int mapTime) {
		super(handler, path, w, h, nameMap, mapTime);
		// TODO Auto-generated constructor stub
		
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 13, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 12, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 11, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 10, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 9, Tile.TILEWIDTH * 14));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 42, Tile.TILEWIDTH * 8));
		entityManager.addEntity(new LuckyBlock(handler, Tile.TILEWIDTH * 43, Tile.TILEWIDTH * 8));
		
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 81, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 82, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 83, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 120, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 121, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 124, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 125, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 138, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 139, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 140, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 141, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 142, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 143, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 152, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 153, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 154, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 155, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 156, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 157, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 175, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 176, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 177, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 182, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 183, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 184, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 189, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 190, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 191, Tile.TILEWIDTH * 19));
		entityManager.addEntity(new Hole(handler, Tile.TILEWIDTH * 192, Tile.TILEWIDTH * 19));
		
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 28, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 106, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 112, Tile.TILEWIDTH * 17));
		entityManager.addEntity(new Gobu(handler, Tile.TILEWIDTH * 197, Tile.TILEWIDTH * 17));
		
		loadMap(path, w, h);
	}

	@Override
	public void eventsMap() {
		eventsMapFonts();
		entityManager.eventsEntities();
		
	}

	@Override
	public void drawMap(Graphics g) {
		int xStart = (int) Math.max(0, handler.getCamera().getXFloat() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getXFloat() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		for (int y = 0; y < height; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).drawTile(g, (int) (x * Tile.TILEWIDTH - handler.getCamera().getXFloat()),(int) (y * Tile.TILEHEIGHT));
				
			}
		}
		entityManager.drawEntities(g);
		drawMapFonts(g);
		
	}

	@Override
	public void eventsMapFonts() {
		if (handler.getWorld().getEntityManager().getPlayer().getX() > 221 * Tile.TILEWIDTH) {
			Audio.play(Assets.audioVictory, false);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			State.setState(new MenuState(handler));
		}
		
	}

	@Override
	public void drawMapFonts(Graphics g) {
		// TODO Auto-generated method stub
		Text.drawString(g, "MARIO", 50, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, entityManager.getPlayer().getScore()+"", 50, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "COINS", 250, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, "x00", 250, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "WORLD", 400, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, nameMap, 415, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, "TIME", 550, 50, false, Color.WHITE, Assets.font);
		Text.drawString(g, ""+mapTime, 550, 75, false, Color.WHITE, Assets.font);
		Text.drawString(g, ""+entityManager.getPlayer().getnLifes(), 650, 75, false, Color.WHITE, Assets.font);
		
	}
	

}
