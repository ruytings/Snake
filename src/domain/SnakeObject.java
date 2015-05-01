package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class SnakeObject {
	
	private ArrayList<GameObject> parts = new ArrayList<GameObject>();
	
	public SnakeObject() {
		Color color = Color.BLACK;
		Color borderColor = Color.YELLOW;
		int xPosition = 400;
		int yPosition = 240;
		Point speed = new Point(-40, 0);
		int pixels = 40;
		int xExtra = 0;
		for(int i = 0; i < 5; i++) {
			GameObject snakePart = new GameObject(pixels, color, borderColor, speed, new Point(xPosition + xExtra, yPosition));
			parts.add(snakePart);
			xExtra = xExtra + 40;
		}
	}

	public ArrayList<GameObject> getParts() {
		return parts;
	}

	public void setParts(ArrayList<GameObject> parts) {
		this.parts = parts;
	}
	
	public void moveLeft() {
		parts.get(0).setSpeed(new Point(-40, 0));
	}
	
	public void moveRight() {
		parts.get(0).setSpeed(new Point(40, 0));
	}
	
	public void moveUp() {
		parts.get(0).setSpeed(new Point(0, -40));
	}
	
	public void moveDown() {
		parts.get(0).setSpeed(new Point(0, 40));
	}
	
	public void eatLeft() {
		if(parts.get(0).getSpeed().getX() <= 0) {
			ArrayList<GameObject> newParts = new ArrayList<GameObject>();
			Point newPositionFirst = new Point(parts.get(0).getPosition().getX() - 40, parts.get(0).getPosition().getY());
			parts.get(0).setSpeed(new Point(-40, 0));
			GameObject newFirst = new GameObject(parts.get(0).getPixels(), parts.get(0).getColor(), parts.get(0).getBorderColor(), parts.get(0).getSpeed(), newPositionFirst);
			newParts.add(newFirst);
			newParts.get(0).setPosition(newPositionFirst);
			for(int i = 0; i < parts.size(); i++) {
				parts.get(i).setSpeed(new Point(-40, 0));
				newParts.add(parts.get(i));
			}
			setParts(newParts);
		}
	}
	
	public void eatRight() {
		if(parts.get(0).getSpeed().getX() >= 0) {
			ArrayList<GameObject> newParts = new ArrayList<GameObject>();
			Point newPositionFirst = new Point(parts.get(0).getPosition().getX() + 40, parts.get(0).getPosition().getY());
			parts.get(0).setSpeed(new Point(40, 0));
			GameObject newFirst = new GameObject(parts.get(0).getPixels(), parts.get(0).getColor(), parts.get(0).getBorderColor(), parts.get(0).getSpeed(), newPositionFirst);
			newParts.add(newFirst);
			newParts.get(0).setPosition(newPositionFirst);
			for(int i = 0; i < parts.size(); i++) {
				parts.get(i).setSpeed(new Point(40, 0));
				newParts.add(parts.get(i));
			}
			setParts(newParts);
		}
	}
	
	public void eatUp() {
		if(parts.get(0).getSpeed().getY() <= 0) {
			ArrayList<GameObject> newParts = new ArrayList<GameObject>();
			Point newPositionFirst = new Point(parts.get(0).getPosition().getX(), parts.get(0).getPosition().getY() - 40);
			parts.get(0).setSpeed(new Point(0, -40));
			GameObject newFirst = new GameObject(parts.get(0).getPixels(), parts.get(0).getColor(), parts.get(0).getBorderColor(), parts.get(0).getSpeed(), newPositionFirst);
			newParts.add(newFirst);
			newParts.get(0).setPosition(newPositionFirst);
			for(int i = 0; i < parts.size(); i++) {
				parts.get(i).setSpeed(new Point(0, -40));
				newParts.add(parts.get(i));
			}
			setParts(newParts);
		}
	}
	
	public void eatDown() {
		if(parts.get(0).getSpeed().getY() >= 0) {
			ArrayList<GameObject> newParts = new ArrayList<GameObject>();
			Point newPositionFirst = new Point(parts.get(0).getPosition().getX(), parts.get(0).getPosition().getY() + 40);
			parts.get(0).setSpeed(new Point(0, 40));
			GameObject newFirst = new GameObject(parts.get(0).getPixels(), parts.get(0).getColor(), parts.get(0).getBorderColor(), parts.get(0).getSpeed(), newPositionFirst);
			newParts.add(newFirst);
			newParts.get(0).setPosition(newPositionFirst);
			for(int i = 0; i < parts.size(); i++) {
				parts.get(i).setSpeed(new Point(0, 40));
				newParts.add(parts.get(i));
			}
			setParts(newParts);
		}
	}
	
	public void move() {
		ArrayList<GameObject> newParts = new ArrayList<GameObject>();
		Point newPositionFirst = new Point(parts.get(0).getPosition().getX() + parts.get(0).getSpeed().getX(), parts.get(0).getPosition().getY() + parts.get(0).getSpeed().getY());
		GameObject newFirst = new GameObject(parts.get(0).getPixels(), parts.get(0).getColor(), parts.get(0).getBorderColor(), parts.get(0).getSpeed(), newPositionFirst);
		newParts.add(newFirst);
		newParts.get(0).setPosition(newPositionFirst);
		for(int i = 0; i < parts.size()-1; i++) {
			newParts.add(parts.get(i));
		}
		setParts(newParts);
	}
	
	public void moveEat() {
		ArrayList<GameObject> newParts = new ArrayList<GameObject>();
		Point newPositionFirst = new Point(parts.get(0).getPosition().getX() + parts.get(0).getSpeed().getX(), parts.get(0).getPosition().getY() + parts.get(0).getSpeed().getY());
		GameObject newFirst = new GameObject(parts.get(0).getPixels(), parts.get(0).getColor(), parts.get(0).getBorderColor(), parts.get(0).getSpeed(), newPositionFirst);
		newParts.add(newFirst);
		newParts.get(0).setPosition(newPositionFirst);
		for(int i = 0; i < parts.size(); i++) {
			newParts.add(parts.get(i));
		}
		setParts(newParts);
	}
}
