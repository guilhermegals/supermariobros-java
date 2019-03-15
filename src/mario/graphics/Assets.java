package mario.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

//Classe para armazenar as imagens do jogo
public class Assets {

	private static final int width = 16, height = 16;

	public static BufferedImage[] playerLeft, playerRight;
	public static BufferedImage playerJumpRight, playerJumpLeft;
	public static BufferedImage[] gobu;
	public static BufferedImage[] luckyBlock;
	public static BufferedImage lava;
	
	public static BufferedImage tiles;

	public static BufferedImage menu;
	public static BufferedImage[] tick;
	
	public static Font font;
	
	public static String audioJump, audioSong, audioDeath, audioVictory, audioCoin;

	
	//Carrega todas a imagens
	public static void load() {
		SpriteSheet sheetTile = new SpriteSheet(ImageLoader.loadImage("/Map.png"));
		SpriteSheet sheetState = new SpriteSheet(ImageLoader.loadImage("/States/Estados.png"));
		SpriteSheet sheetPlayer = new SpriteSheet(ImageLoader.loadImage("/Mario.png"));
		SpriteSheet sheetCreature = new SpriteSheet(ImageLoader.loadImage("/Chars.png"));
		SpriteSheet sheetEntity = new SpriteSheet(ImageLoader.loadImage("/Entity.png"));

		playerLeft = new BufferedImage[4];
		playerRight = new BufferedImage[4];
		gobu = new BufferedImage[3];
		luckyBlock = new BufferedImage[5];
		tick = new BufferedImage[2];
		
		audioJump = "res/Music/Jump.wav";
		audioSong = "res/Music/Song.wav";
		audioDeath = "res/Music/Morte.wav";
		audioVictory = "res/Music/LevelComplet.wav";
		audioCoin = "res/Music/Coin.wav";
		
		
		tiles = sheetTile.slice(0, 0, 304, 192);

		playerRight[3] = sheetPlayer.slice(211, 0, 16, 16);
		playerRight[1] = sheetPlayer.slice(241, 0, 16, 16);
		playerRight[2] = sheetPlayer.slice(272, 0, 16, 16);
		playerRight[0] = sheetPlayer.slice(300, 0, 16, 16);

		playerLeft[3] = sheetPlayer.slice(181, 0, 16, 16);
		playerLeft[1] = sheetPlayer.slice(150, 0, 16, 16);
		playerLeft[2] = sheetPlayer.slice(121, 0, 16, 16);
		playerLeft[0] = sheetPlayer.slice(89, 0, 16, 16);

		playerJumpLeft = sheetPlayer.slice(29, 0, 16, 16);
		playerJumpRight = sheetPlayer.slice(359, 0, 16, 16);
		
		lava = sheetTile.slice(128, 80, width, height);

		luckyBlock[4] = sheetTile.slice(176, 0, width, height);
		luckyBlock[1] = sheetEntity.slice(width * 0, 80, width, height);
		luckyBlock[2] = sheetEntity.slice(width * 1, 80, width, height);
		luckyBlock[3] = sheetEntity.slice(width * 2, 80, width, height);
		luckyBlock[0] = sheetEntity.slice(width * 3, 80, width, height);

		gobu[2] = sheetCreature.slice(277, 187, width, height);
		gobu[1] = sheetCreature.slice(296, 187, width, height);
		gobu[0] = sheetCreature.slice(315, 187, width, height);

		menu = sheetState.slice(0, 0, 1280/2, 640/2);
		tick[0] = sheetState.slice(640, 0, 210, 30);
		tick[1] = sheetState.slice(640, 30, 210, 30);
		
		font = FontLoader.loadFont("res/Fonts/Arcade.ttf", 30);
		
	}

}
