package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.GameController;
import domain.*;

public class FieldPanel extends JPanel implements Observer, KeyListener {
	
	private GameController controller;
	
	public FieldPanel(GameController controller) {
		super();
		this.controller = controller;
		addKeyListener(this);
		setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		this.setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
		update();
	}

	public GameController getController() {
		return controller;
	}

	public void setController(GameController controller) {
		this.controller = controller;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		paintRoundElement(graphics, controller.getGame().getToEat());
		for(GameObject gameObject: controller.getGame().getSnake().getParts()) {
			paintSquareElement(graphics, gameObject);
		}
	}
	
	private void paintSquareElement(Graphics graphics, GameObject element) {
		graphics.setColor(element.getColor());
		graphics.fillRoundRect(element.getLeft(), element.getTop(), element.getPixels(), element.getPixels(), 20, 20);
		graphics.setColor(element.getBorderColor());
		graphics.drawRoundRect(element.getLeft(), element.getTop(), element.getPixels(), element.getPixels(), 20, 20);
	}
	
	private void paintRoundElement(Graphics graphics, GameObject element) {
		graphics.setColor(element.getColor());
		graphics.fillRoundRect(element.getLeft(), element.getTop(), element.getPixels(), element.getPixels(), 60, 60);
		graphics.setColor(element.getBorderColor());
		graphics.drawRoundRect(element.getLeft(), element.getTop(), element.getPixels(), element.getPixels(), 60, 60);
	}
	
	public void update() {
		this.requestFocus();
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(controller.getGame().getStatus() == StartableStatus.RESUMED || controller.getGame().getStatus() == StartableStatus.STARTED) {
			if(c == KeyEvent.VK_LEFT && controller.getGame().getSnake().getParts().get(0).getSpeed().getX() <= 0) {
				controller.getGame().moveSnakeLeft();
			}
			if(c == KeyEvent.VK_RIGHT && controller.getGame().getSnake().getParts().get(0).getSpeed().getX() >= 0) {
				controller.getGame().moveSnakeRight();
			}
			if(c == KeyEvent.VK_UP && controller.getGame().getSnake().getParts().get(0).getSpeed().getY() <= 0) {
				controller.getGame().moveSnakeUp();
			}
			if(c == KeyEvent.VK_DOWN && controller.getGame().getSnake().getParts().get(0).getSpeed().getY() >= 0) {
				controller.getGame().moveSnakeDown();
			}
			if(c == KeyEvent.VK_ESCAPE) {
				controller.getGame().pause();
			}
		}
		
	} 
		 
	public void keyTyped(KeyEvent event) { 
		
	} 
		 
	public void keyReleased(KeyEvent event) { 
	} 

}
