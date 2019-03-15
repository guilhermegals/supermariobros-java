package mario.entity.statics;

import mario.entity.Entity;
import mario.game.Handler;
import mario.graphics.Animation;


//Classe abstrata para definir entidades do tipo estática, que não movem
public abstract class StaticEntity extends Entity{
	
	//Construtor
	public StaticEntity(Handler handler, float x, float y, int width, int height, boolean hurt, int idEnty) {
		super(handler, x, y, width, height,hurt, idEnty);
	}

}
