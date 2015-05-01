package domain;

import java.awt.Color;

public class GameObject implements Cloneable {
	
	private int pixels;
	private Color color;
	private Color borderColor;
	private Point speed;
	private Point position;
	
	public GameObject(int pixels, Color color, Color borderColor, Point speed, Point position) {
		super();
		this.pixels = pixels;
		this.color = color;
		this.borderColor = borderColor;
		this.speed = speed;
		this.position = position;
	}

	public GameObject(int pixels, Color color, Color borderColor, Point position) {
		super();
		this.pixels = pixels;
		this.color = color;
		this.borderColor = borderColor;
		this.position = position;
	}

	public int getPixels() {
		return pixels;
	}

	public void setPixels(int pixels) {
		this.pixels = pixels;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getSpeed() {
		return speed;
	}

	public void setSpeed(Point speed) {
		this.speed = speed;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getTop() {
		return position.getY();
	}
	
	public int getLeft() {
		return position.getX();
	}
	
	public int getBottom() {
		return position.getY() + pixels;
	}
	
	public int getRight() {
		return position.getX() + pixels;
	}


}
