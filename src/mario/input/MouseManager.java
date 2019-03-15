package mario.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftClick, rightClick;
	private int mouseX, mouseY;
	
	public MouseManager() {
		
	}
	
	//Botao do mouse que foi clicado
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			leftClick = true;
		}else{
			rightClick = true;
		}
		
	}

	//Botao do mouse que foi solto
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			leftClick = false;
		}else{
			rightClick = false;
		}
		
	}
	
	//Quando o mouse se movimenta
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	//Get e Set
	
	public boolean isLeftClick() {
		return leftClick;
	}

	public boolean isRightClick() {
		return rightClick;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	
	
	//Outras implementações do mouse
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
