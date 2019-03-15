package mario.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text {

	public static void drawString(Graphics g, String txt, int posX, int posY, boolean center, Color c, Font font) {
		g.setColor(c);
		g.setFont(font);
		int x = posX, y = posY;
		if(center){
			
		}
		
		g.drawString(txt, x, y);
	}
}
