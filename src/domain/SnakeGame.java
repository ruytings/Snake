package domain;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.SnakeView;

public class SnakeGame extends StartableObject implements Subject, Observer {
	
	private SnakeObject snake;
	private GameObject toEat;
	private int score = 0;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private Chronometer chronometer;
	private int pointCounter;
	private int level = 1;
	
	public SnakeGame(Chronometer chronometer) {
		this.snake = new SnakeObject();
		this.toEat = new GameObject(40, Color.YELLOW, Color.YELLOW, findEmptySpot());
		this.chronometer = chronometer;
		start();
		chronometer.start();
	}

	public SnakeObject getSnake() {
		return snake;
	}

	public void setSnake(SnakeObject snake) {
		this.snake = snake;
		notifyObservers();
	}

	public GameObject getToEat() {
		return toEat;
	}

	public void setToEat(GameObject toEat) {
		this.toEat = toEat;
		notifyObservers();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		if(score > 1000*level) {
			level++;
		}
		notifyObservers();
	}
	
	public Chronometer getChronometer() {
		return chronometer;
	}

	public void setChronometer(Chronometer chronometer) {
		this.chronometer = chronometer;
	}

	public Point findEmptySpot() {
		int numberX = 0;
		int numberY = 0;
		boolean stop = false;
		while(!stop) {
			numberX = (int) Math.floor(Math.random()*15)*40;
			numberY = (int) Math.floor(Math.random()*12)*40;
			int partsNotHit = 0;
			int totalParts = this.getSnake().getParts().size();
			for(GameObject object : this.getSnake().getParts()) {
				if(numberX != object.getLeft() && numberY != object.getTop()) {
					partsNotHit++;
				}
			}
			if(partsNotHit == totalParts) {
				stop = true;
			}
		}
		return new Point(numberX, numberY);
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
	}
	
	public void moveSnakeLeft() {
		this.getSnake().moveLeft();
		notifyObservers();
	}
	
	public void moveSnakeRight() {
		this.getSnake().moveRight();
		notifyObservers();
	}
	
	public void moveSnakeUp() {
		this.getSnake().moveUp();
		notifyObservers();
	}
	
	public void moveSnakeDown() {
		this.getSnake().moveDown();
		notifyObservers();
	}
	
	private boolean willEat() {
		if(toEat.getPosition().getX() == snake.getParts().get(0).getPosition().getX() && toEat.getPosition().getY() == snake.getParts().get(0).getPosition().getY()) {
			return true;
		} else return false;
	}
	
	private boolean hitsSnake() {
		for(int i = 1; i < snake.getParts().size(); i++) {
			if(snake.getParts().get(0).getPosition().getX() == snake.getParts().get(i).getPosition().getX() && snake.getParts().get(0).getPosition().getY() == snake.getParts().get(i).getPosition().getY()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hitWall() {
		GameObject head = snake.getParts().get(0);
		if(head.getLeft() < 0 || head.getTop() < 0 || head.getBottom() > 520 || head.getRight() > 600) {
			return true;
		}
		return false;
	}
	
	private void reset() {
		setScore(0);
		setPointCounter(0);
		setSnake(new SnakeObject());
		toEat = new GameObject(40, Color.YELLOW, Color.YELLOW, findEmptySpot());
		start();
		notifyObservers();
	}

	public void update() {
		pointCounter++;
		if(hitsSnake() || hitWall()) {
			int reply = JOptionPane.showConfirmDialog(null, "Je behaalde een score van " + getScore() + ". Opnieuw spelen?","Game Over", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
		          this.reset();
		        }
		        else {
		           this.stop();
		           System.exit(0);
		        }
		} else {
			if(willEat()) {
				this.getSnake().moveEat();
				toEat.setPosition(findEmptySpot());
				if(pointCounter < 110) {
					this.setScore(this.getScore() + 110 - pointCounter);
					this.setPointCounter(0);
				} else {
					this.setScore(this.getScore() + 15);
					this.setPointCounter(0);
				}
			} else {
				this.getSnake().move();
			}
			notifyObservers();
		}
	}
	
	public void setPointCounter(int number) {
		this.pointCounter = number;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void pause() {
		this.stop();
		this.getChronometer().stop();
		JOptionPane.showMessageDialog(null, "Druk op OK om verder te spelen.", "Spel gepauzeerd", JOptionPane.INFORMATION_MESSAGE);
		this.start();
		this.getChronometer().start();
	}

	
	

}
