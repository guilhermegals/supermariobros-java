package mario.maps;

import java.awt.Graphics;

import mario.entity.Entity;
import mario.entity.EntityManager;
import mario.entity.creature.Mario;
import mario.game.Handler;
import mario.graphics.Assets;
import mario.tiles.Tile;
import mario.utils.Utils;

public abstract class Map {
	protected String nameMap;
	protected int width, height;
	protected int[][] idTile;
	protected Handler handler;
	protected int mapTime;
	protected float timer;

	protected Tile[] tile = new Tile[277];

	protected EntityManager entityManager;

	// Construtor
	public Map(Handler handler, String path, int w, int h, String nameMap, int mapTime) {
		this.mapTime = mapTime;
		this.nameMap = nameMap;
		this.handler = handler;
		entityManager = new EntityManager(handler, new Mario(handler, 40, 200));

		int aux = 0;
		for (int j = 0; j < (Assets.tiles.getHeight() / 16); j++) {
			for (int i = 0; i < (Assets.tiles.getWidth() / 16); i++) {
				tile[aux] = new Tile(Assets.tiles.getSubimage(i * 16, j * 16, 16, 16), (aux), false);
				aux++;
			}
		}

		tile[48].setSolid(true);
		tile[131].setSolid(true);
		tile[41].setSolid(true);
		tile[42].setSolid(true);
		tile[60].setSolid(true);
		tile[61].setSolid(true);
		tile[2].setSolid(true);
		tile[10].setSolid(true);
		tile[29].setSolid(true);
		tile[67].setSolid(true);
		tile[68].setSolid(true);
		tile[103].setSolid(true);
		tile[1].setSolid(true);
		tile[50].setSolid(true);
		tile[3].setSolid(true);
		tile[12].setSolid(true);
		tile[31].setSolid(true);
		tile[69].setSolid(true);
		tile[70].setSolid(true);
		
		tile[103].setHurt(true);

	}

	// Carrega o mapa
	protected void loadMap(String path, int w, int h) {
		width = w;
		height = h;
		String file = Utils.loadFileAsString(path);
		String[] str = file.split("-|,|\\s+");

		idTile = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				idTile[x][y] = Utils.parseInt(str[(x + y * width)]);
			}
		}
	}
	

	// Função abstrata dos eventos de um Mapa
	public abstract void eventsMap();

	// Função asbtrata para desenhar um mapa
	public abstract void drawMap(Graphics g);

	// Função abstrata dos eventos dos textos de uma mapa
	public abstract void eventsMapFonts();

	// Função asbstrata para desenhar os textos de um mapa
	public abstract void drawMapFonts(Graphics g);

	// Retorna o tile pesquisado
	public Tile getTile(int x, int y) {
		Tile t = tile[idTile[x][y]];
		return t;
	}

	// Get e Set

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
